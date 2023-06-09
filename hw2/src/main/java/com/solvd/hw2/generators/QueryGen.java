package com.solvd.hw2.generators;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.hw2.CustomPool;
import com.solvd.hw2.lambda.Concaters;
import com.solvd.hw2.models.abstracts.Model;

public class QueryGen 
{
    private static final Logger LOGGER = LogManager.getLogger("Query Gen");

    public static PreparedStatement genInsert(Model obj, String table) throws SQLException
    {
        ArrayList<String> fields = obj.getFields();
        ArrayList<Object> vals = obj.getVals();

        String query = "insert into " + table + " (";

        query = query.concat(Concaters.ARRAY_LIST_STRING_CONCAT.concatArrayList(fields, ", "));
        query = query.substring(0, query.length() - 2);
        query = query.concat(") values (");

        query = query.concat(Concaters.CONCATER.concatXTimes("?, ", fields.size()));
        query = query.substring(0, query.length() - 2);
        query = query.concat(");");

        PreparedStatement ret = makeStatement(query, vals);

        return ret;
    }


    public static PreparedStatement genUpdate(Model newVals, String table, Model criteria, String condition) throws SQLException
    {
        ArrayList<String> fields = newVals.getFields();
        ArrayList<Object> vals = newVals.getVals();
        ArrayList<Object> criteriaVals = criteria.getVals();

        ArrayList<Object> allVals = new ArrayList<Object>();
        vals.forEach((Object o) -> allVals.add(o));


        if (!condition.equals(""))
        {
            criteriaVals.forEach((Object o) -> allVals.add(o));
        }

        String query = "update " + table + " set ";
        query = query.concat(Concaters.ARRAY_LIST_STRING_CONCAT.concatArrayList(fields, " = " + "?, "));
        query = query.substring(0, query.length() - 2);
        query = query.concat(condition);

        PreparedStatement ret = makeStatement(query, allVals);
        return ret;
    }


    public static PreparedStatement genDelete(Model toDelete, String table, String condition) throws SQLException
    {
        ArrayList<Object> vals = toDelete.getVals();

        String query = "delete from " + table + condition;

        PreparedStatement ret = makeStatement(query, vals);
        return ret;
    }


    public static PreparedStatement genSelect(ArrayList<String> fields, String table, Model criteria, String condition) throws SQLException
    {
        ArrayList<Object> vals = criteria.getVals();
        ArrayList<Object> allVals = new ArrayList<Object>();
        vals.forEach((Object o) -> allVals.add(o));

        String query = "select ";

        //Currently defaults to everything if all fields are null, should probably change later
        if (fields.size() == 0)
        {
            query = query.concat("*");
        }

        else
        {
            query = query.concat(Concaters.ARRAY_LIST_STRING_CONCAT.concatArrayList(fields, ", "));            
            query = query.substring(0, query.length() - 2);
        }

        query = query.concat(" from " + table);
        query = query.concat(condition);

        PreparedStatement ret = makeStatement(query, vals);

        return ret;
    }


    public static PreparedStatement makeStatement(String baseQuery, ArrayList<Object> vals) throws SQLException
    {
        PreparedStatement ret = CustomPool.getConn().prepareStatement(baseQuery);
        int startingIndex = 0;
        int statementIndex = startingIndex + 1;
        int maxIndex = vals.size();

        for (int i = startingIndex; i < maxIndex; i++)
        {
            if (vals.get(i) instanceof Integer)
            {
                ret.setInt(statementIndex, (int) vals.get(i));
            }

            else
            {
                ret.setString(statementIndex, (String) vals.get(i));
            }

            statementIndex++;
        }

        //Left in case I need to renable for testing
        //LOGGER.info(ret.toString());
        return ret;
    }
}

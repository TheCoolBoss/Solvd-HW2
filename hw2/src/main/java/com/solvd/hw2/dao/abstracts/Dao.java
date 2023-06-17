package com.solvd.hw2.dao.abstracts;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.hw2.CustomPool;
import com.solvd.hw2.generators.*;
import com.solvd.hw2.lambda.Concaters;
import com.solvd.hw2.models.abstracts.Model;

public abstract class Dao 
{
    private static final Logger LOGGER = LogManager.getLogger("Main DAO");

    public void insert(Model toInsert, String table) 
    {
        try
        {
            PreparedStatement newModel = QueryGen.genInsert(toInsert, table, Concaters.CONCATER, Concaters.ARRAY_LIST_STRING_CONCAT);
            newModel.executeUpdate();
            CustomPool.releaseConn();
        }

        catch (SQLException sqle)
        {
            LOGGER.error(sqle.getMessage());
        }
    }


    public void update(Model newVals, Model criteriaVals, String table, String operator)
    {
        try
        {
            PreparedStatement updatedModel = QueryGen.genUpdate(newVals, table, criteriaVals, ConditionGen.makeBasicWhere(criteriaVals.getFields(), operator), Concaters.ARRAY_LIST_STRING_CONCAT);
            updatedModel.executeUpdate();
            CustomPool.releaseConn();
        }

        catch (SQLException sqle)
        {
            LOGGER.error(sqle.getMessage());
        }
    }

    public void delete(Model criteriaVals, String table, String operator)
    {
        try
        {
            PreparedStatement updatedModel = QueryGen.genDelete(criteriaVals, table, ConditionGen.makeBasicWhere(criteriaVals.getFields(), operator));
            updatedModel.executeUpdate();
            CustomPool.releaseConn();
        }

        catch (SQLException sqle)
        {
            LOGGER.error(sqle.getMessage());
        }
    }

    public ResultSet getSelectResults(ArrayList<String> fields, Model criteriaVals, String table, String operator) throws SQLException
    {
        PreparedStatement stmt = QueryGen.genSelect(fields, table, criteriaVals, ConditionGen.makeBasicWhere(criteriaVals.getFields(), operator), Concaters.ARRAY_LIST_STRING_CONCAT);
        return stmt.executeQuery();
    }
}

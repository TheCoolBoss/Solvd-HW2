package com.solvd.hw2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.hw2.CustomPool;
import com.solvd.hw2.dao.abstracts.Dao;
import com.solvd.hw2.models.Degree;

public class DegreeDao extends Dao
{
    private static final Logger LOGGER = LogManager.getLogger("Degree DAO");
    private final String DEGREE_TABLE = "degrees";
    private final String ID_COL = "degreeId";
    private final String NAME_COL = "name";
    private final String YEAR_COL = "numOfYears";

    public List<Degree> select(ArrayList<String> fields, Degree criteriaVals, String operator)
    {
        try
        {
            ArrayList<Degree> ret = new ArrayList<Degree>();
            ResultSet results = getSelectResults(fields, criteriaVals, DEGREE_TABLE, operator);

            while (results.next())
            {
                Integer newId = null;
                String name = null;
                Integer years = null;

                for (int i = 1; i <= results.getMetaData().getColumnCount(); i++)
                {
                    if (results.getMetaData().getColumnLabel(i).equals(ID_COL))
                    {
                        newId = results.getInt(i);
                    }

                    else if (results.getMetaData().getColumnLabel(i).equals(NAME_COL))
                    {
                        name = results.getString(i);
                    }

                    else if (results.getMetaData().getColumnLabel(i).equals(YEAR_COL))
                    {
                        years = results.getInt(i);
                    }
                }

                ret.add(new Degree(newId, name, years));
            }
            
            CustomPool.releaseConn();
            return ret;
        }

        catch (SQLException sqle)
        {
            LOGGER.error(sqle.getMessage());
            return null;
        }
    }
}

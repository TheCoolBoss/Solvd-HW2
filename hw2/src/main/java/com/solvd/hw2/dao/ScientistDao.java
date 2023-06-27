package com.solvd.hw2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.hw2.CustomPool;
import com.solvd.hw2.dao.abstracts.Dao;
import com.solvd.hw2.models.*;

public class ScientistDao extends Dao
{
    private static final Logger LOGGER = LogManager.getLogger("Scientist DAO");
    private static final String SCIENTIST_TABLE = "scientists";
    private static final String ID_COL = "scientistId";
    private static final String FIRST_NAME_COL = "firstName";
    private static final String LAST_NAME_COL = "lastName";
    private static final String DEGREE_COL = "degreeId"; 

    public List<Scientist> select(ArrayList<String> fields, Scientist criteriaVals, String operator)
    {
        try
        {
            ArrayList<Scientist> ret = new ArrayList<Scientist>();
            ResultSet results = getSelectResults(fields, criteriaVals, SCIENTIST_TABLE, operator);

            while (results.next())
            {
                Integer newId = null;
                String firstName = null;
                String lastName = null;
                Degree degree = new Degree(null, null, null);

                for (int i = 1; i <= results.getMetaData().getColumnCount(); i++)
                {
                    if (results.getMetaData().getColumnLabel(i).equals(ID_COL))
                    {
                        newId = results.getInt(i);
                    }

                    else if (results.getMetaData().getColumnLabel(i).equals(FIRST_NAME_COL))
                    {
                        firstName = results.getString(i);
                    }

                    else if (results.getMetaData().getColumnLabel(i).equals(LAST_NAME_COL))
                    {
                        lastName = results.getString(i);
                    }

                    else if (results.getMetaData().getColumnLabel(i).equals(DEGREE_COL))
                    {
                        degree.setId(results.getInt(i));
                    }
                }

                ret.add(new Scientist(newId, firstName, lastName, degree));
            }
            
            CustomPool.releaseConn();
            return ret;
        }

        catch (SQLException | InterruptedException sqle)
        {
            LOGGER.error(sqle.getMessage());
            return null;
        }
    }      
}

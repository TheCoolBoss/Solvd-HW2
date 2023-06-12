package com.solvd.hw2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.hw2.CustomPool;
import com.solvd.hw2.dao.abstracts.Dao;
import com.solvd.hw2.models.Assistant;
import com.solvd.hw2.models.Scientist;

public class AssistantDao extends Dao
{
    private static final Logger LOGGER = LogManager.getLogger("Assistant DAO");
    private static final String ASSISTANT_TABLE = "assistants";
    private static final String ID_COL = "assistantId";
    private static final String FIRST_NAME_COL = "firstName";
    private static final String LAST_NAME_COL = "lastName";
    private static final String ASSISTEE_COL = "assisteeId";
    

    public List<Assistant> select(ArrayList<String> fields, Assistant criteriaVals, String operator)
    {
        try
        {
            ArrayList<Assistant> ret = new ArrayList<Assistant>();
            ResultSet results = getSelectResults(fields, criteriaVals, ASSISTANT_TABLE, operator);

            while (results.next())
            {
                Integer newId = null;
                String firstName = null;
                String lastName = null;
                Scientist newScientist = new Scientist(null, null, null, null);

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

                    else if (results.getMetaData().getColumnLabel(i).equals(ASSISTEE_COL))
                    {
                        newScientist.setId(results.getInt(i));
                    }
                }

                ret.add(new Assistant(newId, firstName, lastName, newScientist));
            }
            
            CustomPool.closeConn();
            return ret;
        }

        catch (SQLException sqle)
        {
            LOGGER.error(sqle.getMessage());
            return null;
        }
    }
}

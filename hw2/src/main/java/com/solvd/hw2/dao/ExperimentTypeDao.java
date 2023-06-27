package com.solvd.hw2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.hw2.CustomPool;
import com.solvd.hw2.dao.abstracts.Dao;
import com.solvd.hw2.models.ExperimentType;

public class ExperimentTypeDao extends Dao
{
    private static final Logger LOGGER = LogManager.getLogger("Experiment Type DAO");
    private static final String EXPERIMENT_TYPE_TABLE = "experimentTypes";
    private static final String ID_COL = "expTypeId";
    private static final String TYPE_COL = "expTypeName";

    public List<ExperimentType> select(ArrayList<String> fields, ExperimentType criteriaVals, String operator)
    {
        try
        {
            ArrayList<ExperimentType> ret = new ArrayList<ExperimentType>();
            ResultSet results = getSelectResults(fields, criteriaVals, EXPERIMENT_TYPE_TABLE, operator);

            while (results.next())
            {
                Integer newId = null;
                String name = null;

                for (int i = 1; i <= results.getMetaData().getColumnCount(); i++)
                {
                    if (results.getMetaData().getColumnLabel(i).equals(ID_COL))
                    {
                        newId = results.getInt(i);
                    }

                    else if (results.getMetaData().getColumnLabel(i).equals(TYPE_COL))
                    {
                        name = results.getString(i);
                    }
                }

                ret.add(new ExperimentType(newId, name));
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

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

public class LabDao extends Dao
{
    private static final Logger LOGGER = LogManager.getLogger("Lab DAO");
    private static final String ID_COL = "labId";
    private static final String NAME_COL = "labName";
    private static final String LOCATION_COL = "locationId";
    private static final String INST_COL = "institutionId";
    private static final String LAB_TABLE = "labs";

    public List<Lab> select(ArrayList<String> fields, Lab criteriaVals, String operator)
    {
        try
        {
            ArrayList<Lab> ret = new ArrayList<Lab>();
            ResultSet results = getSelectResults(fields, criteriaVals, LAB_TABLE, operator);

            while (results.next())
            {
                Integer newId = null;
                String newName = null;
                Location loc = new Location(null, null, null);
                Institution inst = new Institution(null, null);

                for (int i = 1; i <= results.getMetaData().getColumnCount(); i++)
                {
                    if (results.getMetaData().getColumnLabel(i).equals(ID_COL))
                    {
                        newId = results.getInt(i);
                    }

                    else if (results.getMetaData().getColumnLabel(i).equals(NAME_COL))
                    {
                        newName = results.getString(i);
                    }

                    else if (results.getMetaData().getColumnLabel(i).equals(LOCATION_COL))
                    {
                        loc.setId(results.getInt(i));
                    }

                    else if (results.getMetaData().getColumnLabel(i).equals(INST_COL))
                    {
                        inst.setId(results.getInt(i));
                    }
                }

                ret.add(new Lab(newId, newName, loc, inst));
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

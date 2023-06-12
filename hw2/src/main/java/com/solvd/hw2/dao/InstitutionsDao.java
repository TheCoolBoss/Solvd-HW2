package com.solvd.hw2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.hw2.CustomPool;
import com.solvd.hw2.dao.abstracts.Dao;
import com.solvd.hw2.models.Institution;

public class InstitutionsDao extends Dao
{
    private static final Logger LOGGER = LogManager.getLogger("Institution DAO");
    private static final String INSTITUTION_TABLE = "institutions";
    private static final String ID_COL = "institutionId";
    private static final String NAME_COL = "intstitutionName";

    public List<Institution> select(ArrayList<String> fields, Institution criteriaVals, String operator)
    {
        try
        {
            ArrayList<Institution> ret = new ArrayList<Institution>();
            ResultSet results = getSelectResults(fields, criteriaVals, INSTITUTION_TABLE, operator);

            while (results.next())
            {
                Integer newId = null;
                String newName = null;

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
                }

                ret.add(new Institution(newId, newName));
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

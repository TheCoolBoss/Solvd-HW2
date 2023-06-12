package com.solvd.hw2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.hw2.dao.abstracts.Dao;
import com.solvd.hw2.models.*;

public class LocationDao extends Dao
{
    private static final Logger LOGGER = LogManager.getLogger("Location DAO");
    private static final String LOCATION_TABLE = "locations";
    private static final String ID_COL = "locId";
    private static final String CITY_COL = "city";
    private static final String COUNTRY_COL = "country";

    public List<Location> select(ArrayList<String> fields, Location criteriaVals, String operator)
    {
        try
        {
            ArrayList<Location> ret = new ArrayList<Location>();
            ResultSet results = getSelectResults(fields, criteriaVals, LOCATION_TABLE, operator);

            while (results.next())
            {
                Integer newId = null;
                String city = null;
                String country = null;

                for (int i = 1; i <= results.getMetaData().getColumnCount(); i++)
                {
                    if (results.getMetaData().getColumnLabel(i).equals(ID_COL))
                    {
                        newId = results.getInt(i);
                    }

                    else if (results.getMetaData().getColumnLabel(i).equals(CITY_COL))
                    {
                        city = results.getString(i);
                    }

                    else if (results.getMetaData().getColumnLabel(i).equals(COUNTRY_COL))
                    {
                        country = results.getString(i);
                    }
                }

                ret.add(new Location(newId, city, country));
            }
            
            return ret;
        }

        catch (SQLException sqle)
        {
            LOGGER.error(sqle.getMessage());
            return null;
        }
    }    
}

package com.solvd.hw2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LocationDao 
{
    private static final Logger LOGGER = LogManager.getLogger("Location DAO");
    private final String LOCATION_TABLE;

    public LocationDao(String locationTable)
    {
        LOCATION_TABLE = locationTable;
    }

    public void make(Connection c, String country, String city)
    {
        try
        {
            PreparedStatement newLoc = c.prepareStatement("insert into " + LOCATION_TABLE + " (country, city) values (?, ?)");
            newLoc.setString(1, country);
            newLoc.setString(2, city);
            newLoc.executeQuery();
        }

        catch (SQLException sqle)
        {
            LOGGER.error(sqle.getMessage());
        }
    }

    //TODO: add criteria
    public void update(Connection c, String newCountry, String newCity)
    {
        try
        {
            PreparedStatement updatedLoc = c.prepareStatement("update " + LOCATION_TABLE + " set country = ?, set city = ?");
            updatedLoc.setString(1, newCountry);
            updatedLoc.setString(2, newCity);
            updatedLoc.executeUpdate();
        }

        catch (SQLException sqle)
        {
            LOGGER.error(sqle.getMessage());
        }
    }

    public void delete(Connection c, int idToDelete)
    {
        try
        {
            PreparedStatement removedLoc = c.prepareStatement("delete from " + LOCATION_TABLE + " where locationId = ?");
            removedLoc.setInt(1, idToDelete);
            removedLoc.executeQuery();
        }

        catch (SQLException sqle)
        {
            LOGGER.error(sqle.getMessage());
        }
    }
}

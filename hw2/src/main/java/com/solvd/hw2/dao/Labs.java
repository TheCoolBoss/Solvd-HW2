package com.solvd.hw2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Labs 
{
    private static final Logger LOGGER = LogManager.getLogger("Lab DAO");
    private final String LAB_TABLE;

    public Labs(String labTable)
    {
        LAB_TABLE = labTable;
    }

    public void make(Connection c, String name, int institutionId, int locationId)
    {
        try
        {
            PreparedStatement newLab = c.prepareStatement("insert into " + LAB_TABLE + " (labName, institutionId, locationId) values (?, ?, ?)");
            newLab.setString(1, name);
            newLab.setInt(2, institutionId);
            newLab.setInt(3, locationId);
            newLab.executeUpdate();
        }

        catch (SQLException sqle)
        {
            LOGGER.error(sqle.getMessage());
        }
    }

    //TODO: add criteria
    public void update(Connection c, String newName, int newInstId, int newLocationId)
    {
        try
        {
            PreparedStatement updatedLab = c.prepareStatement("update " + LAB_TABLE + " set labName = ?, institutionId = ?, locationId = ?");
            updatedLab.setString(1, newName);
            updatedLab.setInt(2, newInstId);
            updatedLab.setInt(3, newLocationId);
            updatedLab.executeQuery();
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
            PreparedStatement removedLab = c.prepareStatement("delete from " + LAB_TABLE + " where labId = ?");
            removedLab.setInt(1, idToDelete);
            removedLab.executeQuery();
        }

        catch (SQLException sqle)
        {
            LOGGER.error(sqle.getMessage());
        }
    }
}

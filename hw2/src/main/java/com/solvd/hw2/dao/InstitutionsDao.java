package com.solvd.hw2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InstitutionsDao 
{
    private static final Logger LOGGER = LogManager.getLogger("Institution DAO");
    private final String INSTITUTION_TABLE;

    public InstitutionsDao(String institutionTable)
    {
        INSTITUTION_TABLE = institutionTable;
    }

    public void make(Connection c, String name)
    {
        try
        {
            PreparedStatement newInst = c.prepareStatement("insert into " + INSTITUTION_TABLE + " (institutionName) values (?)");
            newInst.setString(1, name);
            newInst.executeQuery();
        }

        catch (SQLException sqle)
        {
            LOGGER.error(sqle.getMessage());
        }
    }

    //TODO: add criteria
    public void update(Connection c, String newName)
    {
        try
        {
            PreparedStatement updatedInst = c.prepareStatement("update " + INSTITUTION_TABLE + " set institutionName = ?");
            updatedInst.setString(1, newName);
            updatedInst.executeUpdate();
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
            PreparedStatement removedInst = c.prepareStatement("delete from " + INSTITUTION_TABLE + " where institutionId = ?");
            removedInst.setInt(1, idToDelete);
            removedInst.executeQuery();
        }

        catch (SQLException sqle)
        {
            LOGGER.error(sqle.getMessage());
        }
    }
}

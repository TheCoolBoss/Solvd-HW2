package com.solvd.hw2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExperimentGroupDao 
{
    private static final Logger LOGGER = LogManager.getLogger("Exp Group DAO");
    private final String EXP_GROUP_TABLE;

    public ExperimentGroupDao(String expGroupTable)
    {
        EXP_GROUP_TABLE = expGroupTable;
    }

    public void make(Connection c, int scientistId, int expId)
    {
        try
        {
            PreparedStatement newGroup = c.prepareStatement("insert into " + EXP_GROUP_TABLE + " (scientistId, experimentId) values (?, ?)");
            newGroup.setInt(1, scientistId);
            newGroup.setInt(2, expId);
            newGroup.executeUpdate();
        }

        catch (SQLException sqle)
        {
            LOGGER.error(sqle.getMessage());
        }
    }

    //TODO: add criteria
    public void update(Connection c, int newScientistId, int newExpId)
    {
        try
        {
            PreparedStatement updatedGroup = c.prepareStatement("update " + EXP_GROUP_TABLE + " set scientistId = ?, set experimentId = ?");
            updatedGroup.setInt(1, newScientistId);
            updatedGroup.setInt(2, newExpId);
            updatedGroup.executeUpdate();
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
            PreparedStatement removedGroup = c.prepareStatement("delete from " + EXP_GROUP_TABLE + " where groupId = ?");
            removedGroup.setInt(1, idToDelete);
            removedGroup.executeUpdate();
        }

        catch (SQLException sqle)
        {
            LOGGER.error(sqle.getMessage());
        }
    }
}

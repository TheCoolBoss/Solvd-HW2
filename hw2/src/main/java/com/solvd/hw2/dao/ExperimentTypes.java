package com.solvd.hw2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExperimentTypes 
{
    private static final Logger LOGGER = LogManager.getLogger("Experiment Type DAO");
    private final String EXPERIMENT_TYPE_TABLE;

    public ExperimentTypes(String experimentTypeTable)
    {
        EXPERIMENT_TYPE_TABLE = experimentTypeTable;
    }

    public void makeExpType(Connection c, String name)
    {
        try
        {
            PreparedStatement newExpType = c.prepareStatement("insert into " + EXPERIMENT_TYPE_TABLE + " (expTypeName) values (?)");
            newExpType.setString(1, name);
            newExpType.executeUpdate();
        }

        catch (SQLException sqle)
        {
            LOGGER.error(sqle.getMessage());
        }
    }

    //TODO: add criteria
    public void updateClientType(Connection c, String newName)
    {
        try
        {
            PreparedStatement updatedExpType = c.prepareStatement("update " + EXPERIMENT_TYPE_TABLE + " set expTypeName = ?");
            updatedExpType.setString(1, newName);
            updatedExpType.executeQuery();
        }

        catch (SQLException sqle)
        {
            LOGGER.error(sqle.getMessage());
        }
    }
}

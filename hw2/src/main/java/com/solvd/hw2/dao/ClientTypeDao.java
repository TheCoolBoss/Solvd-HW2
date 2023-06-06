package com.solvd.hw2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClientTypeDao 
{
    private static final Logger LOGGER = LogManager.getLogger("Client Type DAO");
    private final String CLIENT_TYPE_TABLE;

    public ClientTypeDao(String clientTypeTable)
    {
        CLIENT_TYPE_TABLE = clientTypeTable;
    }

    public void make(Connection c, String name)
    {
        try
        {
            PreparedStatement newClientType = c.prepareStatement("insert into " + CLIENT_TYPE_TABLE + " (clientTypeName) values (?)");
            newClientType.setString(1, name);
            newClientType.executeUpdate();
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
            PreparedStatement updatedClientType = c.prepareStatement("update " + CLIENT_TYPE_TABLE + " set clientTypeName = ?");
            updatedClientType.setString(1, newName);
            updatedClientType.executeUpdate();
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
            PreparedStatement removedClientType = c.prepareStatement("delete from " + CLIENT_TYPE_TABLE + " where clientTypeId = ?");
            removedClientType.setInt(1, idToDelete);
            removedClientType.executeUpdate();
        }

        catch (SQLException sqle)
        {
            LOGGER.error(sqle.getMessage());
        }
    }
}

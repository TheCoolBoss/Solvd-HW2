package com.solvd.hw2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Clients 
{
    private static final Logger LOGGER = LogManager.getLogger("Assistant DAO");
    private final String CLIENT_TABLE;

    public Clients(String clientTable)
    {
        CLIENT_TABLE = clientTable;
    }

    public ResultSet select(Connection c, int idToFind)
    {
        try
        {
            PreparedStatement findClient = c.prepareStatement("select * from " + CLIENT_TABLE + " where clientId = ?");
            findClient.setInt(1, idToFind);
            return findClient.executeQuery();
        }

        catch (SQLException sqle)
        {
            LOGGER.error(sqle.getMessage());
            return null;
        }

    }

    public void make(Connection c, String name, int clientTypeId)
    {
        try
        {
            PreparedStatement newClient = c.prepareStatement("insert into " + CLIENT_TABLE + " (clientName, clientTypeId) values (?, ?)");
            newClient.setString(1, name);
            newClient.setInt(2, clientTypeId);
            newClient.executeUpdate();
        }

        catch (SQLException sqle)
        {
            LOGGER.error(sqle.getMessage());
        }
    }

    //TODO: add criteria
    public void update(Connection c, String newName, int newClientTypeId)
    {
        try
        {
            PreparedStatement updatedClient = c.prepareStatement("update " + CLIENT_TABLE + " set clientName = ?, set clientTypeId = ?");
            updatedClient.setString(1, newName);
            updatedClient.setInt(2, newClientTypeId);
            updatedClient.executeUpdate();
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
            PreparedStatement removedClient = c.prepareStatement("delete from " + CLIENT_TABLE + " where clientId = ?");
            removedClient.setInt(1, idToDelete);
            removedClient.executeQuery();
        }

        catch (SQLException sqle)
        {
            LOGGER.error(sqle.getMessage());
        }
    }
}

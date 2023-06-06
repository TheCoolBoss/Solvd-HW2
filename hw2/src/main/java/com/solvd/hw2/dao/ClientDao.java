package com.solvd.hw2.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.hw2.CustomPool;

public class ClientDao 
{
    private static final Logger LOGGER = LogManager.getLogger("Client DAO");
    private final String CLIENT_TABLE = "clients";

    public ResultSet select(int idToFind)
    {
        try
        {
            PreparedStatement findClient = CustomPool.getConn().prepareStatement("select * from " + CLIENT_TABLE + " where clientId = ?");
            findClient.setInt(1, idToFind);
            return findClient.executeQuery();
        }

        catch (SQLException sqle)
        {
            LOGGER.error(sqle.getMessage());
            return null;
        }

    }

    public void make(String name, int clientTypeId)
    {
        try
        {
            PreparedStatement newClient = CustomPool.getConn().prepareStatement("insert into " + CLIENT_TABLE + " (clientName, clientTypeId) values (?, ?)");
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
    public void update(String newName, int newClientTypeId)
    {
        try
        {
            PreparedStatement updatedClient = CustomPool.getConn().prepareStatement("update " + CLIENT_TABLE + " set clientName = ?, set clientTypeId = ?");
            updatedClient.setString(1, newName);
            updatedClient.setInt(2, newClientTypeId);
            updatedClient.executeUpdate();
        }

        catch (SQLException sqle)
        {
            LOGGER.error(sqle.getMessage());
        }
    }

    public void delete(int idToDelete)
    {
        try
        {
            PreparedStatement removedClient = CustomPool.getConn().prepareStatement("delete from " + CLIENT_TABLE + " where clientId = ?");
            removedClient.setInt(1, idToDelete);
            removedClient.executeQuery();
        }

        catch (SQLException sqle)
        {
            LOGGER.error(sqle.getMessage());
        }
    }
}

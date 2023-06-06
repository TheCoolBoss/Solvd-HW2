package com.solvd.hw2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AssistantDao 
{
    private static final Logger LOGGER = LogManager.getLogger("Assistant DAO");
    private static final String ASSISTANT_TABLE = "assistants";
    

    public void make(Connection c, String firstName, String lastName, int scientistId)
    {
        try
        {
            PreparedStatement newAst = c.prepareStatement("insert into " + ASSISTANT_TABLE + " (firstName, lastName, assisteeId) values (?, ?, ?)");
            newAst.setString(1, firstName);
            newAst.setString(2, lastName);
            newAst.setInt(3, scientistId);
            newAst.executeUpdate();
        }

        catch (SQLException sqle)
        {
            LOGGER.error(sqle.getMessage());
        }
    }

    //TODO: add criteria
    public void update(Connection c, String newFirstName, String newLastName, int newScientistId)
    {
        try
        {
            PreparedStatement updatedAst = c.prepareStatement("update " + ASSISTANT_TABLE + " set firstName = ?, set lastName = ?, set assisteeId = ?");
            updatedAst.setString(1, newFirstName);
            updatedAst.setString(2, newLastName);
            updatedAst.setInt(3, newScientistId);
            updatedAst.executeUpdate();
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
            PreparedStatement removedAst = c.prepareStatement("delete from " + ASSISTANT_TABLE + " where assistantId = ?");
            removedAst.setInt(1, idToDelete);
            removedAst.executeUpdate();
        }

        catch (SQLException sqle)
        {
            LOGGER.error(sqle.getMessage());
        }
    }
}

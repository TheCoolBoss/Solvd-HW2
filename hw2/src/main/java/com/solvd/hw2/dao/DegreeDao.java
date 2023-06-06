package com.solvd.hw2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DegreeDao 
{
    private static final Logger LOGGER = LogManager.getLogger("Degree DAO");
    private final String DEGREE_TABLE = "degrees";
    private final String DEGREE_ID_COL = "degreeId";
    private final String DEGREE_NAME_COL = "name";
    private final String YEAR_COL = "numOfYears";

    public void make(Connection c, String name, int years)
    {
        try
        {
            PreparedStatement newDegree = c.prepareStatement("insert into " + DEGREE_TABLE + " (" + DEGREE_NAME_COL + ", " + YEAR_COL + ")" + " values (?, ?)");
            newDegree.setString(1, name);
            newDegree.setInt(2, years);
            newDegree.executeUpdate();
        }

        catch (SQLException sqle)
        {
            LOGGER.error(sqle.getMessage());
        }
    }

    //TODO: add criteria
    public void update(Connection c, String newName, int newYears)
    {
        try
        {
            PreparedStatement updatedDegree = c.prepareStatement("update " + DEGREE_TABLE + " set degreeName = ?, numOfYears = ?");
            updatedDegree.setString(1, newName);
            updatedDegree.setInt(2, newYears);
            updatedDegree.executeUpdate();
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
            PreparedStatement removedDegree = c.prepareStatement("delete from " + DEGREE_TABLE + " where " + DEGREE_ID_COL +  " = ?");
            removedDegree.setInt(1, idToDelete);
            removedDegree.executeUpdate();
        }

        catch (SQLException sqle)
        {
            LOGGER.error(sqle.getMessage());
        }
    }

}

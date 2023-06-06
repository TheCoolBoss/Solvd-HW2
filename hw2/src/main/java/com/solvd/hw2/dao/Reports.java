package com.solvd.hw2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Reports 
{
    private static final Logger LOGGER = LogManager.getLogger("Report DAO");
    private final String REPORTS_TABLE;

    public Reports(String reportsTable)
    {
        REPORTS_TABLE = reportsTable;
    }

    public void make(Connection c, String reportName, String link)
    {
        try
        {
            PreparedStatement newReport = c.prepareStatement("insert into " + REPORTS_TABLE + " (reportName, link) values (?, ?)");
            newReport.setString(1, reportName);
            newReport.setString(2, link);
            newReport.executeQuery();
        }

        catch (SQLException sqle)
        {
            LOGGER.error(sqle.getMessage());
        }
    }

    //TODO: add criteria
    public void update(Connection c, String newreportName, String newlink, int newScientistId)
    {
        try
        {
            PreparedStatement updatedReport = c.prepareStatement("update " + REPORTS_TABLE + " set reportName = ?, set link = ?");
            updatedReport.setString(1, newreportName);
            updatedReport.setString(2, newlink);
            updatedReport.executeUpdate();
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
            PreparedStatement removedAst = c.prepareStatement("delete from " + REPORTS_TABLE + " where reportId = ?");
            removedAst.setInt(1, idToDelete);
            removedAst.executeQuery();
        }

        catch (SQLException sqle)
        {
            LOGGER.error(sqle.getMessage());
        }
    }
}

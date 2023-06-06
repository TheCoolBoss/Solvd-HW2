package com.solvd.hw2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


//Includes a col that is deleted via queries from 2nd part
public class Investments
{
    private static final Logger LOGGER = LogManager.getLogger("Investment DAO");
    private final String INVESTMENTS_TABLE;

    public Investments(String investmentsTable)
    {
        INVESTMENTS_TABLE = investmentsTable;
    }

    public void make(Connection c, double amount, int clientId, String bank)
    {
        try
        {
            PreparedStatement newInvestment = c.prepareStatement("insert into " + INVESTMENTS_TABLE + " (amount, clientId, bank) values (?, ?, ?)");
            newInvestment.setDouble(1, amount);
            newInvestment.setInt(2, clientId);
            newInvestment.setString(3, bank);
            newInvestment.executeUpdate();
        }

        catch (SQLException sqle)
        {
            LOGGER.error(sqle.getMessage());
        }
    }

    //TODO: add criteria
    public void update(Connection c, double newAmount, int newClientId, String newBank)
    {
        try
        {
            PreparedStatement updatedInvestment = c.prepareStatement("update " + INVESTMENTS_TABLE + " set amount = ?, set clientId = ?, set bank = ?");
            updatedInvestment.setDouble(1, newAmount);
            updatedInvestment.setInt(2, newClientId);
            updatedInvestment.setString(3, newBank);
            updatedInvestment.executeQuery();
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
            PreparedStatement removedInvestment = c.prepareStatement("delete from " + INVESTMENTS_TABLE + " where investmentId = ?");
            removedInvestment.setInt(1, idToDelete);
            removedInvestment.executeQuery();
        }

        catch (SQLException sqle)
        {
            LOGGER.error(sqle.getMessage());
        }
    }
}

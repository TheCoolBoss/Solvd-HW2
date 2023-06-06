package com.solvd.hw2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.hw2.criteria.DegreeCriteria;
import com.solvd.hw2.dao.Clients;
import com.solvd.hw2.generators.QueryGen;
import com.solvd.hw2.services.ClientService;

public class Main 
{
    private static final Logger LOGGER = LogManager.getLogger("Main");
    public static void main(String[] args) throws SQLException
    {
        CustomPool pool = new CustomPool();
        String url = "jdbc:mysql://127.0.0.1:3306/solvddbhw";
        String user = "root";
        String pass = "root";

        Connection conn = DriverManager.getConnection(url, user, pass);

        Statement clients = conn.createStatement();
        ResultSet results = clients.executeQuery("select clientName from clients");
        java.sql.ResultSetMetaData data = results.getMetaData();
        int cols = data.getColumnCount();

        while (results.next())
        {
            for (int i = 1; i <= cols; i++)
            {
                LOGGER.info(results.getString(i));
            }
        }

        ClientService clientService = new ClientService(new Clients("clients"), conn);
        //clientService.insertClient("Mission Control", 2);
        ResultSet seriousSam = clientService.selectClient(4);
        int seriousCols = seriousSam.getMetaData().getColumnCount();

        while (seriousSam.next())
        {
            for (int i = 1; i <= seriousCols; i++)
            {
                LOGGER.info(seriousSam.getMetaData().getColumnLabel(i) + ": " + seriousSam.getString(i));
            }

        }

        clients.close();

        //Testing query gen, only testing select for now
        DegreeCriteria testDegree = new DegreeCriteria(1, "Test", 1);
        DegreeCriteria testUpdate = new DegreeCriteria(1, "test2", 7);
        DegreeCriteria testSelect = new DegreeCriteria(1, "r", null);
        LOGGER.info(QueryGen.genInsert(testDegree.getFields(), "degrees"));
        LOGGER.info(QueryGen.genUpdate(testUpdate.getFields(), "degrees"));
        LOGGER.info(QueryGen.genSelect(testSelect.getFields(), "degrees"));

        PreparedStatement test = conn.prepareStatement(QueryGen.genSelect(testSelect.getFields(), "degrees"));


        ResultSet testDegreeSelect = test.executeQuery();

        while (testDegreeSelect.next())
        {
            for (int i = 1; i <= testDegreeSelect.getMetaData().getColumnCount(); i++)
            {
                LOGGER.info(testDegreeSelect.getMetaData().getColumnLabel(i) + ": " + testDegreeSelect.getString(i));
            }

        }

        conn.close();
    }
}

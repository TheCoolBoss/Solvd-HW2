package com.solvd.hw2;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

public class CustomPool 
{
    private static ArrayList<Connection> activeConns;
    private static ArrayList<Connection> idleConns;
    private static Properties props;
    private static String url;
    private static String user;
    private static String pass;

    public CustomPool() throws IOException
    {
        activeConns = new ArrayList<Connection>();
        idleConns = new ArrayList<Connection>();
        props = new Properties();
        props.load(new FileInputStream("hw2/src/main/resources/db.properties"));
        url = props.getProperty("url");
        user = props.getProperty("user");
        pass = props.getProperty("pass");
    }

    public static ArrayList<Connection> getActiveConns() 
    {
        return activeConns;
    }

    public static ArrayList<Connection> getIdleConns() 
    {
        return idleConns;
    }

    public static synchronized Connection getConn() throws SQLException
    {
        if (activeConns.size() == 0 && idleConns.size() == 0)
        {
            activeConns.add(DriverManager.getConnection(url, user, pass));
        }

        else if (activeConns.size() == 0 && idleConns.size() != 0)
        {
            idleConns.remove(0);
            Connection reOpened = DriverManager.getConnection(url, user, pass);
            activeConns.add(reOpened);
        }

        return activeConns.get(0);
    }

    public static synchronized void closeConn() throws SQLException
    {
        activeConns.get(0).close();
        idleConns.add(getConn());
        activeConns.remove(0);
    }
}

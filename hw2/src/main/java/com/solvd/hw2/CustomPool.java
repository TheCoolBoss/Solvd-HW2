package com.solvd.hw2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomPool 
{
    private static final Logger LOGGER = LogManager.getLogger("Conn Pool");
    private static ArrayList<Connection> activeConns;
    private static ArrayList<Connection> idleConns;
    private static Properties props;
    private static String url;
    private static String user;
    private static String pass;
    private static int maxConns;

    public CustomPool() throws IOException
    {
        activeConns = new ArrayList<Connection>();
        idleConns = new ArrayList<Connection>();
        props = new Properties();
        try
        {
            props.load(new FileInputStream("hw2/src/main/resources/db.properties"));
        }

        catch (FileNotFoundException fnfe)
        {
            props.load(new FileInputStream("/src/main/resources/db.properties"));
        }

        url = props.getProperty("url");
        user = props.getProperty("user");
        pass = props.getProperty("pass");
        maxConns = Integer.parseInt(props.getProperty("maxSize"));
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
        //Max size
        if (activeConns.size() == maxConns)
        {
            //TODO: add multithread stuff
            LOGGER.error("Max capacity reached. :(");
            return null;
        }

        //No connections at all
        else if (activeConns.size() == 0 && idleConns.size() == 0)
        {
            activeConns.add(DriverManager.getConnection(url, user, pass));
        }

        //Only idles
        else if (activeConns.size() == 0 && idleConns.size() != 0)
        {
            activeConns.add(idleConns.get(0));
            idleConns.remove(0);
        }

        return activeConns.get(0);
    }

    public static synchronized void releaseConn() throws SQLException
    {
        idleConns.add(activeConns.get(0));
        activeConns.remove(0);
    }

    public static synchronized void closePool() throws SQLException
    {
        for (Connection conn : activeConns) 
        {
            conn.close();    
        }
        
        for (Connection conn : idleConns) 
        {
            conn.close();
        }

        activeConns.clear();
        idleConns.clear();
    }
}

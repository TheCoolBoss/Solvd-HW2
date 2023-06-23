package com.solvd.hw2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomPool 
{
    private static final Logger LOGGER = LogManager.getLogger("Conn Pool");
    private static BlockingQueue<Connection> activeConns;
    private static BlockingQueue<Connection> idleConns;
    private static Properties props;
    private static String url;
    private static String user;
    private static String pass;
    private static int maxConns;

    public CustomPool() throws IOException
    {
        props = new Properties();
        props.load(new FileInputStream("src/main/resources/db.properties"));
        url = props.getProperty("url");
        user = props.getProperty("user");
        pass = props.getProperty("pass");
        maxConns = Integer.parseInt(props.getProperty("maxSize"));
        activeConns = new LinkedBlockingDeque<>(maxConns);
        idleConns = new LinkedBlockingDeque<>(maxConns);
    }

    public static BlockingQueue<Connection> getActiveConns() 
    {
        return activeConns;
    }

    public static BlockingQueue<Connection> getIdleConns() 
    {
        return idleConns;
    }

    public static synchronized Connection getConn() throws SQLException, InterruptedException
    {
        //Max size
        if (activeConns.size() == maxConns)
        {
            //TODO: put multithread stuff
            //put method waits, so will stick with it for now
            LOGGER.error("Max capacity reached. :(");
            activeConns.put(DriverManager.getConnection(url, user, pass));
        }

        //No connections at all
        else if (activeConns.size() == 0 && idleConns.size() == 0)
        {
            activeConns.put(DriverManager.getConnection(url, user, pass));
        }

        //Only idles
        else if (activeConns.size() == 0 && idleConns.size() != 0)
        {
            activeConns.put(idleConns.take());
        }

        return activeConns.peek();
    }

    public static synchronized void releaseConn() throws SQLException, InterruptedException
    {
        idleConns.put(activeConns.take());
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

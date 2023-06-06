package com.solvd.hw2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomPool 
{
    // private static final int MAX_CONNS = 5;
    // private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(MAX_CONNS);
    private static final Logger LOGGER = LogManager.getLogger("Connection Pool");

    private static ArrayList<Connection> activeConns;
    private static ArrayList<Connection> idleConns;

    public CustomPool()
    {
        activeConns = new ArrayList<Connection>();
        idleConns = new ArrayList<Connection>();
    }

    public static ArrayList<Connection> getActiveConns() 
    {
        return activeConns;
    }

    public static ArrayList<Connection> getIdleConns() 
    {
        return idleConns;
    }

    public static synchronized Connection getConn()
    {
        if (activeConns.size() == 0)
        {
            LOGGER.error("No conns to get. :(");
            return null;
        }

        return activeConns.get(0);
        // Connection temp = activeConns.remove(0);
        // idleConns.add(temp);
        // notifyAll();
        // return temp;
    }

    public static synchronized void closeConn(Connection conn) throws SQLException
    {
        if (idleConns.contains(conn))
        {
            LOGGER.error("Connection already closed :(");
        }

        else if (!activeConns.contains(conn))
        {
            LOGGER.error("Couldn't find connection. :(");
        }

        else
        {
            conn.close();
            idleConns.add(conn);
            activeConns.remove(conn);
        }
    }

    public static synchronized void resetConn(Connection conn)
    {
        if (conn == null)
        {
            LOGGER.error("Null connection :(");
        }

        else if (!idleConns.contains(conn))
        {
            LOGGER.error("Couldn't find connection. :(");
        }

        else
        {
            idleConns.remove(conn);
            activeConns.add(conn);
        }
    }

    public static void addConn(Connection conn)
    {
        activeConns.add(conn);
    }
}

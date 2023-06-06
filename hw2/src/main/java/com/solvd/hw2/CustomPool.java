package com.solvd.hw2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class CustomPool 
{
    // private static final int MAX_CONNS = 5;
    // private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(MAX_CONNS);
    private static final Logger LOGGER = LogManager.getLogger("Connection Pool");

    public ArrayList<Connection> activeConns;
    private ArrayList<Connection> idleConns;


    public CustomPool()
    {
        this.activeConns = new ArrayList<Connection>();
        this.idleConns = new ArrayList<Connection>();
    }

    public synchronized Connection getConn()
    {
        if (activeConns.size() == 0)
        {
            LOGGER.error("No conns to get. :(");
            return null;
        }

        Connection temp = activeConns.remove(0);
        idleConns.add(temp);
        notifyAll();
        return temp;
    }

    public synchronized void resetConn(Connection conn)
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

    public void addConn(Connection conn)
    {
        activeConns.add(conn);
    }
}

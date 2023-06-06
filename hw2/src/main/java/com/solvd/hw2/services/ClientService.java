package com.solvd.hw2.services;

import java.sql.Connection;
import java.sql.ResultSet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.hw2.dao.Clients;

public class ClientService 
{
    private static final Logger LOGGER = LogManager.getLogger("Client Service");
    private final Clients CLIENT_DAO;
    private final Connection CONN;

    public ClientService(Clients clientDao, Connection conn)
    {
        CLIENT_DAO = clientDao;
        this.CONN = conn;
    }

    public void insertClient(String name, int clientId)
    {
        CLIENT_DAO.make(CONN, name, clientId);
    }

    public ResultSet selectClient(int id)
    {
        return CLIENT_DAO.select(CONN, id);
    }
}

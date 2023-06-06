package com.solvd.hw2.services;

import java.sql.Connection;
import java.sql.ResultSet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.hw2.dao.ClientDao;

public class ClientService 
{
    private static final Logger LOGGER = LogManager.getLogger("Client Service");
    private final ClientDao CLIENT_DAO;

    public ClientService(ClientDao clientDao)
    {
        CLIENT_DAO = clientDao;
    }

    public void insertClient(String name, int clientId)
    {
        CLIENT_DAO.make(name, clientId);
    }

    public ResultSet selectClient(int id)
    {
        return CLIENT_DAO.select(id);
    }
}

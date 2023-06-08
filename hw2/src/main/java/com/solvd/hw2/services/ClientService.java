package com.solvd.hw2.services;

import java.sql.ResultSet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.hw2.dao.ClientDao;
import com.solvd.hw2.dao.ClientTypeDao;
import com.solvd.hw2.models.Client;

public class ClientService 
{
    private static final Logger LOGGER = LogManager.getLogger("Client Service");
    private static final ClientTypeDao TYPE_DAO = new ClientTypeDao();
    private static final String CLIENT_TABLE = "clients";
    private final ClientDao CLIENT_DAO;

    public ClientService(ClientDao clientDao)
    {
        CLIENT_DAO = clientDao;
    }

    public void insertClient(Client toInsert)
    {
        CLIENT_DAO.insert(toInsert, CLIENT_TABLE);
    }
}

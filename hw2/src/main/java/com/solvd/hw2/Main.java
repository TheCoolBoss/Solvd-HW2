package com.solvd.hw2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.hw2.services.*;
import com.solvd.hw2.models.*;

public class Main 
{
    private static final Logger LOGGER = LogManager.getLogger("Main");
    public static void main(String[] args) throws SQLException, IOException, FileNotFoundException
    {
        new CustomPool();

        ClientService cs = new ClientService();
        ClientTypeService cts = new ClientTypeService();
        List<Client> idOf3 = cs.getById(3);
        List<Client> typeIdOf2 = cs.getByTypeId(2);
        String clientTypeOf2 = cts.getTypeNameById(2);

        for (Client client : idOf3) 
        {
            LOGGER.info("Client id: " + client.getId());
            LOGGER.info("Client name: " + client.getName());
            LOGGER.info("Client type: " + cts.getTypeNameById(client.getClientType().getClientTypeId()));
        }

        for (Client client : typeIdOf2) 
        {
            LOGGER.info("Client id: " + client.getId());
            LOGGER.info("Client name: " + client.getName());
            LOGGER.info("Client type: " + clientTypeOf2);
        }

        CustomPool.closePool();
    }
}

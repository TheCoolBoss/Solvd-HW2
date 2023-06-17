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
        List<Client> typeIdOf2 = cs.getByTypeId(2);

        for (Client client : typeIdOf2) 
        {
            LOGGER.info(client.toString());
        }

        CustomPool.closePool();
    }
}

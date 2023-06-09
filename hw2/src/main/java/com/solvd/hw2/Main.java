package com.solvd.hw2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.hw2.dao.ClientDao;
import com.solvd.hw2.dao.ClientTypeDao;
import com.solvd.hw2.generators.QueryGen;
import com.solvd.hw2.models.*;

public class Main 
{
    private static final Logger LOGGER = LogManager.getLogger("Main");
    public static void main(String[] args) throws SQLException, IOException, FileNotFoundException
    {
        new CustomPool();

        Client clientFields = new Client(null, "dummy", null);
        Client clientCriteria = new Client(null, null, new ClientType(2, null));

        ClientType typeFields = new ClientType(null, "");
        ClientType typeCrit = new ClientType(2, null);

        ClientDao clientDao = new ClientDao();
        ClientTypeDao typeDao = new ClientTypeDao();

        List<Client> idOfTwo = clientDao.select(clientFields.getFields(), clientCriteria, " <= ");
        List<ClientType> typeId2 = typeDao.select(typeFields.getFields(), typeCrit, " = ");

        typeId2.forEach((ClientType type) -> 
        {
            LOGGER.info("Type: " + type.getClientTypeName());
        });

        idOfTwo.forEach((Client client) ->
        {
            LOGGER.info("Name: " + client.getName());
        });

        QueryGen.genInsert(clientFields, "test");
        QueryGen.genUpdate(clientFields, "test", new Client(null, "123", new ClientType(2, null)), "");
    }
}

package com.solvd.hw2.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.hw2.models.*;
import com.solvd.hw2.mybatis.dao.*;
import com.solvd.hw2.mybatis.models.MBClient;

public class MyBatisMain 
{
    private static final Logger LOGGER = LogManager.getLogger("Main");
    private static final String SETUP_PATH = "mybatis.xml";

    public static void main(String[] args) throws IOException
    {
        InputStream stream = Resources.getResourceAsStream(SETUP_PATH);
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(stream);

        ClientMBDao clientDao = new ClientMBDao(factory);


        MBClient testClient = clientDao.getClientById(4);
        LOGGER.info(testClient);

        Client testInsert = new Client(null, "Ganondorf", new ClientType(2, ""));
        clientDao.insertClient(testInsert);

        clientDao.deleteClient(7);

        Client testUpdate = new Client(5, "Captain Falcon and Ganondorf", new ClientType(2, ""));
        clientDao.updateClient(testUpdate);

        List<MBClient> list = clientDao.getClientByTypeId(2);
        for (MBClient mbClient : list) 
        {
            LOGGER.info(mbClient);
        }
    }
}

package com.solvd.hw2.dao.mybatis;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.hw2.models.Client;

public class ClientMBDao 
{
    private static final Logger LOGGER = LogManager.getLogger("Client MB Dao");
    private SqlSessionFactory factory;

    public ClientMBDao(SqlSessionFactory factory) 
    {
        this.factory = factory;
    }


    public List<Client> getClientByTypeId(Integer clientTypeId) 
    {
        try(SqlSession session = factory.openSession())
        {
            List<Client> ret = session.selectList("ClientMap.getClientByTypeId", clientTypeId);
            return ret;
        }
    }

    public Client getClientById(Integer clientId)
    {
        try(SqlSession session = factory.openSession())
        {
            return session.selectOne("ClientMap.getClientById", clientId);
        }
    }

    public Client getClientByName(String name)
    {
        try(SqlSession session = factory.openSession())
        {
            return session.selectOne("ClientMap.getClientByName", name);
        }
    }

    public void updateClient(Client newVals)
    {
        try(SqlSession session = factory.openSession())
        {
            int updatedRows = session.update("ClientMap.updateClient", newVals);
            session.commit();
            LOGGER.info("Updated " + updatedRows + " rows.");
        } 
    }

    public void insertClient(Client toInsert)
    {
        try(SqlSession session = factory.openSession())
        {
            session.insert("ClientMap.insertClient", toInsert);
            session.commit();
        } 
    }

    public void deleteClient(Integer clientId)
    {
        try(SqlSession session = factory.openSession())
        {
            int updatedRows = session.update("ClientMap.deleteClient", clientId);
            session.commit();
            LOGGER.info("Updated " + updatedRows + " rows.");
        } 
    }
}

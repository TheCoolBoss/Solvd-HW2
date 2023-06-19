package com.solvd.hw2.mybatis.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.hw2.models.Client;
import com.solvd.hw2.mybatis.models.MBClient;

public class ClientMBDao 
{
    private static final Logger LOGGER = LogManager.getLogger("Client MB Dao");
    private SqlSessionFactory factory;

    public ClientMBDao(SqlSessionFactory factory) 
    {
        this.factory = factory;
    }


    public List<MBClient> getClientByTypeId(Integer clientTypeId) 
    {
        try(SqlSession session = factory.openSession())
        {
            List<MBClient> ret = session.selectList("ClientMap.xml.getClientByTypeId", clientTypeId);
            //session.commit();
            return ret;
        }
    }

    public MBClient getClientById(Integer clientId)
    {
        try(SqlSession session = factory.openSession())
        {
            MBClient ret = session.selectOne("ClientMap.xml.getClientById", clientId);
            //session.commit();
            return ret;
        }
    }

    public void updateClient(Client newVals)
    {
        MBClient mbVersion = new MBClient(newVals.getId(), newVals.getName(), newVals.getClientType().getClientTypeId());
        try(SqlSession session = factory.openSession())
        {
            int updatedRows = session.update("ClientMap.xml.updateClient", mbVersion);
            session.commit();
            LOGGER.info("Updated " + updatedRows + " rows.");
        } 
    }

    public void insertClient(Client toInsert)
    {
        MBClient mbVersion = new MBClient(null, toInsert.getName(), toInsert.getClientType().getClientTypeId());
        try(SqlSession session = factory.openSession())
        {
            session.insert("ClientMap.xml.insertClient", mbVersion);
            session.commit();
        } 
    }

    public void deleteClient(Integer clientId)
    {
        try(SqlSession session = factory.openSession())
        {
            int updatedRows = session.update("ClientMap.xml.deleteClient", clientId);
            session.commit();
            LOGGER.info("Updated " + updatedRows + " rows.");
        } 
    }
}

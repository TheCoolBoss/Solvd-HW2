package com.solvd.hw2.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.hw2.models.ClientType;

public class ClientTypeMBDao 
{
    private static final Logger LOGGER = LogManager.getLogger("ClientType MB Dao");
    private SqlSessionFactory factory;

    public ClientTypeMBDao(SqlSessionFactory factory) 
    {
        this.factory = factory;
    }


    public ClientType getClientTypeById(Integer id) 
    {
        try(SqlSession session = factory.openSession())
        {
            ClientType ret = session.selectOne("ClientTypeMap.xml.getClientTypeById", id);
            //session.commit();
            return ret;
        }

        catch (Exception e)
        {
            LOGGER.error(e.getMessage());
            return null;
        }
    }

    public void deleteClientType(Integer clientTypeId)
    {
        try(SqlSession session = factory.openSession())
        {
            int updatedRows = session.delete("ClientTypeMap.xml.deleteClient", clientTypeId);
            session.commit();
            LOGGER.info("Updated " + updatedRows + " rows.");
        } 
    }
}

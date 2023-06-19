package com.solvd.hw2.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.hw2.models.Degree;

public class DegreeMBDao 
{
    private static final Logger LOGGER = LogManager.getLogger("Degree MB Dao");
    private SqlSessionFactory factory;

    public DegreeMBDao(SqlSessionFactory factory) 
    {
        this.factory = factory;
    }


    public Degree getDegreeById(Integer id) 
    {
        try(SqlSession session = factory.openSession())
        {
            Degree ret = session.selectOne("DegreeMap.xml.getDegreeById", id);
            //session.commit();
            return ret;
        }

        catch (Exception e)
        {
            LOGGER.error(e.getMessage());
            return null;
        }
    }

    public void deleteDegree(Integer degreeId)
    {
        try(SqlSession session = factory.openSession())
        {
            int updatedRows = session.delete("DegreeMap.xml.deleteDegree", degreeId);
            session.commit();
            LOGGER.info("Updated " + updatedRows + " rows.");
        } 
    }
}

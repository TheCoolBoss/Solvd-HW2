package com.solvd.hw2.mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.solvd.hw2.models.Experiment;

public class ExperimentMBDao 
{
    private SqlSessionFactory factory;

    public ExperimentMBDao(SqlSessionFactory factory) 
    {
        this.factory = factory;
    }

    public void insertExperiment(Experiment toInsert)
    {
        try(SqlSession session = factory.openSession())
        {
            session.insert("ExperimentMap.insertExperiment", toInsert);
            session.commit();
        } 
    }

    public int getLastId()
    {
        try(SqlSession session = factory.openSession())
        {
            return session.selectOne("ExperimentMap.getLastId");
        } 
    }

    public void insertToGroup(Experiment toInsert)
    {
        try(SqlSession session = factory.openSession())
        {
            session.insert("ExperimentMap.insertExpGroup", toInsert);
            session.commit();
        } 
    }

    public Experiment getExperimentById(int id)
    {
        try(SqlSession session = factory.openSession())
        {
            return session.selectOne("ExperimentMap.getExperimentById", id);
        }
    }

    public List<Integer> getScientistIdByExperimentId(int id)
    {
        try(SqlSession session = factory.openSession())
        {
            return session.selectList("ExperimentMap.getScientistIdByExperimentId", id);
        }
    }
}

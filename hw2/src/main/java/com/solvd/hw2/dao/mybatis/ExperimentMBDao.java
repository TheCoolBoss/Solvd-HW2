package com.solvd.hw2.dao.mybatis;

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

    public void updateExperiment(Experiment newVals)
    {
        try(SqlSession session = factory.openSession())
        {
            session.update("ExperimentMap.updateExperiment", newVals);
            session.commit();
        }
    }

    public void deleteExperiment(Experiment toDelete)
    {
        try(SqlSession session = factory.openSession())
        {
            session.delete("ExperimentMap.deleteExperiment", toDelete);
            session.commit();
        }
    }

    public void deleteExperimentFromGroup(Experiment toDelete)
    {
        try(SqlSession session = factory.openSession())
        {
            session.delete("ExperimentMap.deleteFromGroup", toDelete.getId());
            session.commit();
        }
    }
}

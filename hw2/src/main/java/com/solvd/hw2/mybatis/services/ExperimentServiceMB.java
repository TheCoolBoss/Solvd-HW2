package com.solvd.hw2.mybatis.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import com.solvd.hw2.models.Experiment;
import com.solvd.hw2.models.Scientist;
import com.solvd.hw2.mybatis.dao.ExperimentMBDao;
import com.solvd.hw2.mybatis.dao.ScientistMBDao;

public class ExperimentServiceMB 
{
    private ExperimentMBDao expDao;
    private ScientistMBDao scientistDao;

    public ExperimentServiceMB(SqlSessionFactory factory) 
    {
        expDao = new ExperimentMBDao(factory);
        scientistDao = new ScientistMBDao(factory);
    }

    public void insertExperiment(Experiment toInsert)
    {
        expDao.insertExperiment(toInsert);
        toInsert.setId(expDao.getLastId());
        expDao.insertToGroup(toInsert);
    }

    public Experiment getExperimentById(int id)
    {
        Experiment ret = expDao.getExperimentById(id);
        List<Integer> scientistIds = expDao.getScientistIdByExperimentId(id);
        List<Scientist> scientists = new ArrayList<Scientist>();
        for (Integer scientistId : scientistIds) 
        {
            scientists.add(scientistDao.getScientistById(scientistId));
        }
        
        ret.setScientists(scientists);
        return ret;
    }
}

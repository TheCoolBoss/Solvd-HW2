package com.solvd.hw2.services.mybatis;

import java.io.IOException;
import com.solvd.hw2.dao.mybatis.ExperimentMBDao;
import com.solvd.hw2.models.Experiment;
import com.solvd.hw2.services.abstracts.ServiceMB;
import com.solvd.hw2.services.interfaces.IExperimentService;

public class ExperimentServiceMB extends ServiceMB implements IExperimentService
{
    private ExperimentMBDao expDao;

    public ExperimentServiceMB() throws IOException
    {
        setUpService();
        expDao = new ExperimentMBDao(factory);
    }

    public void insertExperiment(Experiment toInsert)
    {
        expDao.insertExperiment(toInsert);
        toInsert.setId(expDao.getLastId());
        expDao.insertToGroup(toInsert);
    }

    public Experiment getExperimentById(int id)
    {
        return expDao.getExperimentById(id);
    }

    public void updateExperiment(Experiment newVals)
    {
        expDao.updateExperiment(newVals);
    }
}

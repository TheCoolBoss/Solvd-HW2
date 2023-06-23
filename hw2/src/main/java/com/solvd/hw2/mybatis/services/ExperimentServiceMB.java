package com.solvd.hw2.mybatis.services;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.solvd.hw2.models.Experiment;
import com.solvd.hw2.mybatis.dao.ExperimentMBDao;

public class ExperimentServiceMB 
{
    private static final String SETUP_PATH = "mybatis.xml";
    private ExperimentMBDao expDao;
    private InputStream stream;
    private SqlSessionFactoryBuilder builder;
    private SqlSessionFactory factory;

    public ExperimentServiceMB() throws IOException
    {
        stream = Resources.getResourceAsStream(SETUP_PATH);  
        builder = new SqlSessionFactoryBuilder();
        factory = builder.build(stream);
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
}

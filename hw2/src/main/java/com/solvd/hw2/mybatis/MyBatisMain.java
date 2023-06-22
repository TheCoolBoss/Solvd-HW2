package com.solvd.hw2.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.hw2.jaxb.adapters.DateAdapter;
import com.solvd.hw2.models.*;
import com.solvd.hw2.mybatis.dao.*;
import com.solvd.hw2.mybatis.services.ExperimentServiceMB;

public class MyBatisMain 
{
    private static final Logger LOGGER = LogManager.getLogger("Main");
    private static final String SETUP_PATH = "mybatis.xml";

    public static void main(String[] args) throws IOException, java.text.ParseException
    {
        DateAdapter dateAdapter = new DateAdapter();
        InputStream stream = Resources.getResourceAsStream(SETUP_PATH);
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(stream);

        ExperimentServiceMB expService = new ExperimentServiceMB(factory);

        // ExperimentType dummy = new ExperimentType(6, "Meme Montage");
        // Investment dummyInv = new Investment(3, null, null, null);
        // Report dummyReport = new Report(5, "", "");
        // Lab dummyLab = new Lab(3, "", null, null);
        // Date start = dateAdapter.unmarshal("2023-01-01");
        // Date end = dateAdapter.unmarshal("2023-06-21");
        // Scientist sci1 = new Scientist(1, "", "", null);
        // Scientist sci2 = new Scientist(2, "", "", null);
        // Experiment testInsert = new Experiment(0, "Best Ganon and Falcon Plays 2", "Done", start, end, dummy, dummyInv, dummyReport, dummyLab);
        // testInsert.getScientists().add(sci1);
        // testInsert.getScientists().add(sci2);
        //expService.insertExperiment(testInsert);
        LOGGER.info(expService.getExperimentById(4).toString());
    }
}

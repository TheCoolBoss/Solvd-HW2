package com.solvd.hw2.mybatis;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.hw2.mybatis.services.ExperimentServiceMB;

public class MyBatisMain 
{
    private static final Logger LOGGER = LogManager.getLogger("Main");


    public static void main(String[] args) throws IOException, java.text.ParseException
    {
        ExperimentServiceMB expService = new ExperimentServiceMB();

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

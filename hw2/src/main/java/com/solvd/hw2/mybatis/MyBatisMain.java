package com.solvd.hw2.mybatis;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.hw2.models.*;
import com.solvd.hw2.services.mybatis.ExperimentServiceMB;

public class MyBatisMain 
{
    private static final Logger LOGGER = LogManager.getLogger("Main");

    public static void main(String[] args) throws IOException, java.text.ParseException
    {
        ExperimentServiceMB expService = new ExperimentServiceMB();

        Experiment idOf4 = expService.getExperimentById(4);
        LOGGER.info(idOf4);
        idOf4.setName("Sickest Ganon and Falcon Plays");
        expService.updateExperiment(idOf4);
    }
}

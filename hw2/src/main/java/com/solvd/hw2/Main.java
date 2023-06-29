package com.solvd.hw2;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.hw2.CustomPool;
import com.solvd.hw2.builders.ExperimentBuilder;
import com.solvd.hw2.factories.ServiceFactory;
import com.solvd.hw2.jaxb.adapters.DateAdapter;
import com.solvd.hw2.models.*;
import com.solvd.hw2.services.interfaces.IClientService;
import com.solvd.hw2.services.interfaces.IEmployeeService;
import com.solvd.hw2.services.interfaces.IExperimentService;
import com.solvd.hw2.services.jdbc.ClientTypeService;

public class Main 
{
    private static final Logger LOGGER = LogManager.getLogger("Main");
    private static final String JDBC = System.getProperty("jdbc");
    private static final String MYBATIS = System.getProperty("mybatis");

    public static void main(String[] args) throws IOException, java.text.ParseException, SQLException, InterruptedException
    {
        CustomPool pool = new CustomPool();
        DateAdapter dateAdapter = new DateAdapter();
        IExperimentService expService = ServiceFactory.makeExpService(MYBATIS);
        IClientService clientService = ServiceFactory.makeClientService(MYBATIS);
        IEmployeeService employeeService = ServiceFactory.makeEmployeeService(MYBATIS);
        ClientTypeService clientTypeService = new ClientTypeService();

        LOGGER.info("Introducing Big Boss.");
        Client bigBoss = Helpers.getBoss(clientService, clientTypeService);
        LOGGER.info(bigBoss);

        LOGGER.info("Big Boss wants to commission Metal Gear Zeke at Mother Base.");

        //Institution motherBase = Helpers.getMotherBase();
        Scientist huey = employeeService.getScientistById(4);
        List<Scientist> scientists = new ArrayList<Scientist>();
        scientists.add(huey);

        Lab rad = Helpers.getRAndDLab();
        Experiment mGZeke = new ExperimentBuilder().withName("Metal Gear Zeke")
                                            .withStatus("Building")
                                            .withStart(dateAdapter.unmarshal("2023-06-29"))
                                            .withLab(rad)
                                            .withScientists(scientists)
                                            .build();
        

        expService.insertExperiment(mGZeke);
        LOGGER.info("Zeke is being built...");
        Thread.sleep(2000);
        LOGGER.info("Done.");
        mGZeke.setStatus("Completed");
        expService.updateExperiment(mGZeke);
    }
}

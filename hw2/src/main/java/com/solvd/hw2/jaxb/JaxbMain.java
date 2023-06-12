package com.solvd.hw2.jaxb;

import java.io.FileNotFoundException;
import java.util.List;
import javax.xml.bind.JAXBException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.hw2.jaxb.unmarshals.*;
import com.solvd.hw2.models.*;

public class JaxbMain 
{
    private static final Logger LOGGER = LogManager.getLogger("Jaxb Main");
    public static void main(String[] args) throws JAXBException, FileNotFoundException
    {
        ReportUnmarshaller reportUnmarshaller = new ReportUnmarshaller("hw2/src/main/resources/xml/reports/FalconGanonReport.xml");
        Report test = reportUnmarshaller.unmarshal();
        LOGGER.info("ID: " + test.getId());
        LOGGER.info("Report: " + test.getName());
        LOGGER.info("Link: " + test.getLink());

        ClientUnmarshaller clientMaker = new ClientUnmarshaller("hw2/src/main/resources/xml/clients/FalconGanon.xml");
        Client fg = clientMaker.unmarshal();
        LOGGER.info("Client id: " + fg.getId());
        LOGGER.info("Name: " + fg.getName());
        LOGGER.info("Client Type id: " + fg.getClientType().getClientTypeId());
        LOGGER.info("Client Type: " + fg.getClientType().getClientTypeName());

        ClientTypeUnmarshaller clientTypeMaker = new ClientTypeUnmarshaller("hw2/src/main/resources/xml/clienttypes/ForFun.xml");
        ClientType ct = clientTypeMaker.unmarshal();
        LOGGER.info("Type id: " + ct.getClientTypeId());
        LOGGER.info("Type name: " + ct.getClientTypeName());

        ExperimentUnmarshaller expMaker = new ExperimentUnmarshaller("hw2/src/main/resources/xml/experiments/FalconGanonPlays.xml");
        Experiment expTest = expMaker.unmarshal();
        LOGGER.info("Exp id: " + expTest.getId());
        LOGGER.info("Exp name: " + expTest.getName());
        LOGGER.info("Exp dates: " + expTest.getStartDate() + " and " + expTest.getEndDate());
        LOGGER.info("Exp type info:\n"
            + "Type name: " + expTest.getExperimentType().getTypeName()
            );

        Investment testInvestment = expTest.getInvestment();
        LOGGER.info("Exp investment info:\n" + 
            "Amount: " + testInvestment.getAmount() + "\n"
            + "Client: " + testInvestment.getClient().getClientType().getClientTypeName() + " " 
            + testInvestment.getClient().getName()
            );

        LOGGER.info("Scientists:");
        List<Scientist> scientists = expTest.getScientists();
        scientists.forEach((Scientist scientist) -> 
        {
            LOGGER.info(scientist.getFirstName() + " " + scientist.getLastName());
            LOGGER.info("Degree " + scientist.getDegree().getDegreeName() + " of id " + scientist.getDegree().getId());
        });

    }    
}

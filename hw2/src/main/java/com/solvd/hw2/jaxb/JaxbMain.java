package com.solvd.hw2.jaxb;

import java.io.FileNotFoundException;
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
    }    
}

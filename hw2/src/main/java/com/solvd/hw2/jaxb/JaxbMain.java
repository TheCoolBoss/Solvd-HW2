package com.solvd.hw2.jaxb;

import java.io.FileNotFoundException;
import javax.xml.bind.JAXBException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.hw2.jaxb.unmarshals.ClientUnmarshaller;
import com.solvd.hw2.jaxb.unmarshals.ReportUnmarshaller;
import com.solvd.hw2.models.*;

public class JaxbMain 
{
    private static final Logger LOGGER = LogManager.getLogger("Jaxb Main");
    public static void main(String[] args) throws JAXBException, FileNotFoundException
    {
        ReportUnmarshaller reportUnmarshaller = new ReportUnmarshaller("hw2/src/main/resources/xml/reports/FalconGanonReport.xml");
        Report test = reportUnmarshaller.unmarshal();
        LOGGER.info(test.getId());
        LOGGER.info(test.getName());

        ClientUnmarshaller clientMaker = new ClientUnmarshaller("hw2/src/main/resources/xml/clients/FalconGanon.xml");
        Client fg = clientMaker.unmarshal();
        LOGGER.info(fg.getName());
        LOGGER.info(fg.getClientType());
    }    
}

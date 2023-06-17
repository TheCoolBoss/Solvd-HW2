package com.solvd.hw2.jaxb;

import java.io.FileNotFoundException;
import javax.xml.bind.JAXBException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.hw2.models.*;

public class JaxbMain 
{
    private static final Logger LOGGER = LogManager.getLogger("Jaxb Main");
    private static final String PATH = "hw2/src/main/resources/xml/experiments/FalconGanonPlays.xml";
    public static void main(String[] args) throws JAXBException, FileNotFoundException
    {
        CustomUnmarshaller expMaker;
        try
        {
            expMaker = new CustomUnmarshaller(Experiment.class, PATH);
        }

        catch (FileNotFoundException fnfe)
        {
            expMaker = new CustomUnmarshaller(Experiment.class, "src/main/resources/xml/experiments/FalconGanonPlays.xml");
        }

        Experiment expTest = (Experiment) expMaker.unmarshal();
        LOGGER.info(expTest.toString());
    }    
}

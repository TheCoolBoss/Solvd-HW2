package com.solvd.hw2.parsers;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.solvd.hw2.jaxb.CustomUnmarshaller;
import com.solvd.hw2.models.*;

public class ParserMain 
{
    private static final String FALCON_GANON_PLAYS = "hw2/src/main/resources/xml/experiments/FalconGanonPlays.xml";
    private static final Logger LOGGER = LogManager.getLogger("Main");

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, URISyntaxException, JAXBException
    {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document falconGanon = builder.parse(FALCON_GANON_PLAYS);
        falconGanon.getDocumentElement().normalize();

        XmlParser expParser = new XmlParser(falconGanon, "experiment");
        
        XmlValidator playsVal = new XmlValidator("hw2/src/main/resources/xml/xsd/Experiment.xsd");
        LOGGER.info("Validating " + FALCON_GANON_PLAYS);

        //Currently having issues with using parser vals so just using JAXB after validation
        if (playsVal.check(FALCON_GANON_PLAYS))
        {
            CustomUnmarshaller expMaker = new CustomUnmarshaller(Experiment.class, FALCON_GANON_PLAYS);
            Experiment test = (Experiment) expMaker.unmarshal();
            LOGGER.info(test.toString());
        }


    }
}

package com.solvd.hw2.parsers;

import java.io.IOException;
import java.net.URISyntaxException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
public class ParserMain 
{
    //src
    private static final String FALCON_GANON = "hw2/src/main/resources/xml/clients/FalconGanon.xml";
    private static final String FALCON_GANON_PLAYS = "hw2/src/main/resources/xml/experiments/FalconGanonPlays.xml";
    private static final Logger LOGGER = LogManager.getLogger("Main");

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, URISyntaxException
    {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

        Document falconGanon = builder.parse(FALCON_GANON);
        falconGanon.getDocumentElement().normalize();

        XmlParser falconGanonParser = new XmlParser(falconGanon, "client");
        falconGanonParser.getElements();

        
        XmlValidator playsVal = new XmlValidator("hw2/src/main/resources/xml/xsd/Experiment.xsd");
        LOGGER.info("Validating " + FALCON_GANON_PLAYS);
        playsVal.check(FALCON_GANON_PLAYS);
        LOGGER.info("Result of validation: ");
        if (playsVal.getErrors().size() != 0)
        {
            playsVal.getErrors().forEach((SAXParseException saxpe) ->
            {
                LOGGER.info(saxpe.getMessage());
            });
        }

        else
        {
            LOGGER.info("No errors :)");
        }

        
    }
}

package com.solvd.hw2.parsers;

import java.io.IOException;
import java.net.URISyntaxException;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import com.solvd.hw2.models.*;
import com.solvd.hw2.parsers.makers.ExperimentMaker;

public class ParserMain 
{
    private static final String FALCON_GANON_PLAYS = "src/main/resources/xml/experiments/FalconGanonPlays.xml";
    private static final String FALCON_GANON_PLAYS_JSON = "src/main/resources/json/FalconGanonJson.json";
    private static final Logger LOGGER = LogManager.getLogger("Main");

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, URISyntaxException, JAXBException, DOMException, java.text.ParseException
    {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document falconGanon = builder.parse(FALCON_GANON_PLAYS);
        falconGanon.getDocumentElement().normalize();

        XmlParser expParser = new XmlParser(falconGanon, "experiment");
        
        XmlValidator playsVal = new XmlValidator("src/main/resources/xml/xsd/Experiment.xsd");
        LOGGER.info("Validating " + FALCON_GANON_PLAYS);

        if (playsVal.check(FALCON_GANON_PLAYS))
        {
            LOGGER.info("Making experiment from xml.");
            Experiment parsedExp = ExperimentMaker.makeExperiment(expParser.getElements());
            LOGGER.info(parsedExp.toString() + "\n\n");
        }

        JsonParser jsonVersion = new JsonParser(FALCON_GANON_PLAYS_JSON, Experiment.class);
        Experiment jsonExp = (Experiment) jsonVersion.parse();
        LOGGER.info("JSON version:");
        LOGGER.info(jsonExp);
    }
}

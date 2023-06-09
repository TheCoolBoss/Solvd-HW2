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
public class ParserMain 
{
    private static final String FALCON_GANON = "Solvd-HW2\\hw2\\src\\main\\java\\com\\solvd\\hw2\\parsers\\clients\\FalconGanon.xml";
    private static final String BEST_PLAYS = "Solvd-HW2\\hw2\\src\\main\\java\\com\\solvd\\hw2\\parsers\\labs\\BestPlays.xml";
    private static final String FALCON_GANON_INVEST = "Solvd-HW2\\hw2\\src\\main\\java\\com\\solvd\\hw2\\parsers\\investments\\FalconGanonInvest.xml";
    private static final String FALCON_GANON_PLAYS = "Solvd-HW2\\hw2\\src\\main\\java\\com\\solvd\\hw2\\parsers\\experiments\\FalconGanonPlays.xml";
    private static final Logger LOGGER = LogManager.getLogger("Main");

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, URISyntaxException
    {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

        Document falconGanon = builder.parse(FALCON_GANON);
        falconGanon.getDocumentElement().normalize();

        XmlParser falconGanonParser = new XmlParser(falconGanon, "client");
        falconGanonParser.getElements();



        Document bestPlays = builder.parse(BEST_PLAYS);
        bestPlays.getDocumentElement().normalize();

        XmlParser bestPlaysParser = new XmlParser(bestPlays, "lab");
        bestPlaysParser.getElements();



        Document falconGanonInvest = builder.parse(FALCON_GANON_INVEST);
        falconGanonInvest.getDocumentElement().normalize();

        XmlParser falconGanonInvestParser = new XmlParser(falconGanonInvest, "investment");
        falconGanonInvestParser.getElements();


        Document falconGanonPlays = builder.parse(FALCON_GANON_PLAYS);
        falconGanonPlays.getDocumentElement().normalize();

        XmlParser playsParser = new XmlParser(falconGanonPlays, "experiment");
        playsParser.getElements();



        XmlValidator falconGanonVal = new XmlValidator("Solvd-HW2\\hw2\\src\\main\\java\\com\\solvd\\hw2\\parsers\\xsd\\Client.xsd");
        LOGGER.info(falconGanonVal.isValid(FALCON_GANON));

        XmlValidator bestPlaysVal = new XmlValidator("Solvd-HW2\\hw2\\src\\main\\java\\com\\solvd\\hw2\\parsers\\xsd\\Lab.xsd");
        LOGGER.info(bestPlaysVal.isValid(BEST_PLAYS));

        XmlValidator investVal = new XmlValidator("Solvd-HW2\\hw2\\src\\main\\java\\com\\solvd\\hw2\\parsers\\xsd\\Investment.xsd");
        LOGGER.info(investVal.isValid(FALCON_GANON_INVEST));

        XmlValidator playsVal = new XmlValidator("Solvd-HW2\\hw2\\src\\main\\java\\com\\solvd\\hw2\\parsers\\xsd\\Experiment.xsd");
        LOGGER.info(playsVal.isValid(FALCON_GANON_PLAYS));
    }
}
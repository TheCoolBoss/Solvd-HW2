package com.solvd.hw2.jaxb.unmarshals;

import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import com.solvd.hw2.models.Experiment;


public class ExperimentUnmarshaller 
{
    private String xmlPath;

    public ExperimentUnmarshaller(String xmlPath) 
    {
        this.xmlPath = xmlPath;
    }

    public Experiment unmarshal() throws JAXBException, FileNotFoundException
    {
        JAXBContext context = JAXBContext.newInstance(Experiment.class);
        return (Experiment) context.createUnmarshaller().unmarshal(new FileReader(xmlPath));
    } 
}

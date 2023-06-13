package com.solvd.hw2.jaxb.unmarshals;

import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import com.solvd.hw2.models.Report;

public class ReportUnmarshaller 
{
    private String xmlPath;


    public ReportUnmarshaller(String xmlPath) 
    {
        this.xmlPath = xmlPath;
    }

    public Report unmarshal() throws JAXBException, FileNotFoundException
    {
        JAXBContext context = JAXBContext.newInstance(Report.class);
        return (Report) context.createUnmarshaller().unmarshal(new FileReader(xmlPath));
    }    
}

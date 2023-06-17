package com.solvd.hw2.jaxb;

import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

public class CustomUnmarshaller 
{
    private Class<?> contextTarget;
    private FileReader reader;

    public CustomUnmarshaller(Class<?> contextTarget, String xmlPath) throws FileNotFoundException
    {
        this.contextTarget = contextTarget;
        reader = new FileReader(xmlPath);
    }

    public Object unmarshal() throws JAXBException
    {
        JAXBContext context = JAXBContext.newInstance(contextTarget);
        return context.createUnmarshaller().unmarshal(reader);
    }
}

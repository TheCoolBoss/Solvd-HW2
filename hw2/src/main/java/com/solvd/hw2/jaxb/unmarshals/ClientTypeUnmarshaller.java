package com.solvd.hw2.jaxb.unmarshals;

import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import com.solvd.hw2.models.ClientType;

public class ClientTypeUnmarshaller 
{
    private String xmlPath;


    public ClientTypeUnmarshaller(String xmlPath) 
    {
        this.xmlPath = xmlPath;
    }

    public ClientType unmarshal() throws JAXBException, FileNotFoundException
    {
        JAXBContext context = JAXBContext.newInstance(ClientType.class);
        return (ClientType) context.createUnmarshaller().unmarshal(new FileReader(xmlPath));
    } 
}

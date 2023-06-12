package com.solvd.hw2.jaxb;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import com.solvd.hw2.models.ClientType;

public class Unmarshaller 
{
    private String xmlPath;


    public Unmarshaller(String xmlPath) 
    {
        this.xmlPath = xmlPath;
    }

    public ClientType unmarshal() throws JAXBException, FileNotFoundException
    {
        JAXBContext context = JAXBContext.newInstance(ClientType.class);
        return (ClientType) context.createUnmarshaller().unmarshal(new FileReader(xmlPath));
    }     
}

package com.solvd.hw2.jaxb.unmarshals;

import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import com.solvd.hw2.models.Client;

public class ClientUnmarshaller 
{   
    private String xmlPath;


    public ClientUnmarshaller(String xmlPath) 
    {
        this.xmlPath = xmlPath;
    }

    public Client unmarshal() throws JAXBException, FileNotFoundException
    {
        JAXBContext context = JAXBContext.newInstance(Client.class);
        return (Client) context.createUnmarshaller().unmarshal(new FileReader(xmlPath));
    }
}

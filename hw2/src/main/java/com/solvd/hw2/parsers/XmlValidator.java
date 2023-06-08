package com.solvd.hw2.parsers;

import java.io.File;
import java.net.URISyntaxException;
import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class XmlValidator 
{
    private Validator val;

    public XmlValidator(String xsd) throws URISyntaxException, SAXException
    {
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Source toUse = new StreamSource(new File(xsd));
        Schema schema = sf.newSchema(toUse);
        val = schema.newValidator();
    }


    public boolean isValid(String xml)
    {
        try
        {
            val.validate(new StreamSource(new File(xml)));
            return true;
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    }
}

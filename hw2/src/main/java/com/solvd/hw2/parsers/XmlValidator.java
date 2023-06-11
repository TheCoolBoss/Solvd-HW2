package com.solvd.hw2.parsers;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class XmlValidator 
{   
    private static final Logger LOGGER = LogManager.getLogger("Validator");
    private Validator val;
    private List<SAXParseException> errors;

    public XmlValidator(String xsd) throws URISyntaxException, SAXException
    {
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Source toUse = new StreamSource(new File(xsd));
        Schema schema = sf.newSchema(toUse);
        val = schema.newValidator();
        errors = new ArrayList<SAXParseException>();

        val.setErrorHandler(new ErrorHandler() 
        {
            public void warning(SAXParseException saxpe)
            {
                errors.add(saxpe);
            }

            public void error(SAXParseException saxpe)
            {
                errors.add(saxpe);
            }

            public void fatalError(SAXParseException saxpe)
            {
                errors.add(saxpe);
            }
        });

    }

    public List<SAXParseException> getErrors()
    {
        return errors;
    }

    public void check(String xml) throws SAXException, IOException
    {
        val.validate(new StreamSource(new File(xml)));
    }
}

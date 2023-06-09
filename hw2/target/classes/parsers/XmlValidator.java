package parsers;

import java.io.File;
import java.net.URISyntaxException;
import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

public class XmlValidator 
{   
    private static final Logger LOGGER = LogManager.getLogger("Validator");
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
        boolean ret = false;
        try
        {
            val.validate(new StreamSource(new File(xml)));
            return true;
        }

        catch (Exception e)
        {
            LOGGER.error(e.getMessage());
        }

        return ret;
    }
}

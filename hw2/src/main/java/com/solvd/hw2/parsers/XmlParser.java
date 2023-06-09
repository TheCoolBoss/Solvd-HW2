package com.solvd.hw2.parsers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlParser
{
    private static final Logger LOGGER = LogManager.getLogger("Parser");
    
    private Document doc;
    private String tagName;

    public XmlParser(Document doc, String tagName) 
    {
        this.doc = doc;
        this.tagName = tagName;
    }


    public void getElements()
    {
        NodeList nodes = doc.getElementsByTagName(tagName);

        for (int i = 0; i < nodes.getLength(); i++)
        {
            NodeList map = nodes.item(i).getChildNodes();
            for (int j = 0; j < map.getLength(); j++)
            {
                if (map.item(j).getNodeType() == Node.ELEMENT_NODE)
                {
                    LOGGER.info(map.item(j).getNodeName() + ": " + map.item(j).getTextContent());
                }

            }
        }
    }


    public NamedNodeMap getElementAttributes(Node node)
    {
        return node.getAttributes();
    }
}

package com.solvd.hw2.parsers;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class XmlParser
{    
    private Document doc;
    private String tagName;

    public XmlParser(Document doc, String tagName) 
    {
        this.doc = doc;
        this.tagName = tagName;
    }

    public NodeList getElements()
    {
        NodeList nodes = doc.getElementsByTagName(tagName);
        return nodes;
    }
}

package com.solvd.hw2.parsers.makers;

import org.w3c.dom.NodeList;
import com.solvd.hw2.models.ExperimentType;

public class ExperimentTypeMaker 
{
    public static ExperimentType makeExpType(NodeList typeInfo)
    {
        return new ExperimentType(Integer.parseInt(typeInfo.item(1).getTextContent()), typeInfo.item(3).getTextContent());
    }
}

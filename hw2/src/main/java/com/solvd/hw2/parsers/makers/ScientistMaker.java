package com.solvd.hw2.parsers.makers;

import org.w3c.dom.NodeList;

import com.solvd.hw2.models.Scientist;

public class ScientistMaker 
{
    public static Scientist makeScientist(NodeList scientistInfo)
    {
        Integer scientistId = Integer.parseInt(scientistInfo.item(1).getTextContent());
        String firstName = scientistInfo.item(3).getTextContent();
        String lastName = scientistInfo.item(5).getTextContent();
        NodeList degreeInfo = scientistInfo.item(7).getChildNodes();

        return new Scientist(scientistId, firstName, lastName, DegreeMaker.makeDegree(degreeInfo));
    }
}

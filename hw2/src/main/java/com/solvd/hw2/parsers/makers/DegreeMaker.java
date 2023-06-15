package com.solvd.hw2.parsers.makers;

import org.w3c.dom.NodeList;

import com.solvd.hw2.models.Degree;

public class DegreeMaker 
{
    public static Degree makeDegree(NodeList degreeInfo)
    {
        Integer degreeId = Integer.parseInt(degreeInfo.item(1).getTextContent());
        String degreeName = degreeInfo.item(3).getTextContent();
        Integer degreeYears = Integer.parseInt(degreeInfo.item(5).getTextContent());  

        return new Degree(degreeId, degreeName, degreeYears);
    }
}

package com.solvd.hw2.parsers.makers;

import org.w3c.dom.NodeList;

import com.solvd.hw2.models.Institution;

public class InstitutionMaker 
{
    public static Institution makeInstitution(NodeList institutionInfo)
    {
        Integer instId = Integer.parseInt(institutionInfo.item(1).getTextContent());
        String instName = institutionInfo.item(3).getTextContent(); 

        return new Institution(instId, instName);
    }
}

package com.solvd.hw2.parsers.makers;

import org.w3c.dom.NodeList;
import com.solvd.hw2.models.Lab;

public class LabMaker 
{
    public static Lab makeLab(NodeList labInfo)
    {
        Integer labId = Integer.parseInt(labInfo.item(1).getTextContent());
        String labName = labInfo.item(3).getTextContent();
        NodeList institutionInfo = labInfo.item(5).getChildNodes();
        NodeList locationInfo = labInfo.item(7).getChildNodes();

        return new Lab(labId, labName, LocationMaker.makeLocation(locationInfo), InstitutionMaker.makeInstitution(institutionInfo));
    }
}

package com.solvd.hw2.parsers.makers;

import org.w3c.dom.NodeList;

import com.solvd.hw2.models.Location;

public class LocationMaker 
{
    public static Location makeLocation(NodeList locationInfo)
    {
        Integer locId = Integer.parseInt(locationInfo.item(1).getTextContent());
        String city = locationInfo.item(3).getTextContent();            
        String country = locationInfo.item(5).getTextContent(); 

        return new Location(locId, city, country);
    }
}

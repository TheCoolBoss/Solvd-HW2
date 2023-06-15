package com.solvd.hw2.parsers.makers;

import org.w3c.dom.NodeList;
import com.solvd.hw2.models.ClientType;

public class ClientTypeMaker 
{
    public static ClientType makeClientType(NodeList clientTypeInfo)
    {
        Integer clientTypeId = Integer.parseInt(clientTypeInfo.item(1).getTextContent());
        String clientTypeName = clientTypeInfo.item(3).getTextContent();
        
        return new ClientType(clientTypeId, clientTypeName);
    }
}

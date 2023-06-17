package com.solvd.hw2.parsers.makers;

import org.w3c.dom.NodeList;
import com.solvd.hw2.models.Client;

public class ClientMaker 
{
    public static Client makeClient(NodeList clientInfo)
    {
        Integer clientId = Integer.parseInt(clientInfo.item(1).getTextContent());
        String clientName = clientInfo.item(3).getTextContent();
        NodeList clientTypeInfo = clientInfo.item(5).getChildNodes();

        return new Client(clientId, clientName, ClientTypeMaker.makeClientType(clientTypeInfo));
    }
}

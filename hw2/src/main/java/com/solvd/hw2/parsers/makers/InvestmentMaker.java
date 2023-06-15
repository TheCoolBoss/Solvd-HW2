package com.solvd.hw2.parsers.makers;

import org.w3c.dom.NodeList;

import com.solvd.hw2.models.Investment;

public class InvestmentMaker 
{
    public static Investment makeInvestment(NodeList investmentInfo)
    {
        Integer investId = Integer.parseInt(investmentInfo.item(1).getTextContent());
        Double investAmount = Double.parseDouble(investmentInfo.item(3).getTextContent());
        String bank = investmentInfo.item(7).getTextContent();
        NodeList clientInfo = investmentInfo.item(5).getChildNodes();

        return new Investment(investId, investAmount, bank, ClientMaker.makeClient(clientInfo));
    }
}

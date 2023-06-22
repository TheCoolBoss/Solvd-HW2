package com.solvd.hw2.parsers.makers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.w3c.dom.NodeList;
import com.solvd.hw2.jaxb.adapters.DateAdapter;
import com.solvd.hw2.models.*;

public class ExperimentMaker 
{
    public static Experiment makeExperiment(NodeList expInfo) throws ParseException
    {
        DateAdapter adapter = new DateAdapter();

        NodeList children = expInfo.item(0).getChildNodes();
        int id = 1000;
        String name = "";
        String status = "";
        Date start = null;
        Date end = null;
        ExperimentType expType = null;
        Report report = null;
        Investment investment = null;
        List<Scientist> scientists = new ArrayList<Scientist>();
        Lab lab = null;

        for (int j = 0; j < children.getLength(); j++)
        {
            System.out.println(children.item(j).getNodeName());
            if (children.item(j).getNodeName().contains("name"))
            {
                name = children.item(j).getTextContent();    
            }

            if (children.item(j).getNodeName().contains("status"))
            {
                status = children.item(j).getTextContent();    
            }

            if (children.item(j).getNodeName().contains("startDate"))
            {
                start = adapter.unmarshal(children.item(j).getTextContent());    
            }

            if (children.item(j).getNodeName().contains("endDate"))
            {
                end = adapter.unmarshal(children.item(j).getTextContent());    
            }

            if (children.item(j).getNodeName().contains("experimentType"))
            {
                NodeList typeInfo = children.item(j).getChildNodes();
                expType = ExperimentTypeMaker.makeExpType(typeInfo);   
            }        
            
            if (children.item(j).getNodeName().contains("report"))
            {
                NodeList reportInfo = children.item(j).getChildNodes();
                report = ReportMaker.makReport(reportInfo);    
            }

            if (children.item(j).getNodeName().contains("investment"))
            {
                NodeList investmentInfo = children.item(j).getChildNodes();
                investment = InvestmentMaker.makeInvestment(investmentInfo);  
            }    
            
            if (children.item(j).getNodeName().contains("scientists"))
            {
                NodeList scientistListInfo = children.item(j).getChildNodes();
                for (int k = 1; k < scientistListInfo.getLength(); k+=2) 
                {
                    NodeList scientistInfo = scientistListInfo.item(k).getChildNodes();
                    scientists.add(ScientistMaker.makeScientist(scientistInfo));
                }  
            }

            if (children.item(j).getNodeName().contains("lab"))
            {
                NodeList labInfo = children.item(j).getChildNodes();
                lab = LabMaker.makeLab(labInfo);
            } 
        }
                
        Experiment ret = new Experiment(id, name, status, start, end, expType, investment, report, lab);
        ret.setScientists(scientists);
        
        return ret;
    }
}

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

        Integer id = Integer.parseInt(children.item(1).getTextContent());
        String name = children.item(3).getTextContent();
        String status = children.item(5).getTextContent();
        Date start = adapter.unmarshal(children.item(7).getTextContent());
        Date end = adapter.unmarshal(children.item(9).getTextContent());

        NodeList typeInfo = children.item(11).getChildNodes();
        ExperimentType type = ExperimentTypeMaker.makeExpType(typeInfo);
        
        NodeList reportInfo = children.item(13).getChildNodes();
        Report report = ReportMaker.makReport(reportInfo);

        NodeList investmentInfo = children.item(15).getChildNodes();
        Investment investment = InvestmentMaker.makeInvestment(investmentInfo);

        List<Scientist> scientists = new ArrayList<Scientist>();
        NodeList scientistListInfo = children.item(17).getChildNodes();
        for (int i = 1; i < scientistListInfo.getLength(); i+=2) 
        {
            NodeList scientistInfo = scientistListInfo.item(i).getChildNodes();
            scientists.add(ScientistMaker.makeScientist(scientistInfo));
        }


        NodeList labInfo = children.item(19).getChildNodes();
        Lab lab = LabMaker.makeLab(labInfo);

        Experiment ret = new Experiment(id, name, status, start, end, type, investment, report, lab);
        ret.setScientists(scientists);
        
        return ret;
    }
}

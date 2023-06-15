package com.solvd.hw2.parsers.makers;

import org.w3c.dom.NodeList;
import com.solvd.hw2.models.Report;

public class ReportMaker 
{
    public static Report makReport(NodeList reportInfo)
    {
        Integer reportId = Integer.parseInt(reportInfo.item(1).getTextContent());
        String reportName = reportInfo.item(3).getTextContent();
        String link = reportInfo.item(5).getTextContent();

        return new Report(reportId, reportName, link);
    }
}

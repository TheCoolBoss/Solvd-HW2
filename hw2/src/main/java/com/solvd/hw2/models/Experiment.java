package com.solvd.hw2.models;

import java.util.Date;

public class Experiment 
{
    private int id;
    private String name;
    private String status;
    private Date startDate;
    private Date endDate;
    private int experimentTypeId;
    private int investmentId;
    private int reportId;
    private int labId;

    public Experiment(int id, String name, String status, Date startDate, Date endDate, int experimentTypeId,
            int investmentId, int reportId, int labId) 
    {
        this.id = id;
        this.name = name;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.experimentTypeId = experimentTypeId;
        this.investmentId = investmentId;
        this.reportId = reportId;
        this.labId = labId;
    }

    public int getId() 
    {
        return id;
    }

    public void setId(int id) 
    {
        this.id = id;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getStatus() 
    {
        return status;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public Date getStartDate() 
    {
        return startDate;
    }

    public void setStartDate(Date startDate) 
    {
        this.startDate = startDate;
    }

    public Date getEndDate() 
    {
        return endDate;
    }

    public void setEndDate(Date endDate) 
    {
        this.endDate = endDate;
    }

    public int getExperimentTypeId() 
    {
        return experimentTypeId;
    }

    public void setExperimentTypeId(int experimentTypeId) 
    {
        this.experimentTypeId = experimentTypeId;
    }

    public int getInvestmentId() 
    {
        return investmentId;
    }

    public void setInvestmentId(int investmentId) 
    {
        this.investmentId = investmentId;
    }

    public int getReportId() 
    {
        return reportId;
    }

    public void setReportId(int reportId) 
    {
        this.reportId = reportId;
    }

    public int getLabId() 
    {
        return labId;
    }

    public void setLabId(int labId)
    {
        this.labId = labId;
    }

    
}

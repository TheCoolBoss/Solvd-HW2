package com.solvd.hw2.models;

import java.util.Date;

public class Experiment 
{
    private int id;
    private String name;
    private String status;
    private Date startDate;
    private Date endDate;
    private ExperimentType experimentType;
    private Investment investment;
    private Report report;
    private Lab lab;

    public Experiment(int id, String name, String status, Date startDate, Date endDate, ExperimentType experimentType,
            Investment investment, Report report, Lab lab) 
    {
        this.id = id;
        this.name = name;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.experimentType = experimentType;
        this.investment = investment;
        this.report = report;
        this.lab = lab;
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

    public ExperimentType getExperimentType() 
    {
        return experimentType;
    }

    public void setExperimentType(ExperimentType experimentType) 
    {
        this.experimentType = experimentType;
    }

    public Investment getInvestment() 
    {
        return investment;
    }

    public void setInvestment(Investment investment) 
    {
        this.investment = investment;
    }

    public Report getReport() 
    {
        return report;
    }

    public void setReport(Report report) 
    {
        this.report = report;
    }

    public Lab getLab() 
    {
        return lab;
    }

    public void setLab(Lab lab) 
    {
        this.lab = lab;
    }
}

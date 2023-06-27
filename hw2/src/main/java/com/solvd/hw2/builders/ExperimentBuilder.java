package com.solvd.hw2.builders;

import java.util.Date;
import java.util.List;

import com.solvd.hw2.models.*;

public class ExperimentBuilder 
{
    private Integer id;
    private String name;
    private String status;
    private Date startDate;
    private Date endDate;
    private ExperimentType experimentType;
    private Investment investment;
    private Report report;
    private Lab lab;
    private List<Scientist> scientists;    

    public ExperimentBuilder withId(int id)
    {
        this.id= id;
        return this;
    }

    public ExperimentBuilder withName(String name)
    {
        this.name = name;
        return this;
    }

    public ExperimentBuilder withStatus(String status)
    {
        this.status = status;
        return this;
    }

    public ExperimentBuilder withStart(Date start)
    {
        startDate = start;
        return this;
    }
 
    public ExperimentBuilder withEnd(Date end)
    {
        endDate = end;
        return this;
    }   

    public ExperimentBuilder withType(ExperimentType expType)
    {
        experimentType = expType;
        return this;
    }

    public ExperimentBuilder withInvestment(Investment investment)
    {
        this.investment = investment;
        return this;
    }

    public ExperimentBuilder withReport(Report report)
    {
        this.report = report;
        return this;
    }

    public ExperimentBuilder withLab(Lab lab)
    {
        this.lab = lab;
        return this;
    }  

    public ExperimentBuilder withScientists(List<Scientist> scientists)
    {
        this.scientists = scientists;
        return this;
    }

    public Integer getId() 
    {
        return id;
    }

    public String getName() 
    {
        return name;
    }

    public String getStatus() 
    {
        return status;
    }

    public Date getStartDate()
    {
        return startDate;
    }

    public Date getEndDate() 
    {
        return endDate;
    }

    public ExperimentType getExperimentType() 
    {
        return experimentType;
    }

    public Investment getInvestment() 
    {
        return investment;
    }

    public Report getReport() 
    {
        return report;
    }

    public Lab getLab() 
    {
        return lab;
    }

    public List<Scientist> getScientists() 
    {
        return scientists;
    }

    public Experiment build()
    {
        return new Experiment(id, name, status, startDate, endDate, experimentType, investment, report, lab);
    }

}

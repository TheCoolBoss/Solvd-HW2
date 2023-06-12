package com.solvd.hw2.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.solvd.hw2.models.abstracts.Model;

public class Experiment extends Model
{
    private static final String ID_COL = "experimentId";
    private static final String NAME_COL = "experimentName";
    private static final String STATUS_COL = "status";
    private static final String START_COL = "startDate"; 
    private static final String END_COL = "endDate";
    private static final String TYPE_COL = "experimentTypeId";
    private static final String INVEST_COL = "investmentId";
    private static final String REPORT_COL = "reportId";
    private static final String LAB_COL = "labId";

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

    public Experiment(Integer id, String name, String status, Date startDate, Date endDate, ExperimentType experimentType,
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
        scientists = new ArrayList<Scientist>();
    }

    protected void populateFieldsAndVals()
    {
        if (id != null)
        {
            vals.add(id);
            fields.add(ID_COL);
        }

        if (name != null)
        {
            vals.add(name);
            fields.add(NAME_COL);
        }

        if (status != null)
        {
            vals.add(status);
            fields.add(STATUS_COL);
        }

        if (startDate != null)
        {
            vals.add(startDate);
            fields.add(START_COL);
        }

        if (endDate != null)
        {
            vals.add(endDate);
            fields.add(END_COL);
        }

        if (experimentType != null)
        {
            vals.add(experimentType.getId());
            fields.add(TYPE_COL);
        }

        if (investment != null)
        {
            vals.add(investment.getId());
            fields.add(INVEST_COL);
        }

        if (report != null)
        {
            vals.add(report.getId());
            fields.add(REPORT_COL);
        }

        if (lab != null)
        {
            vals.add(lab.getId());
            fields.add(LAB_COL);
        }
    }

    public Integer getId() 
    {
        return id;
    }

    public void setId(Integer id) 
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

    public List<Scientist> getScientists() 
    {
        return scientists;
    }

    public void setScientists(List<Scientist> scientists) 
    {
        this.scientists = scientists;
    }
}

package com.solvd.hw2.models;

public class ExperimentGroup 
{
    private int id;
    private int experimentId;
    private int scientistId;

    
    public ExperimentGroup(int id, int experimentId, int scientistId) 
    {
        this.id = id;
        this.experimentId = experimentId;
        this.scientistId = scientistId;
    }

    public int getId() 
    {
        return id;
    }

    public void setId(int id) 
    {
        this.id = id;
    }

    public int getExperimentId() 
    {
        return experimentId;
    }

    public void setExperimentId(int experimentId) 
    {
        this.experimentId = experimentId;
    }

    public int getScientistId() 
    {
        return scientistId;
    }

    public void setScientistId(int scientistId) 
    {
        this.scientistId = scientistId;
    }
}

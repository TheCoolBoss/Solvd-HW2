package com.solvd.hw2.models;

public class ExperimentType 
{
    private int id;
    private String typeName;

    public ExperimentType(int id, String typeName) 
    {
        this.id = id;
        this.typeName = typeName;
    }

    
    public int getId() 
    {
        return id;
    }

    public void setId(int id) 
    {
        this.id = id;
    }

    public String getTypeName() 
    {
        return typeName;
    }

    public void setTypeName(String typeName) 
    {
        this.typeName = typeName;
    }
    
}

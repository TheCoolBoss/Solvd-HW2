package com.solvd.hw2.models;

public class Degree 
{
    private int id;
    private String degreeName;
    private int numOfYears;

    public Degree(int id, String degreeName, int numOfYears) 
    {
        this.id = id;
        this.degreeName = degreeName;
        this.numOfYears = numOfYears;
    }


    public int getId() 
    {
        return id;
    }
    public void setId(int id) 
    {
        this.id = id;
    }
    public String getDegreeName() 
    {
        return degreeName;
    }

    
    public void setDegreeName(String degreeName) 
    {
        this.degreeName = degreeName;
    }
    public int getNumOfYears() 
    {
        return numOfYears;
    }
    public void setNumOfYears(int numOfYears) 
    {
        this.numOfYears = numOfYears;
    }
}

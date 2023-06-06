package com.solvd.hw2.models;

import java.util.List;

public class Scientist 
{
    private int id;
    private String firstName;
    private String lastName;
    private Degree degree;
    private List<Experiment> experiments;

    public Scientist(int id, String firstName, String lastName, Degree degree, List<Experiment> experiments) 
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.degree = degree;
        this.experiments = experiments;
    }


    public int getId() 
    {
        return id;
    }

    public void setId(int id) 
    {
        this.id = id;
    }

    public String getFirstName() 
    {
        return firstName;
    }

    public void setFirstName(String firstName) 
    {
        this.firstName = firstName;
    }

    public String getLastName() 
    {
        return lastName;
    }

    public void setLastName(String lastName) 
    {
        this.lastName = lastName;
    }

    public Degree getDegree() 
    {
        return degree;
    }

    public void setDegree(Degree degree) 
    {
        this.degree = degree;
    }

    public List<Experiment> getExperiments() 
    {
        return experiments;
    }

    public void setExperiments(List<Experiment> experiments) 
    {
        this.experiments = experiments;
    }




}

package com.solvd.hw2.models;

public class Scientist 
{
    private int id;
    private String firstName;
    private String lastName;
    private int degreeId;

    
    public Scientist(int id, String firstName, String lastName, int degreeId)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.degreeId = degreeId;
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

    public int getDegreeId() 
    {
        return degreeId;
    }

    public void setDegreeId(int degreeId) 
    {
        this.degreeId = degreeId;
    }


}

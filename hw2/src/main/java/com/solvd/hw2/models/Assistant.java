package com.solvd.hw2.models;

public class Assistant 
{
    private int id;
    private String firstName;
    private String lastName;
    private int assisteeId;


    public Assistant(int id, String firstName, String lastName, int assisteeId)
    {
        this.id= id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.assisteeId = assisteeId;
    }

    public int getId() 
    {
        return id;
    }

    public String getFirstName() 
    {
        return firstName;
    }

    public String getLastName() 
    {
        return lastName;
    }

    public int getAssisteeId() 
    {
        return assisteeId;
    }

    
    public void setId(int id) 
    {
        this.id = id;
    }

    public void setFirstName(String firstName) 
    {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) 
    {
        this.lastName = lastName;
    }

    public void setAssisteeId(int assisteeId) 
    {
        this.assisteeId = assisteeId;
    }
}

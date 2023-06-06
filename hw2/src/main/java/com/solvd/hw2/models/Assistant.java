package com.solvd.hw2.models;

public class Assistant 
{
    private int id;
    private String firstName;
    private String lastName;
    Scientist assistee;


    public Assistant(int id, String firstName, String lastName, Scientist assistee)
    {
        this.id= id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.assistee = assistee;
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


    public Scientist getAssistee()
    {
        return assistee;
    }

    public void setAssistee(Scientist assistee) 
    {
        this.assistee = assistee;
    }

}

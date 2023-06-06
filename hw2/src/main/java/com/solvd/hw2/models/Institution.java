package com.solvd.hw2.models;

public class Institution 
{
    private int id;
    private String name;

    public Institution(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public int getId() 
    {
        return id;
    }

    public String getName() 
    {
        return name;
    }
}

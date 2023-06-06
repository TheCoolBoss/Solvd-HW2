package com.solvd.hw2.models;

public class Client 
{
    private int id;
    private String name;
    private int clientTypeId;

    public Client(int id, String name, int clientTypeId) 
    {
        this.id = id;
        this.name = name;
        this.clientTypeId = clientTypeId;
    }

    public int getId() 
    {
        return id;
    }
    public String getName() 
    {
        return name;
    }
    public int getClientTypeId() 
    {
        return clientTypeId;
    }

    
    public void setId(int id) 
    {
        this.id = id;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public void setClientTypeId(int clientTypeId) 
    {
        this.clientTypeId = clientTypeId;
    }
}

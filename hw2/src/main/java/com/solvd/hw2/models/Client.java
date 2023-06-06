package com.solvd.hw2.models;

public class Client 
{
    private int id;
    private String name;
    private ClientType clientType;

    public Client(int id, String name, ClientType type) 
    {
        this.id = id;
        this.name = name;
        this.clientType = type;
    }

    public int getId() 
    {
        return id;
    }
    public String getName() 
    {
        return name;
    }
    public ClientType getClientType() 
    {
        return clientType;
    }

    
    public void setId(int id) 
    {
        this.id = id;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public void setClientTypeId(ClientType clientType) 
    {
        this.clientType = clientType;
    }
}

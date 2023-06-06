package com.solvd.hw2.models;

public class ClientType 
{
    private int id;
    private String clientTypeName;

    public ClientType(int id, String clientTypeName) 
    {
        this.id = id;
        this.clientTypeName = clientTypeName;
    }

    public int getId() 
    {
        return id;
    }
    public String getClientTypeName() 
    {
        return clientTypeName;
    }


    public void setId(int id) 
    {
        this.id = id;
    }
    public void setClientTypeName(String clientTypeName) 
    {
        this.clientTypeName = clientTypeName;
    }


}

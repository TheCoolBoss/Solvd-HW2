package com.solvd.hw2.mybatis.models;

public class MBClient 
{
    private Integer clientId;
    private String clientName;
    private Integer clientTypeId;

    public MBClient(Integer id, String name, Integer clientTypeId) 
    {
        this.clientId = id;
        this.clientName = name;
        this.clientTypeId = clientTypeId;
    }

    public String toString()
    {
        return 
        "Client " + clientName + ":\n"
        + "Id: " + clientId + "\n"
        + "Type id: " + clientTypeId;
    }
}

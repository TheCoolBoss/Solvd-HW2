package com.solvd.hw2.models;

import java.util.ArrayList;

import com.solvd.hw2.models.abstracts.Model;

public class Client extends Model
{
    private static final String ID_COL = "clientId";
    private static final String NAME_COL = "clientName";
    private static final String TYPE_COL = "clientTypeId";

    private Integer id;
    private String name;
    private ClientType clientType;

    public Client(Integer id, String name, ClientType type) 
    {
        this.id = id;
        this.name = name;
        this.clientType = type;
    }


    public ArrayList<Object> getVals()
    {
        ArrayList<Object> ret = new ArrayList<Object>();

        if (id != null)
        {
            ret.add(id);
        }

        if (name != null)
        {
            ret.add(name);
        }

        if (clientType != null)
        {
            ret.add(clientType.getId());
        }

        return ret;
    }
    
    public ArrayList<String> getFields()
    {
        ArrayList<String> toRet = new ArrayList<String>();

        if (id != null)
        {
            toRet.add(ID_COL);
        }

        if (name != null)
        {
            toRet.add(NAME_COL);
        }

        if (clientType != null)
        {
            toRet.add(TYPE_COL);
        }

        return toRet;
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

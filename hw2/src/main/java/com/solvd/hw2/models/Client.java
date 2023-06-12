package com.solvd.hw2.models;

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
        populateFieldsAndVals();
    }

    protected void populateFieldsAndVals()
    {
        if (id != null)
        {
            vals.add(id);
            fields.add(ID_COL);
        }

        if (name != null)
        {
            vals.add(name);
            fields.add(NAME_COL);
        }

        if (clientType != null)
        {
            vals.add(clientType.getId());
            fields.add(TYPE_COL);
        }
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

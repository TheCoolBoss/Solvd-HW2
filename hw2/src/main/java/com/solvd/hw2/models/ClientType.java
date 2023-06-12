package com.solvd.hw2.models;

import com.solvd.hw2.models.abstracts.Model;

public class ClientType extends Model
{
    private static final String ID_COL = "clientTypeId";
    private static final String NAME_COL = "clientTypeName";

    private Integer id;
    private String clientTypeName;

    public ClientType(Integer id, String clientTypeName) 
    {
        this.id = id;
        this.clientTypeName = clientTypeName;
        populateFieldsAndVals();
    }

    protected void populateFieldsAndVals()
    {
        if (id != null)
        {
            vals.add(id);
            fields.add(ID_COL);
        }

        if (clientTypeName != null)
        {
            vals.add(clientTypeName);
            fields.add(NAME_COL);
        }
    }

    public Integer getId() 
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

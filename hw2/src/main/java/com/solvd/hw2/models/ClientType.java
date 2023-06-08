package com.solvd.hw2.models;

import java.util.ArrayList;
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
    }


    public ArrayList<Object> getVals()
    {
        ArrayList<Object> ret = new ArrayList<Object>();

        if (id != null)
        {
            ret.add(id);
        }

        if (clientTypeName != null)
        {
            ret.add(clientTypeName);
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

        if (clientTypeName != null)
        {
            toRet.add(NAME_COL);
        }

        return toRet;
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

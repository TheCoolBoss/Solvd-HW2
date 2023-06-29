package com.solvd.hw2.models;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.solvd.hw2.models.abstracts.Model;

@XmlRootElement (name="clientType")
@XmlAccessorType (XmlAccessType.FIELD)
@JsonRootName ("clientType")
public class ClientType extends Model
{
    private static final String ID_COL = "clientTypeId";
    private static final String NAME_COL = "clientTypeName";

    private Integer clientTypeId;
    private String clientTypeName;

    public ClientType(){}
    
    public ClientType(Integer id, String clientTypeName) 
    {
        this.clientTypeId = id;
        this.clientTypeName = clientTypeName;
        populateFieldsAndVals();
    }

    protected void populateFieldsAndVals()
    {
        if (clientTypeId != null)
        {
            vals.add(clientTypeId);
            fields.add(ID_COL);
        }

        if (clientTypeName != null)
        {
            vals.add(clientTypeName);
            fields.add(NAME_COL);
        }
    }

    @JsonGetter ("clientTypeId")
    public Integer getClientTypeId() 
    {
        return clientTypeId;
    }

    @JsonGetter ("clientTypeName")
    public String getClientTypeName() 
    {
        return clientTypeName;
    }

    public void setClientTypeId(Integer id) 
    {
        this.clientTypeId = id;
    }

    public void setClientTypeName(String clientTypeName) 
    {
        this.clientTypeName = clientTypeName;
    }

    public String toString()
    {
        return 
        "Client type " + clientTypeName + ":\n"
        + "Id: " + clientTypeId;
    }

    public ArrayList<String> getFields()
    {
        return this.fields;
    }

    public ArrayList<Object> getVals()
    {
        return this.vals;
    }
}

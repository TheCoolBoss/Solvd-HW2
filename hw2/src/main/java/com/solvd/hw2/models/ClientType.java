package com.solvd.hw2.models;

import javax.xml.bind.annotation.XmlRootElement;
import com.solvd.hw2.models.abstracts.Model;

@XmlRootElement (name="clientType")
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

    public Integer getClientTypeId() 
    {
        return clientTypeId;
    }

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
}

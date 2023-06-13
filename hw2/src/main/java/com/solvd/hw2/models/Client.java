package com.solvd.hw2.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import com.solvd.hw2.models.abstracts.Model;

@XmlRootElement (name="client")
@XmlAccessorType (XmlAccessType.FIELD)
public class Client extends Model
{
    private static final String ID_COL = "clientId";
    private static final String NAME_COL = "clientName";
    private static final String TYPE_COL = "clientTypeId";

    @XmlElement (name="clientId")
    private Integer id;
    
    @XmlElement (name="clientName")
    private String name;

    private ClientType clientType;

    public Client(){}
    
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
            vals.add(clientType.getClientTypeId());
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

    public void setClientType(ClientType clientType) 
    {
        this.clientType = clientType;
    }

    public String toString()
    {
        return 
        clientType.getClientTypeName() + " Client " + name + ":\n"
        + "Id: " + id;
    }
}

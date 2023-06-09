package com.solvd.hw2.generators;

import com.solvd.hw2.models.Client;
import com.solvd.hw2.models.ClientType;

public class CriteriaGen 
{
    public Client genClientCriteria(boolean useId, boolean useName, boolean useClientType)
    {
        Client ret = new Client(null, null, null);
        if (useId)
        {
            ret.setId(0);
        }

        if (useName)
        {
            ret.setName("");
        }

        if (useClientType)
        {
            ret.setClientTypeId(new ClientType(0, ""));
        }

        return ret;
    }    
}

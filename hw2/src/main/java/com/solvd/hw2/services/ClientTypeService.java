package com.solvd.hw2.services;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.hw2.dao.ClientTypeDao;
import com.solvd.hw2.models.ClientType;

public class ClientTypeService 
{
    private static final Logger LOGGER = LogManager.getLogger("ClientType Service");
    private static final ClientTypeDao TYPE_DAO = new ClientTypeDao();

    public String getTypeNameById(int id)
    {
        //There should only be 1 instance of an id so not too concerned about a list
        //List<String> ret = new ArrayList<String>();
        ClientType fields = new ClientType(null, "");
        ClientType criteria = new ClientType(id, null);

        List<ClientType> returnedVals = TYPE_DAO.select(fields.getFields(), criteria, "= ");

        return returnedVals.get(0).getClientTypeName();
    }
}
package com.solvd.hw2.services;

import java.util.List;
import com.solvd.hw2.dao.ClientDao;
import com.solvd.hw2.models.Client;
import com.solvd.hw2.models.ClientType;

public class ClientService 
{
    private static final ClientDao CLIENT_DAO = new ClientDao();
    private static final String CLIENT_TABLE = "clients";


    public void insertClient(Client toInsert)
    {
        CLIENT_DAO.insert(toInsert, CLIENT_TABLE);
    }

    //Currently selects all cols
    public List<Client> getById(int id)
    {
        Client allFields = new Client(null, null, null);
        Client criteria = new Client(id, null, null);

        List<Client> ret = CLIENT_DAO.select(allFields.getFields(), criteria, " = ");
        return ret;
    }

    public List<Client> getByTypeId(int typeId)
    {
        Client allFields = new Client(null, null, null);
        Client criteria = new Client(null, null, new ClientType(typeId, null));

        List<Client> ret = CLIENT_DAO.select(allFields.getFields(), criteria, " = ");
        return ret;
    }

}

package com.solvd.hw2.services.jdbc;

import java.util.List;
import com.solvd.hw2.dao.jdbc.ClientDao;
import com.solvd.hw2.models.Client;
import com.solvd.hw2.models.ClientType;

public class ClientService 
{
    private static final ClientDao CLIENT_DAO = new ClientDao();
    private static final ClientTypeService TYPE_SERVICE = new ClientTypeService();
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

        return doSelect(allFields, criteria);
    }

    public List<Client> getByTypeId(int typeId)
    {
        Client allFields = new Client(null, null, null);
        Client criteria = new Client(null, null, new ClientType(typeId, null));

        return doSelect(allFields, criteria);
    }

    private List<Client> doSelect(Client fields, Client criteria)
    {
        List<Client> ret = CLIENT_DAO.select(fields.getFields(), criteria, " = ");
        for (Client client : ret) 
        {
            client.getClientType().setClientTypeName(TYPE_SERVICE.getTypeNameById(client.getClientType().getClientTypeId()));
        }
        return ret;
    }

}

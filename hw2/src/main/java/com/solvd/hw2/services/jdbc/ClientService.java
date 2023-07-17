package com.solvd.hw2.services.jdbc;

import java.util.List;
import com.solvd.hw2.dao.jdbc.ClientDao;
import com.solvd.hw2.dao.jdbc.ClientTypeDao;
import com.solvd.hw2.models.Client;
import com.solvd.hw2.models.ClientType;
import com.solvd.hw2.services.interfaces.IClientService;

public class ClientService implements IClientService
{
    private static final ClientDao CLIENT_DAO = new ClientDao();
    private static final ClientTypeDao TYPE_DAO = new ClientTypeDao();
    private static final String CLIENT_TABLE = "clients";
    private static final String TYPE_TABLE = "clientTypes";


    public void insertClient(Client toInsert)
    {
        CLIENT_DAO.insert(toInsert, CLIENT_TABLE);
    }

    //Currently selects all cols
    public Client getClientById(int id)
    {
        Client allFields = new Client(null, null, null);
        Client criteria = new Client(id, null, null);

        return doSelect(allFields, criteria).get(0);
    }

    public List<Client> getClientsByTypeId(int typeId)
    {
        Client allFields = new Client(null, null, null);
        Client criteria = new Client(null, null, new ClientType(typeId, null));

        return doSelect(allFields, criteria);
    }

    public Client getClientByName(String name)
    {
        Client allFields = new Client(null, null, null);
        Client criteria = new Client(null, name, new ClientType(null, null));
        
        return doSelect(allFields, criteria).get(0);
    }

    public void updateClient(Client newVals)
    {
        Client criteria = new Client(newVals.getId(), null, null);
        CLIENT_DAO.update(newVals, criteria, CLIENT_TABLE, " = ");
    }

    private List<Client> doSelect(Client fields, Client criteria)
    {
        List<Client> ret = CLIENT_DAO.select(fields.getFields(), criteria, " = ");
        ClientType typeFields = new ClientType(null, null);

        for (Client client : ret) 
        {
            client.setClientType((TYPE_DAO.select(typeFields.getFields(), client.getClientType(), TYPE_TABLE)).get(0));
        }
        return ret;
    }

}

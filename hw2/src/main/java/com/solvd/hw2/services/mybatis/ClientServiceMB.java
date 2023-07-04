package com.solvd.hw2.services.mybatis;

import java.io.IOException;
import java.util.List;
import com.solvd.hw2.dao.mybatis.ClientMBDao;
import com.solvd.hw2.models.Client;
import com.solvd.hw2.services.abstracts.ServiceMB;
import com.solvd.hw2.services.interfaces.IClientService;

public class ClientServiceMB extends ServiceMB implements IClientService
{
    private ClientMBDao clientDao;

    public ClientServiceMB() throws IOException
    {
        setUpService();
        clientDao = new ClientMBDao(factory);
    }

    public void insertClient(Client toInsert)
    {
        clientDao.insertClient(toInsert);
    }

    public Client getClientById(int id)
    {
        return clientDao.getClientById(id);
    }

    public List<Client> getClientsByTypeId(int id)
    {
        return clientDao.getClientByTypeId(id);
    }

    public Client getClientByName(String name)
    {
        return clientDao.getClientByName(name);
    }
    
    public void updateClient(Client newVals)
    {
        clientDao.updateClient(newVals);
    }
}

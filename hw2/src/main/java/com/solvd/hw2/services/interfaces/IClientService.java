package com.solvd.hw2.services.interfaces;

import java.util.List;
import com.solvd.hw2.models.Client;

public interface IClientService 
{
    public void insertClient(Client toInsert);
    public Client getClientById(int id);
    public List<Client> getClientsByTypeId(int id);
    public void updateClient(Client newVals);
    public Client getClientByName(String name);
}

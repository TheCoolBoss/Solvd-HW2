package com.solvd.hw2.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.hw2.CustomPool;
import com.solvd.hw2.dao.abstracts.Dao;
import com.solvd.hw2.models.Client;
import com.solvd.hw2.models.ClientType;

public class ClientDao extends Dao
{
    private static final Logger LOGGER = LogManager.getLogger("Client DAO");
    private static final String CLIENT_TABLE = "clients";
    private static final String ID_COL = "clientId";
    private static final String NAME_COL = "clientName";
    private static final String TYPE_COL = "clientTypeId";

    public List<Client> select(ArrayList<String> fields, Client criteriaVals, String operator)
    {
        try
        {
            ArrayList<Client> ret = new ArrayList<Client>();
            ResultSet results = getSelectResults(fields, criteriaVals, CLIENT_TABLE, operator);

            while (results.next())
            {
                Integer newId = null;
                String newName = null;
                ClientType newType = new ClientType(null, null);

                for (int i = 1; i <= results.getMetaData().getColumnCount(); i++)
                {
                    if (results.getMetaData().getColumnLabel(i).equals(ID_COL))
                    {
                        newId = results.getInt(i);
                    }

                    else if (results.getMetaData().getColumnLabel(i).equals(NAME_COL))
                    {
                        newName = results.getString(i);
                    }

                    else if (results.getMetaData().getColumnLabel(i).equals(TYPE_COL))
                    {
                        newType.setClientTypeId(results.getInt(i));
                    }
                }

                ret.add(new Client(newId, newName, newType));
            }
            
            CustomPool.releaseConn();
            return ret;
        }

        catch (SQLException | InterruptedException sqle)
        {
            LOGGER.error(sqle.getMessage());
            return null;
        }
    }
}

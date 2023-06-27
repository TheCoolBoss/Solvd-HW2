package com.solvd.hw2.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.hw2.CustomPool;
import com.solvd.hw2.dao.abstracts.Dao;
import com.solvd.hw2.models.ClientType;

public class ClientTypeDao extends Dao
{
    private static final Logger LOGGER = LogManager.getLogger("Client Type DAO");
    private static final String CLIENT_TYPE_TABLE = "clientTypes";
    private static final String ID_COL = "clientTypeId";
    private static final String NAME_COL = "clientTypeName";

    public List<ClientType> select(ArrayList<String> fields, ClientType criteriaVals, String operator)
    {
        try
        {
            ArrayList<ClientType> ret = new ArrayList<ClientType>();
            ResultSet results = getSelectResults(fields, criteriaVals, CLIENT_TYPE_TABLE, operator);

            while (results.next())
            {
                Integer newId = null;
                String newName = null;

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
                }

                ret.add(new ClientType(newId, newName));
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

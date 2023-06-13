package com.solvd.hw2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.hw2.CustomPool;
import com.solvd.hw2.dao.abstracts.Dao;
import com.solvd.hw2.models.Client;
import com.solvd.hw2.models.Investment;

public class InvestmentDao extends Dao
{
    private static final Logger LOGGER = LogManager.getLogger("Investment DAO");
    private static final String INVESTMENTS_TABLE = "investments";
    private static final String ID_COL = "investmentId";
    private static final String AMOUNT_COL = "amount";
    private static final String BANK_COL = "bank";
    private static final String INVESTOR_COL = "clientId";

    public List<Investment> select(ArrayList<String> fields, Investment criteriaVals, String operator)
    {
        try
        {
            ArrayList<Investment> ret = new ArrayList<Investment>();
            ResultSet results = getSelectResults(fields, criteriaVals, INVESTMENTS_TABLE, operator);

            while (results.next())
            {
                Integer newId = null;
                Double amount = null;
                String bank = null;
                Client client = new Client(null, null, null);

                for (int i = 1; i <= results.getMetaData().getColumnCount(); i++)
                {
                    if (results.getMetaData().getColumnLabel(i).equals(ID_COL))
                    {
                        newId = results.getInt(i);
                    }

                    else if (results.getMetaData().getColumnLabel(i).equals(AMOUNT_COL))
                    {
                        amount = results.getDouble(i);
                    }

                    else if (results.getMetaData().getColumnLabel(i).equals(BANK_COL))
                    {
                        bank = results.getString(i);
                    }

                    else if (results.getMetaData().getColumnLabel(i).equals(INVESTOR_COL))
                    {
                        client.setId(results.getInt(i));
                    }

                }

                ret.add(new Investment(newId, amount, bank, client));
            }
            
            CustomPool.releaseConn();
            return ret;
        }

        catch (SQLException sqle)
        {
            LOGGER.error(sqle.getMessage());
            return null;
        }
    }
}

package com.solvd.hw2.models;

import com.solvd.hw2.models.abstracts.Model;

public class Investment extends Model
{
    private static final String ID_COL = "investmentId";
    private static final String AMOUNT_COL = "amount";
    private static final String BANK_COL = "bank";

    private Integer id;
    private Double amount;
    private String bank;

    public Investment(Integer id, Double amount, String bank) 
    {
        this.id = id;
        this.amount = amount;
        this.bank = bank;
        populateFieldsAndVals();
    }


    protected void populateFieldsAndVals()
    {
        if (id != null)
        {
            vals.add(id);
            fields.add(ID_COL);
        }

        if (amount != null)
        {
            vals.add(amount);
            fields.add(AMOUNT_COL);
        }

        if (bank != null)
        {
            vals.add(bank);
            fields.add(BANK_COL);
        }
    }

    public Integer getId() 
    {
        return id;
    }

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Double getAmount() 
    {
        return amount;
    }

    public void setAmount(Double amount) 
    {
        this.amount = amount;
    }

    public String getBank() 
    {
        return bank;
    }

    public void setBank(String bank) 
    {
        this.bank = bank;
    }
}

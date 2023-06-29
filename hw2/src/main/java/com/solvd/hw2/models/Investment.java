package com.solvd.hw2.models;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.solvd.hw2.models.abstracts.Model;

@XmlRootElement (name="investment")
@XmlAccessorType (XmlAccessType.FIELD)
@JsonRootName ("investment")
public class Investment extends Model
{
    private static final String ID_COL = "investmentId";
    private static final String AMOUNT_COL = "amount";
    private static final String BANK_COL = "bank";
    private static final String INVESTOR_COL = "clientId";

    private Integer id;
    private Double amount;
    private String bank;

    @XmlElement (name="client")
    private Client investor;

    public Investment(){}
    
    public Investment(Integer id, Double amount, String bank, Client investor) 
    {
        this.id = id;
        this.amount = amount;
        this.bank = bank;
        this.investor = investor;
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

        if (investor != null)
        {
            vals.add(investor.getId());
            fields.add(INVESTOR_COL);
        }
    }

    @JsonGetter ("investmentId")
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

    public Client getClient() 
    {
        return investor;
    }

    public void setClient(Client investor) 
    {
        this.investor = investor;
    }

    public String toString()
    {
        return
        "Investment of " + bank + ":\n"
        + "Amount: " + amount + "\n"
        + "Investor:\n"
        + investor;
    }

    public ArrayList<String> getFields()
    {
        return this.fields;
    }

    public ArrayList<Object> getVals()
    {
        return this.vals;
    }
}

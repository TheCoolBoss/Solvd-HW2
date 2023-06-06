package com.solvd.hw2.models;

public class Investment 
{
    private int id;
    private double amount;
    private String bank;

    public Investment(int id, double amount, String bank) 
    {
        this.id = id;
        this.amount = amount;
        this.bank = bank;
    }

    public int getId() 
    {
        return id;
    }

    public void setId(int id) 
    {
        this.id = id;
    }

    public double getAmount() 
    {
        return amount;
    }

    public void setAmount(double amount) 
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

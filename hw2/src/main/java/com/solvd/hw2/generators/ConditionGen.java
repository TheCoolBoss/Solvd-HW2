package com.solvd.hw2.generators;

import java.util.ArrayList;

import com.solvd.hw2.lambda.Concaters;

public class ConditionGen 
{
    public static String makeBasicWhere(ArrayList<String> criteriaFields, String operator)
    {
        String ret = " where ";

        ret = ret.concat(Concaters.LIST_STRING_CONCAT.concatList(criteriaFields, operator + "? and "));
        ret = ret.substring(0, ret.length() - 4);

        return ret;
    }

    
}

package com.solvd.hw2.generators;

import java.util.ArrayList;

//For testing
public class QueryGen 
{
    public static String genInsert(ArrayList<String> fields, String table)
    {
        String ret = "insert into " + table + " (";

        for (int i = 1; i < fields.size(); i++)
        {
            ret = ret.concat(fields.get(i) + ", ");
        }

        ret = ret.substring(0, ret.length() - 2);
        ret = ret.concat(") values (");


        for (int i = 1; i < fields.size(); i++) 
        {
            ret = ret.concat("?, ");
        }

        ret = ret.substring(0, ret.length() - 2);
        ret = ret.concat(");");

        return ret;
    }

    public static String genUpdate(ArrayList<String> fields, String table)
    {
        String ret = "update " + table + " set ";

        for (int i = 1; i < fields.size(); i++)
        {
            ret = ret.concat(fields.get(i) + " = " + "?, ");
        }

        ret = ret.substring(0, ret.length() - 2);
        ret = ret.concat(" where");

        return ret;
    }

    public static String genDelete(String table)
    {
        String ret = "delete from " + table;

        return ret;
    }

    public static String genSelect(ArrayList<String> fields, String table)
    {
        String ret = "select ";

        //Currently defaults to everything if all fields are null, should probably change later
        if (fields.size() == 0)
        {
            ret = ret.concat("* ");
        }

        else
        {
            for (String string : fields) 
            {
                ret = ret.concat(string + ", ");
            }
            
            ret = ret.substring(0, ret.length() - 2);
        }

        ret = ret.concat(" from " + table);


        return ret;
    }
}

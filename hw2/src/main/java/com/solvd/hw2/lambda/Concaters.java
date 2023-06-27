package com.solvd.hw2.lambda;

import java.util.List;
import com.solvd.hw2.lambda.interfaces.IConcat;
import com.solvd.hw2.lambda.interfaces.IConcatList;

public class Concaters <T>
{
    public static final IConcat CONCATER = (String toAdd, int count) ->
    {
        String ret = "";
        for (int i = 0; i < count; i++)
        {
            ret = ret.concat(toAdd);
        }
        
        return ret;
    };

    public static final IConcatList<String> LIST_STRING_CONCAT = (List<String> list, String extraStuff) ->
    {
        String ret = "";

        for (String string : list) 
        {
            ret = ret.concat(string + extraStuff);    
        }
        
        return ret;
    };
}

package com.solvd.hw2.lambda.interfaces;

import java.util.List;

public interface IConcatList<T> 
{
    String concatList(List<T> list, String extraStuff);
}

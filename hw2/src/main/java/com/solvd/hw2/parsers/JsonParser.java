package com.solvd.hw2.parsers;

import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParser 
{
    private String path;
    private ObjectMapper mapper = new ObjectMapper();
    private Class<?> classToMake;


    public JsonParser(String path, Class<?> toMake) 
    {
        this.path = path;
        classToMake = toMake;
    }

    public Object parse() throws JsonMappingException, JsonProcessingException, IOException
    {
        return mapper.readValue(new File(path), classToMake); 
    }

    public void setPath (String newPath)
    {
        path = newPath;
    }
}

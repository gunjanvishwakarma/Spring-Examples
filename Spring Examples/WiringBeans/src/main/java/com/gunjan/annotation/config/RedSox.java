package com.gunjan.annotation.config;

import org.springframework.stereotype.Component;

@Component
public class RedSox implements Team
{
    private String name = "Boston Red Sox";
    @Override
    public String getName()
    {
        return name;
    }
    
    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("RedSox{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

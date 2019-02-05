package com.gunjan.java.config;

public class Cubs implements Team
{
    private String name = "Cubs";
    @Override
    public String getName()
    {
        return name;
    }
    
    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("Cubs{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

package com.gunjan.java.config;

import javax.sql.DataSource;

public class BaseballGame implements Game
{
    private String name = "Baseball Game";
    private Team homeTeam;
    private Team awayTeam;
    private DataSource dataSource;
    
    public BaseballGame(Team homeTeam, Team awayTeam)
    {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }
    
    public void setDataSource(DataSource dataSource)
    {
        this.dataSource = dataSource;
    }
    
    @Override
    public String getName()
    {
        return "Baseball Game";
    }
    
    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("BaseballGame{");
        sb.append("name='").append(name).append('\'');
        sb.append(", homeTeam=").append(homeTeam);
        sb.append(", awayTeam=").append(awayTeam);
        sb.append(", dataSource=").append(dataSource);
        sb.append('}');
        return sb.toString();
    }
}

package com.gunjan.annotation.config;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BaseballGame implements Game
{
    private String name = "Baseball Game";
    
    // auto wire by bean type
    @Autowired
    @Qualifier("redSox")
    private Team homeTeam;
    
    // auto wire by bean type
    @Autowired
    @Qualifier("cubs")
    private Team awayTeam;
    
    @Autowired
    private DataSource dataSource;
    
    // auto wire by bean name
    @Resource()
    private Team redSox;
    
    // auto wire by bean name
    @Resource
    private Team cubs;
    
    
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
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public Team getHomeTeam()
    {
        return homeTeam;
    }
    
    public void setHomeTeam(Team homeTeam)
    {
        this.homeTeam = homeTeam;
    }
    
    public Team getAwayTeam()
    {
        return awayTeam;
    }
    
    public void setAwayTeam(Team awayTeam)
    {
        this.awayTeam = awayTeam;
    }
    
    @Override
    public void playGame()
    {
        System.out.println("Playing game " + homeTeam + " vs " + awayTeam);
    }
    
    public DataSource getDataSource()
    {
        return dataSource;
    }
    
    public Team getRedSox()
    {
        return redSox;
    }
    
    public void setRedSox(Team redSox)
    {
        this.redSox = redSox;
    }
    
    public Team getCubs()
    {
        return cubs;
    }
    
    public void setCubs(Team cubs)
    {
        this.cubs = cubs;
    }
    
}

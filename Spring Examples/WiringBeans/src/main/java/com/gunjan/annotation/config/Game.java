package com.gunjan.annotation.config;

import javax.sql.DataSource;

public interface Game
{
    String getName();
    
    void setName(String name);
    
    Team getHomeTeam();
    
    void setHomeTeam(Team homeTeam);
    
    Team getAwayTeam();
    
    void setAwayTeam(Team awayTeam);
    
    void playGame();
}

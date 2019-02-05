package com.gunjan.java.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(InfrastructureConfig.class)
public class AppConfig
{
    @Autowired
    private DataSource dataSource;
    
    @Bean
    public Game game1(DataSource dataSource)
    {
        BaseballGame baseballGame = new BaseballGame(redSox(), cubs());
        baseballGame.setDataSource(dataSource);
        return baseballGame;
    }
    
    @Bean
    public Game game()
    {
        BaseballGame baseballGame = new BaseballGame(redSox(), cubs());
        baseballGame.setDataSource(dataSource);
        return baseballGame;
    }
    
    @Bean
    public Team redSox()
    {
        return new RedSox();
    }
    
    @Bean
    public Team cubs()
    {
        return new Cubs();
    }
}

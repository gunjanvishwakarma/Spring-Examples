package com.gunjan.annotation.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.gunjan.annotation.config")
@EnableAspectJAutoProxy
public class AppConfig
{
    @Autowired
    private DataSource dataSource;
    
    @Bean
    public Game game()
    {
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.setDataSource(dataSource);
        return baseballGame;
    }
}

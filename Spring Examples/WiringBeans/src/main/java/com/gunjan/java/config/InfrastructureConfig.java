package com.gunjan.java.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mchange.v2.c3p0.DriverManagerDataSource;

@Configuration
public class InfrastructureConfig
{
    @Bean
    public DataSource dataSource(){
        return new DriverManagerDataSource();
    }
}

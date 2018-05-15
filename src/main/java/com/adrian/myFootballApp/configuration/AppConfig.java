package com.adrian.myFootballApp.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;


public class AppConfig {

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource")
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }

/*
    @Bean
    @ConfigurationProperties("ps.datasource")
    public DataSource psDataSource(){
        return DataSourceBuilder.create().build();
    }
*/
}

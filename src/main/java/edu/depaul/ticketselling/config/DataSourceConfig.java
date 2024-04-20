package edu.depaul.ticketselling.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;


@Configuration
public class DataSourceConfig {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.h2")
    @ConditionalOnProperty(name = "spring.profiles.active", havingValue = "h2")
    public HikariDataSource h2() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean
    @Profile("postgres")
    @ConfigurationProperties(prefix = "spring.datasource.postgres")
    @ConditionalOnProperty(name = "spring.profiles.active", havingValue = "postgres")
    public HikariDataSource postgres() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

}

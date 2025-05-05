package com.paramonga.ssff.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;


@Configuration
@EnableJpaRepositories(basePackages = "com.paramonga.ssff.repositories.dev",
        entityManagerFactoryRef = "devDatabaseEntityManager",
        transactionManagerRef = "devDatabaseTransactionManager")
public class DevDBConfig {
    @Autowired
    private Environment env;

    public DevDBConfig() {
        super();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean devDatabaseEntityManager() {
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(devDataSource());
        em.setPackagesToScan("com.paramonga.ssff.entities");

        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        final HashMap<String, Object> properties = new HashMap<String, Object>();
        properties.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect"));
        properties.put("hibernate.show_sql", env.getProperty("spring.jpa.show-sql"));
        properties.put("hibernate.temp.use_jdbc_metadata_defaults", env.getProperty("spring.jpa.properties.hibernate.temp.use_jdbc_metadata_defaults"));
        em.setJpaPropertyMap(properties);

        return em;
    }

    @Bean
    public DataSource devDataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(env.getProperty("spring.dev.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.dev.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.dev.datasource.password"));
        dataSource.setDriverClassName(env.getProperty("spring.dev.datasource.driver-class-name"));

        return dataSource;
    }

    @Bean
    public PlatformTransactionManager devDatabaseTransactionManager() {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(devDatabaseEntityManager().getObject());
        return transactionManager;
    }

}
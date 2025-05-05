package com.paramonga.ssff.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
@EnableJpaRepositories(basePackages = "com.paramonga.ssff.repositories.prd",
        entityManagerFactoryRef = "prdDatabaseEntityManager",
        transactionManagerRef = "prdDatabaseTransactionManager")
public class PrdDBConfig {
    @Autowired
    private Environment env;

    public PrdDBConfig() {
        super();
    }

    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean prdDatabaseEntityManager() {
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(prdDataSource());
        em.setPackagesToScan("com.paramonga.ssff.entities");

        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        final HashMap<String, Object> properties = new HashMap<String, Object>();
        properties.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect"));
        properties.put("hibernate.show_sql", env.getProperty("spring.jpa.show-sql"));
        em.setJpaPropertyMap(properties);

        return em;
    }

    @Primary
    @Bean
    public DataSource prdDataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(env.getProperty("spring.prd.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.prd.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.prd.datasource.password"));
        dataSource.setDriverClassName(env.getProperty("spring.prd.datasource.driver-class-name"));

        return dataSource;
    }

    @Primary
    @Bean
    public PlatformTransactionManager prdDatabaseTransactionManager() {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(prdDatabaseEntityManager().getObject());
        return transactionManager;
    }

}
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
@EnableJpaRepositories(basePackages = "com.paramonga.ssff.repositories.ing",
        entityManagerFactoryRef = "ingDatabaseEntityManager",
        transactionManagerRef = "ingDatabaseTransactionManager")
public class IngDBConfig {
    @Autowired
    private Environment env;

    public IngDBConfig() {
        super();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean ingDatabaseEntityManager() {
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(ingDataSource());
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
    public DataSource ingDataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(env.getProperty("spring.ing.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.ing.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.ing.datasource.password"));
        dataSource.setDriverClassName(env.getProperty("spring.ing.datasource.driver-class-name"));

        return dataSource;
    }

    @Bean
    public PlatformTransactionManager ingDatabaseTransactionManager() {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(ingDatabaseEntityManager().getObject());
        return transactionManager;
    }

}
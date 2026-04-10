package com.paramonga.ssff.config;

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
import java.util.Map;
import java.util.Objects;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.paramonga.ssff.repositories",
        entityManagerFactoryRef = "routingEntityManager",
        transactionManagerRef = "routingTransactionManager"
)
public class DataSourceConfig {

    private final Environment env;

    public DataSourceConfig(Environment env) {
        this.env = env;
    }

    // Beans de DataSources

    @Bean
    public DataSource devDataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setUrl(env.getProperty("spring.dev.datasource.url"));
        ds.setUsername(env.getProperty("spring.dev.datasource.username"));
        ds.setPassword(env.getProperty("spring.dev.datasource.password"));
        ds.setDriverClassName(Objects.requireNonNull(env.getProperty("spring.dev.datasource.driver-class-name")));
        return ds;
    }

    @Bean
    public DataSource prdDataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setUrl(env.getProperty("spring.prd.datasource.url"));
        ds.setUsername(env.getProperty("spring.prd.datasource.username"));
        ds.setPassword(env.getProperty("spring.prd.datasource.password"));
        ds.setDriverClassName(Objects.requireNonNull(env.getProperty("spring.prd.datasource.driver-class-name")));
        return ds;
    }

    // Beans de Routing y JPA

    @Bean
    @Primary
    public DataSource routingDataSource() {
        EnvironmentRoutingDataSource router = new EnvironmentRoutingDataSource();
        Map<Object,Object> targets = new HashMap<>();
        targets.put("dev", devDataSource());
        targets.put("prd", prdDataSource());
        router.setTargetDataSources(targets);
        router.setDefaultTargetDataSource(devDataSource());  // fallback
        router.setLenientFallback(false); // generar excepcion en entornos invalidos
        return router;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean routingEntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(routingDataSource());
        em.setPackagesToScan("com.paramonga.ssff.entities");
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(adapter);
        em.getJpaPropertyMap().put(
                "hibernate.dialect",
                env.getProperty("spring.jpa.properties.hibernate.dialect")
        );
        return em;
    }

    @Bean
    public PlatformTransactionManager routingTransactionManager(
            LocalContainerEntityManagerFactoryBean routingEntityManager) {
        return new JpaTransactionManager(Objects.requireNonNull(routingEntityManager.getObject()));
    }
}

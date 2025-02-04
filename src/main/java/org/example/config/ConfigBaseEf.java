package org.example.config;

import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.hibernate.jpa.HibernatePersistenceProvider;
import jakarta.persistence.EntityManagerFactory;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Configuration
@EnableTransactionManagement
@ConfigurationProperties(prefix = "datasource.ucp")
@EnableJpaRepositories(
        entityManagerFactoryRef = "empresaEntityManagerFactory",
        transactionManagerRef = "empresaTransactionManager",
        basePackages = {"org.example.repositories.empresa"}
)
public class ConfigBaseEf {

    @Autowired
    private org.springframework.core.env.Environment env;

    @Bean(name = "empresaDatasource")
    public DataSource getDataSource() {
        log.info("Inicia pool de empresa");
        PoolDataSource empresa = null;

        try {
            empresa = PoolDataSourceFactory.getPoolDataSource();
            empresa.setConnectionFactoryClassName(env.getProperty("spring.datasource.driver-class-name"));
            empresa.setURL(env.getProperty("spring.datasource.url"));
            empresa.setUser(env.getProperty("spring.datasource.username"));
            empresa.setPassword(env.getProperty("spring.datasource.password"));
            empresa.setMinPoolSize(1);
            empresa.setInitialPoolSize(5);
            empresa.setMaxPoolSize(10);
            empresa.setValidateConnectionOnBorrow(true);
            empresa.setConnectionPoolName("empresa");
            empresa.setConnectionWaitTimeout(40);
            empresa.setSQLForValidateConnection("SELECT 1");
        } catch (Exception e) {
            log.error("Error BD EF: " + e.getMessage(), e);
        }
        return empresa;
    }

    @Primary
    @Bean(name = "empresaEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(getDataSource());
        em.setPackagesToScan("org.example.entities");

        // Establecer explícitamente el proveedor de JPA
        em.setPersistenceProvider(new HibernatePersistenceProvider());

        Map<String, Object> properties = new HashMap<>();
        properties.put("jakarta.persistence.query.timeout", 6000);
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));
        properties.put("hibernate.show_sql", env.getProperty("spring.jpa.show-sql"));
        properties.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect"));

        em.setJpaPropertyMap(properties);
        return em;


}

    @Primary
    @Bean(name = "empresaTransactionManager")
    public JpaTransactionManager transactionManager(
            @Qualifier("empresaEntityManagerFactory") @NotNull EntityManagerFactory empresaEntityManagerFactory) {
        return new JpaTransactionManager(empresaEntityManagerFactory);
    }
}

package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;
/**
 * @Author perth 〖bfcy_china@163.com〗
 * @Date 2019/3/14 22:56
 */
@Configuration
@EnableJpaRepositories(
        basePackages = "com.hjf.boot.demo.database.jpa",
        entityManagerFactoryRef = "ordersEntityManagerFactory",
        transactionManagerRef = "ordersTransactionManager"
)
public class OrdersDBConfig {

    @Autowired
    private Environment env;

    @Bean
    @ConfigurationProperties(prefix="datasource.orders")
    public DataSourceProperties ordersDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource ordersDataSource() {
        DataSourceProperties primaryDataSourceProperties = ordersDataSourceProperties();
        return DataSourceBuilder.create()
                .driverClassName(primaryDataSourceProperties.getDriverClassName())
                .url(primaryDataSourceProperties.getUrl())
                .username(primaryDataSourceProperties.getUsername())
                .password(primaryDataSourceProperties.getPassword())
                .build();
    }

    @Bean
    public PlatformTransactionManager ordersTransactionManager() {
        EntityManagerFactory factory = ordersEntityManagerFactory().getObject();
        return new JpaTransactionManager(factory);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean ordersEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factory = new
                LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(ordersDataSource());
        factory.setPackagesToScan("com.hjf.boot.demo.database.jpa");
        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.hbm2ddl.auto",env.getProperty("hibernate.hbm2ddl.auto"));
        jpaProperties.put("hibernate.show-sql", env.getProperty("hibernate.show-sql"));
        factory.setJpaProperties(jpaProperties);
        return factory;
    }

    @Bean
    public DataSourceInitializer ordersDataSourceInitializer() {
        DataSourceInitializer dsInitializer = new DataSourceInitializer();
        dsInitializer.setDataSource(ordersDataSource());
        ResourceDatabasePopulator dbPopulator = new ResourceDatabasePopulator();
        dbPopulator.addScript(new ClassPathResource("orders-data.sql"));
        dsInitializer.setDatabasePopulator(dbPopulator);
        dsInitializer.setEnabled(env.getProperty("datasource.orders.initialize",
                Boolean.class, false));
        return dsInitializer;
    }
}
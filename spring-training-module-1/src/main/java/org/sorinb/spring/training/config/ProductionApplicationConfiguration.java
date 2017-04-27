package org.sorinb.spring.training.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

import javax.sql.DataSource;

/**
 * Created by sorinello on 3/31/17.
 */
@Configuration
@Profile({"default","production"})
@ComponentScan("org.sorinb.spring.training.repository")
public class ProductionApplicationConfiguration {

    @Autowired
    private Environment environment;

    @Bean
    public HibernateJpaSessionFactoryBean sessionFactory() { return new HibernateJpaSessionFactoryBean(); }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("spring.datasource.driver-class-name"));
        dataSource.setUrl(environment.getRequiredProperty("spring.datasource.url"));
        dataSource.setUsername(environment.getRequiredProperty("spring.datasource.username"));
        dataSource.setPassword(environment.getRequiredProperty("spring.datasource.password"));

        System.out.println("##### dataSource() has been run");
        return dataSource;
    }

}

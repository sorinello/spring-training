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
 * Created by sorinello on 4/6/17.
 */
@Configuration
@Profile("demo")
@ComponentScan("org.sorinb.spring.training.repository")
public class DemoApplicationConfiguration {

    @Autowired
    private Environment environment;

    @Bean
    public HibernateJpaSessionFactoryBean sessionFactory() {
        return new HibernateJpaSessionFactoryBean();
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("spring.datasource.driver-class-name_test"));
        dataSource.setUrl(environment.getRequiredProperty("spring.datasource.url_test"));
        dataSource.setUsername(environment.getRequiredProperty("spring.datasource.username_test"));
        dataSource.setPassword(environment.getRequiredProperty("spring.datasource.password_test"));

        System.out.println("##### dataSource() TEST has been run");
        return dataSource;
    }

}

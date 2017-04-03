package org.sorinb.spring.training.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.internal.SessionFactoryBuilderImpl;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

/**
 * Created by sorinello on 3/31/17.
 */
@Configuration
@ComponentScan("org.sorinb.spring.training.repository")
//@PropertySource(value = { "classpath:application.properties" })
public class ApplicationConfiguration {

    @Autowired
    private Environment environment;

    @PostConstruct
    public String beanTExample(){

        System.out.println("##### beanTExample has been run");
        return "Sorin Bean Test";
    }

    @Bean
    public HibernateJpaSessionFactoryBean sessionFactory() {
        return new HibernateJpaSessionFactoryBean();
    }


//    @Bean
//    public FactoryBean<SessionFactory> sessionFactory() {
//        return new HibernateJpaSessionFactoryBean();
//    }

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


//    @Bean
//    @Autowired
//    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
//        HibernateTransactionManager txManager = new HibernateTransactionManager();
//        txManager.setSessionFactory(sessionFactory);
//        System.out.println("##### transactionManager has been run");
//        return txManager;
//    }
}

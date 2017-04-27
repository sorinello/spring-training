package org.sorinb.spring.training;

import org.sorinb.spring.training.aop.TimeLoggingAspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAutoConfiguration
@EnableTransactionManagement
public class SpringTrainingModule1Application {

	public static void main(String[] args) { SpringApplication.run(SpringTrainingModule1Application.class, args); }


}

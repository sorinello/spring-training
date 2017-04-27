package org.sorinb.spring.training.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * Created by sorinello on 4/5/17.
 */

@Configuration
public class ApplicationConfiguration {


    @Bean(name="operatingSystemService")
    @Conditional(WindowsCondition.class)
    public String windowsService(){
        return "You are running on Windows Operating System, using specific services";

    }

    @Bean(name="operatingSystemService")
    @Conditional(LinuxCondition.class)
    public String linuxService(){
        return "You are running on Linux Operating System, using specific services";

    }

}

package org.sorinb.spring.training;

import org.sorinb.spring.training.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@SpringBootApplication
public class SpringTrainingModule2Application {

    public static void main(String[] args) {
        Map<String, String> env = System.getenv();
        for (String envName : env.keySet()) {
            System.out.format("%s=%s%n",
                    envName,
                    env.get(envName));
        }


        System.out.println("Sorinello " + System.getenv("PATH"));

        System.out.println("Sorinello keyset " + System.getProperty("os.name"));
        System.out.println("Sorinello keyset " + System.getProperty("os.arch"));
        System.out.println("Sorinello keyset " + System.getProperty("os.version"));
        SpringApplication.run(SpringTrainingModule2Application.class, args);
    }
}

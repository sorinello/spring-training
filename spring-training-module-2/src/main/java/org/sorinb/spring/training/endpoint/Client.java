package org.sorinb.spring.training.endpoint;

import org.sorinb.spring.training.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * Created by sorinello on 4/3/17.
 */
@RestController
public class Client {

    @Autowired
    private String operatingSystemService;

    @RequestMapping(name = "/")
    public User postUser(HttpServletRequest httpRequest) {

        Enumeration<String> headerNames = httpRequest.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String header = headerNames.nextElement();
            System.out.println(header + " : " + httpRequest.getHeader(header));
        }

        RestTemplate restTemplate = new RestTemplate();

        User.UserBuilder userBuilder = new User.UserBuilder();
        User user = userBuilder
                .username("sorinello")
                .password("passwd")
                .firstName("John")
                .lastName("Doe")
                .email("a@b.com")
                .telephone("7244")
                .buildUser();

        System.out.println("Sending request with user: " + user.toString());
        HttpEntity<User> request = new HttpEntity<>(user);
        System.out.println("Request body: " + request.getBody());
        user = restTemplate.postForObject("http://localhost:8080/add", user, User.class);
        System.out.println("Returned user: " + user.toString());
        return user;
    }
}
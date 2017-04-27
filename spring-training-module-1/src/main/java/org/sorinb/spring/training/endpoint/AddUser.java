package org.sorinb.spring.training.endpoint;

import org.sorinb.spring.training.model.User;
import org.sorinb.spring.training.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * Created by sorinello on 4/3/17.
 */

@RestController
public class AddUser {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private ApplicationContext applicationContext;

    @Logable
    @RequestMapping(value="/add", method= RequestMethod.POST)
    public ResponseEntity<User> login(@RequestBody User user, HttpServletRequest httpRequest) {

        Enumeration<String> headerNames =  httpRequest.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String header = headerNames.nextElement();
            System.out.println(header + " : " + httpRequest.getHeader(header));
        }

        if (user !=null) {
            user.setRegistrationDate(new Timestamp(System.currentTimeMillis()));
            userRepository.save(user);
        }

        System.out.println(Arrays.asList(applicationContext.getBeanDefinitionNames()));
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}


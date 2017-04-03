package org.sorinb.spring.training.endpoint;

import org.sorinb.spring.training.model.User;
import org.sorinb.spring.training.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

/**
 * Created by sorinello on 4/3/17.
 */

@RestController
public class AddUser {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value="/add", method= RequestMethod.POST)
    public ResponseEntity<User> login(@RequestBody User user) {

        if (user !=null) {
            user.setRegistrationDate(new Timestamp(System.currentTimeMillis()));
            userRepository.save(user);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}


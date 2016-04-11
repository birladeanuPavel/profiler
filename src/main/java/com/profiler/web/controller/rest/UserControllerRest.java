package com.profiler.web.controller.rest;

import com.profiler.dal.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pavel
 */
@RestController
public class UserControllerRest {
    
    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser() {
        User user = new User();
        user.setFirstName("test");
        return new ResponseEntity<>(user, HttpStatus.OK);
        
    }
}

package com.profiler.web.controller.rest;

import com.profiler.dal.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by pavel on 4/24/16.
 */
@RestController
public class UserRestController extends MainRestController{

    @RequestMapping(value = "getUser/{id}",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User user = new User();
        user.setFirstName("test");
        return new ResponseEntity<>(user, HttpStatus.OK);

    }

}

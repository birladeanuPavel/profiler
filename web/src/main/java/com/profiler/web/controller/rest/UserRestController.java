package com.profiler.web.controller.rest;

import com.profiler.service.bean.UserService;
import com.profiler.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by pavel on 4/24/16.
 */
@RestController
public class UserRestController extends MainRestController{

    @Autowired
    private UserService userService;

    @RequestMapping(value = "getUser/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
        UserDto userDto = userService.getById(id);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @RequestMapping(value = "getAllUsers", method = RequestMethod.GET)
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.getAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "saveUser", method = RequestMethod.POST)
    public ResponseEntity<Void> saveUser(@RequestBody UserDto userDto) {
        userService.save(userDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "updateUser", method = RequestMethod.PUT)
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto) {
        userDto = userService.update(userDto);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

}

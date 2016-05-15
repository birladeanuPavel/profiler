package com.profiler.web.controller.rest;

import com.profiler.service.bean.UserService;
import com.profiler.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by pavel on 4/24/16.
 */
@RestController
public class UserRestController extends MainRestController{

    @Autowired
    private UserService userService;

    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
        UserDto userDto = userService.getById(id);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.getAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "user", method = RequestMethod.POST)
    public ResponseEntity<Void> saveUser(@Valid @RequestBody UserDto userDto) {
        userService.save(userDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "user", method = RequestMethod.PUT)
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto) {
        userDto = userService.update(userDto);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @RequestMapping(value = "user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

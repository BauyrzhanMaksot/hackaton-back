package com.example.epam1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/bake/register")
    public HttpStatus register(@RequestBody UserDto userDto) {
        userService.register(userDto);
        return HttpStatus.OK;
    }

    @GetMapping("/getUser")
    public User getUser(){
        return userService.getUser();
    }

    @PostMapping("/updateUser")
    public HttpStatus updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return HttpStatus.OK;
    }
}

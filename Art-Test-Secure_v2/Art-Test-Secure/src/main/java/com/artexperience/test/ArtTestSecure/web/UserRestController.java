package com.artexperience.test.ArtTestSecure.web;

import com.artexperience.test.ArtTestSecure.model.User;
import com.artexperience.test.ArtTestSecure.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserRestController {


    private final UserServices userServices;

    @Autowired
    public UserRestController(final UserServices userServices){
        this.userServices = userServices;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> getUserById(){
        return userServices.findAllUsers();
    }

    @GetMapping("/id/{id_user}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<User> getUserById(@PathVariable("id_user") final Long iduser) {
        return userServices.findUsersById(iduser);
    }

    @PostMapping("/createUser")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody final User user){
        return userServices.createClientUser(user);
    }

    @DeleteMapping("/delete/{id_user}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUserById(@PathVariable("id_user") final Long user){
        userServices.deleteUserById(user);
    }

}

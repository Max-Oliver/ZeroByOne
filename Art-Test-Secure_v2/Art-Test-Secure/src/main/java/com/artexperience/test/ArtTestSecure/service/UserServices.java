package com.artexperience.test.ArtTestSecure.service;

import com.artexperience.test.ArtTestSecure.data.UserRepository;
import com.artexperience.test.ArtTestSecure.model.Client;
import com.artexperience.test.ArtTestSecure.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class UserServices {


    @Qualifier("userServices")
    private final UserRepository repository;

    @Autowired
    public UserServices(final UserRepository repository){
        this.repository = repository;
    }

    public List<User> findAllUsers(){
        return repository.findAll();
    }

    public Optional<User> findUsersById(final Long id){
        return repository.findById(id);
    }

    public User createClientUser(final User bodyUser){
        User user = new User();
        Client client = new Client();
        user.setUsername(bodyUser.getUsername());
        user.setPassword(bodyUser.getPassword());
        user.setEmail(bodyUser.getEmail());
        user.setCel(bodyUser.getCel());
        user.setFullname(bodyUser.getFullname());
        user.setCreateOn(Instant.now());
        user.setStatus(true);
        user.setDeleteOn(null);
        user.setClient(client);
        return repository.save(user);
    }

    public void deleteUserById(Long idUser){
        Optional<User> user = repository.findById(idUser);
        user.get().setStatus(false);
        repository.save(user.get());
    }

}

package com.art.experience.dev.service;

import com.art.experience.dev.data.UserRepository;
import com.art.experience.dev.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    private final UserRepository repository;

    @Autowired
    public UserServices( final UserRepository repository) {
        this.repository = repository;
    }

    public List<User> findAllUsers() {
        return repository.findAll();
    }

    public Optional<User> findUsersById(final Long id) {
        return repository.findById(id);
    }

    public User createClientUser(final User bodyUser) {
        User user = new User();
        user.setUsername(bodyUser.getUsername());
        user.setPassword(bodyUser.getPassword());
        user.setEmail(bodyUser.getEmail());
        user.setCel(bodyUser.getCel());
        user.setFullName(bodyUser.getFullName());
        user.setCreateOn(Instant.now());
        user.setStatus(true);
        user.setDeleteOn(null);
        user.setClientId(bodyUser.getClientId());
        return repository.save(user);
    }

    public void deleteUserById(Long idUser) {
        Optional<User> user = repository.findById(idUser);
        user.get().setStatus(false);
        repository.save(user.get());
    }

}

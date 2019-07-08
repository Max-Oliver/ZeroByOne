package com.artexperience.test.ArtTestSecure.data;

import com.artexperience.test.ArtTestSecure.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends JpaRepository<User,Long> {

}

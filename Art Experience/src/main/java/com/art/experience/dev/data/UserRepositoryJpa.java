package com.artexperience.test.ArtTestSecure.data;

import com.artexperience.test.ArtTestSecure.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Component
public interface UserRepositoryJpa extends JpaRepository<Usuarios,Long> {
    //find all()
    //findByid() already includes
    List<Usuarios> findAll();
    Optional<Usuarios> findById(final Long id);
}

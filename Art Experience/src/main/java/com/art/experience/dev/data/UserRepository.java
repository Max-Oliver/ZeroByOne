package com.art.experience.dev.data;

import com.art.experience.dev.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Usuarios,Long> {
    //find all()
    //findByid() already includes
}

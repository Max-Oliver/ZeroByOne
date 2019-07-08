package com.artexperience.test.ArtTestSecure.data;

import com.artexperience.test.ArtTestSecure.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepositoy extends JpaRepository<Client,Long> {
}

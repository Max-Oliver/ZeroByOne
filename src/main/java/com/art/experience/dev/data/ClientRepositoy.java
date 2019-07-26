package com.art.experience.dev.data;

import com.art.experience.dev.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ClientRepositoy extends JpaRepository<Client, Long> {
}

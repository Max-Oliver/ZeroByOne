package com.art.experience.dev.data;

import com.art.experience.dev.model.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ReservesRepository extends JpaRepository<Reserve, Long> {
}

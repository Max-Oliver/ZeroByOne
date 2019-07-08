package com.artexperience.test.ArtTestSecure.data;

import com.artexperience.test.ArtTestSecure.model.Barber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarberRepository extends JpaRepository<Barber, Long> {
}

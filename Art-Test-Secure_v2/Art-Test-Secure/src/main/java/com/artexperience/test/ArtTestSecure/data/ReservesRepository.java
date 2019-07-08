package com.artexperience.test.ArtTestSecure.data;

import com.artexperience.test.ArtTestSecure.model.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservesRepository extends JpaRepository<Reserve, Long> {
}

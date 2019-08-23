package com.art.experience.dev.service;

import com.art.experience.dev.data.BarberRepository;
import com.art.experience.dev.data.UserRepository;
import com.art.experience.dev.model.Barber;
import com.art.experience.dev.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.management.BadAttributeValueExpException;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BarberService {

    private static final Logger LOGGER = LogManager.getLogger(BarberService.class);
    private final BarberRepository barberRepository;
    private final UserRepository userRepository;

    @Autowired
    private BarberService(final BarberRepository barberRepository,
                          final UserRepository userRepository) {
        this.barberRepository = barberRepository;
        this.userRepository = userRepository;
    }


    public Barber findByID(final Long barberId) {
        Barber barber = barberRepository.findById(barberId).orElse(null);
         if (!Objects.nonNull(barber)) {
            LOGGER.error("Barber ID Not found. " + barberId);
            throw new ResourceNotFoundException("Barber ID Not found. " + barberId);
        }
        return barber;
    }

    public List<Barber> getAllBarbers() {
        List<Barber> barbers = barberRepository.findAll();
        if (barbers.isEmpty()) {
            LOGGER.error("Data Not found in the database");
            throw new ResourceNotFoundException("No data of Barbers in the Database.");
        }
        return barbers.stream()
                .filter(barber -> ((Barber) barber).getBarberId().equals(barber.getBarberId()))
                .collect(Collectors.toList());
    }

    public Barber create(final Barber barb) {
        Barber newBarber = new Barber();
        try {
            newBarber.setName(barb.getName());
            newBarber.setCel(barb.getCel());
            newBarber.setEmail(barb.getEmail());
            newBarber.setAmountCuts(0L);
            newBarber.setRateOfBarber(barb.getRateOfBarber());
            newBarber.setAmountOfreservesByDay("0");
            newBarber.setClientsBarber(barb.getClientsBarber());
            newBarber.setStartDate(Instant.now());
            newBarber.setPassword(barb.getPassword());
            newBarber.setUsername(barb.getUsername());
            User user = createUser(barb);
            newBarber.setUserId(user.getUserId());
            return barberRepository.save(newBarber);
        } catch (Exception e) {
            LOGGER.error("Something failed on the creation of Barber. " + e.getMessage());
            throw new IllegalArgumentException("Something failed on the creation of Barber. " + e.getMessage());
        }
    }

    public Barber update(final Barber barb){
        Optional<Barber> barber = barberRepository.findById(barb.getBarberId());
        Barber updateBarb = new Barber();
        if(!barber.isPresent()){
            LOGGER.error("Barber not found with the ID " + barb.getBarberId());
            throw new ResourceNotFoundException("Barber not found with the ID " + barb.getBarberId());
        }
        updateBarb.setBarberId(barber.get().getBarberId());
        updateBarb.setUserId(barber.get().getUserId());
        updateBarb.setUsername(barb.getUsername());
        updateBarb.setPassword(barb.getPassword());
        updateBarb.setName(barb.getName());
        updateBarb.setCel(barb.getCel());
        updateBarb.setEmail(barb.getEmail());
        updateBarb.setRateOfBarber(barb.getRateOfBarber());
        updateBarb.setClientsBarber(barb.getClientsBarber());
        updateBarb.setAmountOfreservesByDay(barb.getAmountOfreservesByDay());
        updateBarb.setAmountCuts(barb.getAmountCuts());
        updateBarb.setStartDate(barber.get().getStartDate());
        if(Objects.nonNull(barb.getEndDate())){
            updateBarb.setEndDate(Instant.now());
        }
        updateUser(updateBarb);
        return barberRepository.save(updateBarb);
    }

    public void delete(final Long barberID){
        Optional<Barber> barber = barberRepository.findById(barberID);
        if (!barber.isPresent()){
            LOGGER.error("Barber not Found by this ID" + barberID);
            throw new ResourceNotFoundException("Barber not Found by this ID" + barberID);
        }else{
            barberRepository.delete(barber.get());
        }
    }

    private void updateUser(final Barber updateBarb) {
        User user = userRepository.findById(updateBarb.getUserId()).orElse(null);
        if(!Objects.nonNull(user)){
            LOGGER.error("User not Found");
            throw new ResourceNotFoundException("User not Found with this ID " + updateBarb.getUserId());
        }
        user.setUsername(updateBarb.getUsername());
        user.setPassword(updateBarb.getPassword());
        user.setEmail(updateBarb.getEmail());
        user.setCel(updateBarb.getCel());
        user.setFullName(updateBarb.getName());
        user.setCreateOn(updateBarb.getStartDate());
        if(Objects.nonNull(updateBarb.getEndDate())){
            user.setDeleteOn(Instant.now());
        }
        userRepository.save(user);
    }

    private User createUser(final Barber barb) {
        User user = new User();
        try {
            user.setUsername(barb.getUsername());
            user.setPassword(barb.getPassword());
            user.setBarberId(barb.getBarberId());
            user.setStatus(true);
            user.setFullName(barb.getName());
            user.setCel(barb.getCel());
            user.setCreateOn(Instant.now());
            user.setClientId(null);
            user.setEmail(barb.getEmail());
            return userRepository.save(user);
        } catch (Exception e) {
            LOGGER.error("Error creating the user. " + e.getMessage());
            throw new IllegalArgumentException("Error creating the user. " + e.getMessage());
        }
    }

}

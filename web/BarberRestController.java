package com.art.experience.dev.web;

import com.art.experience.dev.model.Barber;
import com.art.experience.dev.service.BarberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/barber")
public class BarberRestController {

    private BarberService barberService;

    @Autowired
    public BarberRestController(final BarberService barberService) {
        this.barberService = barberService;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Barber> getBarbers() {
        return barberService.getAllBarbers();
    }

    @GetMapping("/id/{id_barber}")
    @ResponseStatus(HttpStatus.OK)
    public Barber getById(@PathVariable("id_barber") final Long idBarber) {
        return barberService.findByID(idBarber);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Barber create(@RequestBody final Barber barber) {
        return barberService.create(barber);
    }


    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Barber update(@RequestBody final Barber barber) {
        return barberService.update(barber);
    }

    @DeleteMapping("/delete/{id_user}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable("id_user") final Long user) {
        barberService.delete(user);
    }

}

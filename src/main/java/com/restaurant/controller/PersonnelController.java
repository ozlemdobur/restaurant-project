package com.restaurant.controller;

import com.restaurant.model.Personnel;
import com.restaurant.service.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api")
public class PersonnelController {

    private PersonnelService personnelService;

    public PersonnelController() {
    }

    @Autowired
    public PersonnelController(PersonnelService personnelService) {
        this.personnelService = personnelService;
    }

    @GetMapping(value = "/personnel", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Personnel>> getAllPersonnels() {
        Iterable<Personnel> personnels = personnelService.findAll();
        return ResponseEntity.ok(personnels);
    }

    @PostMapping(value = "/personnel", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Personnel> createPersonnel(@RequestBody Personnel personnel) throws Exception {
        Personnel personnelCreated = personnelService.createPersonnel(personnel);
        if (personnelCreated == null) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(personnelCreated);
        }
    }

    // http://9090/api/customer/3
    @DeleteMapping(value = "/personnel/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    public void deletePersonnelById(@PathVariable Long id) {
        personnelService.deletePersonnel(id);
    }
}

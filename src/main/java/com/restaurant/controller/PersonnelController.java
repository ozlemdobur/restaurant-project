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
    public ResponseEntity<Iterable<Personnel>> getAllPersonnels(){
        Iterable<Personnel> personnels = personnelService.findAll();
        return ResponseEntity.ok(personnels);
    }

    @PutMapping(value="/personnel{}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Personnel> updatePersonnel(@RequestBody Personnel personnel ){
        Personnel updatedPersonnel = personnelService.updatePersonnel(personnel);
        return ResponseEntity.ok(updatedPersonnel);
    }

    @DeleteMapping(value="/personnel")
    public void deletePersonnel(@RequestBody Long Id){
        personnelService.deletePersonnel(Id);
    }

    @PostMapping(value = "/personnel", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Personnel> createPersonnel(@RequestBody Personnel personnel){

        Personnel personnelCreated = personnelService.createPersonnel(personnel);
        return ResponseEntity.ok(personnelCreated);
    }

}

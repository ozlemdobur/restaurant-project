package com.restaurant.controller;

import com.restaurant.model.Visitor;
import com.restaurant.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api")
public class VisitorController {

    private VisitorService visitorService;

    public VisitorController() {
    }

    @Autowired
    public VisitorController(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    //http://9090/api/visitor
    @GetMapping(value = "/visitor", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Visitor>> getAllVisitors() {
        Iterable<Visitor> visitors = visitorService.findAll();
        return ResponseEntity.ok(visitors);
    }

    //http://9090/api/visitor
    @PostMapping(value = "/visitor", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Visitor> registerVisitor(@RequestBody Visitor visitor) {
        Visitor visitorCreated = visitorService.registerVisitor(visitor);
                return ResponseEntity.ok(visitorCreated);
    }

    // http://9090/api/visitor/3
    @DeleteMapping(value = "/visitor/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    public void leaveNarnia(@PathVariable Long id) {
        visitorService.leaveNarnia(id);
    }
}

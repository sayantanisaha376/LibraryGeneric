package com.example.controller;


import com.example.entity.DVD;
import com.example.service.GenericCRUDService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dvds")
public class DVDController {

    private final GenericCRUDService<DVD> service;

    public DVDController(GenericCRUDService<DVD> service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DVD> create(@Valid @RequestBody DVD dvd) {
        DVD saved = service.save(dvd);
        return ResponseEntity.status(201).body(saved);
    }

    @GetMapping("/{id}")
    public DVD getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping
    public DVD[] getAll() {
        return service.findAll();
    }

    @PutMapping("/{id}")
    public DVD update(@PathVariable Long id, @Valid @RequestBody DVD dvd) {
        return service.update(id, dvd);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

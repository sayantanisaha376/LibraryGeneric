package com.example.controller;


import com.example.entity.Magazine;
import com.example.service.GenericCRUDService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/magazines")
public class MagazineController {

    private final GenericCRUDService<Magazine> service;

    public MagazineController(GenericCRUDService<Magazine> service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Magazine> create(@Valid @RequestBody Magazine magazine) {
        Magazine saved = service.save(magazine);
        return ResponseEntity.status(201).body(saved);
    }

    @GetMapping("/{id}")
    public Magazine getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping
    public Magazine[] getAll() {
        return service.findAll();
    }

    @PutMapping("/{id}")
    public Magazine update(@PathVariable Long id, @Valid @RequestBody Magazine magazine) {
        return service.update(id, magazine);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}


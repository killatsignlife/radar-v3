package com.fateczl.radarapi.controller;

import com.fateczl.radarapi.model.dto.FamiliarDTO;
import com.fateczl.radarapi.model.entities.Familiar;
import com.fateczl.radarapi.model.services.FamiliaresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1")
public class FamiliaresController {

    @Autowired
    private FamiliaresService service;

    @PostMapping("/familiares")
    public ResponseEntity<Familiar> createFamiliar(@RequestBody FamiliarDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }
    
    @GetMapping("/familiares")

    public ResponseEntity<List<Familiar>> getAllFamiliares() {

    List<Familiar> familiares = service.listAll();

    return ResponseEntity.ok(familiares);

}

    @GetMapping("/familiares/{id}")

    public ResponseEntity<Optional<Familiar>> getFamiliarById(@PathVariable Long id) {

    Optional<Familiar> familiar = service.getById(id);

    return ResponseEntity.ok(familiar);

}
    @PutMapping("/familiares/{id}")

    public ResponseEntity<Familiar> updateFamiliarById(@PathVariable Long id, @RequestBody FamiliarDTO dto) {

    Familiar updatedFamiliar = service.update(id, dto);

    return ResponseEntity.ok(updatedFamiliar);

}
    @DeleteMapping("/familiares/{id}")

    public ResponseEntity<Void> deleteFamiliarById(@PathVariable Long id) {

    service.delete(id);

    return ResponseEntity.noContent().build();

}

}

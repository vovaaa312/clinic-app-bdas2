package com.clinicappbdas2.controller;

import com.clinicappbdas2.model.views.PacientKarta;
import com.clinicappbdas2.service.PacientKartaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:5173"}, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/pacienti-karty")
@RequiredArgsConstructor
public class PacientKartaController {

    private final PacientKartaService pacientKartaService;

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<PacientKarta>> getAll() {
        return ResponseEntity.ok(pacientKartaService.getAll());
    }

    @PostMapping
    public void createPacientKarta(@RequestBody PacientKarta pacient) {
        pacientKartaService.save(pacient);
    }

    @GetMapping("/karta/{id}")
    public ResponseEntity<PacientKarta> getByKartaId(@PathVariable Integer id) {
        PacientKarta pacient = pacientKartaService.getByKartaId(id);
        return ResponseEntity.ok(pacient);
    }

    @GetMapping("/pacient/{id}")
    public ResponseEntity<List<PacientKarta>> getByPacientId(@PathVariable Integer id) {
        return ResponseEntity.ok(pacientKartaService.getByPacientId(id));
    }


    @PutMapping("{id}")
    public ResponseEntity<PacientKarta> updatePacientKarta(@PathVariable int id, @RequestBody PacientKarta pacient) {
        pacientKartaService.update(pacient);
        return ResponseEntity.ok(pacient);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteKarta(@PathVariable int id) {
        pacientKartaService.deleteByKartaId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}

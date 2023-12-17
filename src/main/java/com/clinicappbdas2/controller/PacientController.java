package com.clinicappbdas2.controller;

import com.clinicappbdas2.model.Pacient;
import com.clinicappbdas2.service.PacientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = {"http://localhost:5173"}, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/pacienti")
@RequiredArgsConstructor

public class PacientController {

    private final PacientService pacientService;


    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<Pacient>> getAllPacients() {
        return ResponseEntity.ok(pacientService.getAll());
    }

    @PostMapping
    public void createPacient(@RequestBody Pacient pacient) {
        pacientService.save(pacient);
    }


    @GetMapping("{id}")
    public ResponseEntity<Pacient> getPacientById(@PathVariable Integer id) {
        Pacient pacient = pacientService.getById(id);
        return ResponseEntity.ok(pacient);
    }

    @PutMapping("{id}")
    public ResponseEntity<Pacient> updatePacient(@PathVariable int id, @RequestBody Pacient pacient) {
        pacientService.update(pacient);
        return ResponseEntity.ok(pacient);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deletePacient(@PathVariable int id) {
        //pacientService.getById(id);
        pacientService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/average-age")
    public ResponseEntity<Double> getAverageAge() {
        double averageAge = pacientService.calculateAverageAge();
        return ResponseEntity.ok(averageAge);
    }
}

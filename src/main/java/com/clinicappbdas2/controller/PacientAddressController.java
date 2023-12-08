package com.clinicappbdas2.controller;

import com.clinicappbdas2.model.Pacient;
import com.clinicappbdas2.model.views.PacientAdresa;
import com.clinicappbdas2.service.PacientAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:5173"}, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/pacienti-adresy")
@RequiredArgsConstructor
public class PacientAddressController {

    private final PacientAddressService pacientAddressService;


    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<PacientAdresa>> getAll() {
        return ResponseEntity.ok(pacientAddressService.getAll());
    }

    @PostMapping
    public void createPacientAddress(@RequestBody PacientAdresa pacient) {
        pacientAddressService.save(pacient);
    }

    @GetMapping("{id}")
    public ResponseEntity<PacientAdresa> getPacientAddressById(@PathVariable Integer id) {
        PacientAdresa pacient = pacientAddressService.getById(id);
        return ResponseEntity.ok(pacient);
    }

    @PutMapping("{id}")
    public ResponseEntity<PacientAdresa> updatePacientAddress(@PathVariable int id, @RequestBody PacientAdresa pacient) {
        pacientAddressService.update(pacient);
        return ResponseEntity.ok(pacient);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deletePacient(@PathVariable int id) {
        pacientAddressService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}

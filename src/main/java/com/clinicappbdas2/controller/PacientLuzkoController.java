package com.clinicappbdas2.controller;

import com.clinicappbdas2.model.request.PridejLuzkoPacientoviRequest;
import com.clinicappbdas2.model.views.PacientLuzko;
import com.clinicappbdas2.service.PacientLuzkoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:5173"}, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/pacienti-luzka")
@RequiredArgsConstructor
public class PacientLuzkoController {

    private final PacientLuzkoService luzkoService;


    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<PacientLuzko>> getAll() {
        return ResponseEntity.ok(luzkoService.getAll());
    }

    @PostMapping
    public void createLuzko(@RequestBody PacientLuzko luzko) {
        luzkoService.save(luzko);
    }

    @GetMapping("luzko/{id}")
    public ResponseEntity<PacientLuzko> getByLuzkoId(@PathVariable Integer id) {
        PacientLuzko luzko = luzkoService.getByLuzkoId(id);
        return ResponseEntity.ok(luzko);
    }

    @GetMapping("pokoj/{id}")
    public ResponseEntity<List<PacientLuzko>> getByPokojId(@PathVariable Integer id) {
        return ResponseEntity.ok(luzkoService.getLuzkaByPokojId(id));
    }

    @RequestMapping(value = "release/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> releaseLuzkoById(@PathVariable Integer id) {
        luzkoService.releaseLuzko(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/pridej-pacienta")
    public ResponseEntity<PridejLuzkoPacientoviRequest> pridejLuzkoPacientovi(@RequestBody PridejLuzkoPacientoviRequest luzko) {
        luzkoService.pridejLuzkoPacientovi(luzko);
        return ResponseEntity.ok(luzko);

    }


    @PutMapping("{id}")
    public ResponseEntity<PacientLuzko> updateLuzko(@PathVariable int id, @RequestBody PacientLuzko luzko) {
        luzkoService.update(luzko);
        return ResponseEntity.ok(luzko);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteLuzko(@PathVariable int id) {
        luzkoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
    @GetMapping("/available-beds/{oddelId}")
    public ResponseEntity<Integer> getAvailableBeds(@PathVariable int oddelId) {
        int availableBeds = luzkoService.getAvailableBeds(oddelId);
        return ResponseEntity.ok(availableBeds);
    }
}

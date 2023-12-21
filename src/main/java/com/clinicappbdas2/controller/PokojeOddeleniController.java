package com.clinicappbdas2.controller;

import com.clinicappbdas2.model.views.PokojeOddeleni;
import com.clinicappbdas2.service.PokojeOddeleniService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:5173"}, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/pokoje-oddeleni")
@RequiredArgsConstructor
public class PokojeOddeleniController {
    private final PokojeOddeleniService pokojeService;

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<PokojeOddeleni>> getAll() {
        return ResponseEntity.ok(pokojeService.getAll());
    }

    @GetMapping("oddeleni/{id}")
    public ResponseEntity<List<PokojeOddeleni>> getByOddeleniId(@PathVariable Long id) {
        return ResponseEntity.ok(pokojeService.getByOddeleniId(id));
    }

    @PostMapping
    public void createPokoj(@RequestBody PokojeOddeleni pokoj) {
        pokojeService.createPokoj(pokoj);
    }

    @GetMapping("{id}")
    public ResponseEntity<PokojeOddeleni> getByPokojId(@PathVariable Long id) {
        PokojeOddeleni pokoj = pokojeService.getByPokojId(id);
        return ResponseEntity.ok(pokoj);
    }



    @PutMapping("{id}")
    public ResponseEntity<PokojeOddeleni> updatePokoj(@PathVariable int id, @RequestBody PokojeOddeleni pokoj) {
        pokojeService.updatePokoj(pokoj);
        return ResponseEntity.ok(pokoj);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deletePokoj(@PathVariable Long id) {
        pokojeService.deletePokoj(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }


}

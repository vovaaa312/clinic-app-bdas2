package com.clinicappbdas2.controller;

import com.clinicappbdas2.model.Zamestnanec;
import com.clinicappbdas2.service.ZamestnanecService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:5173"}, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/zamestnanci")
@RequiredArgsConstructor
public class ZamestnanciController {

    private final ZamestnanecService zamestnanecService;

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<Zamestnanec>> getAll() {
        return ResponseEntity.ok(zamestnanecService.getAll());
    }

    @PostMapping
    public void create(@RequestBody Zamestnanec zamestnanec) {
        zamestnanecService.save(zamestnanec);
    }


    @GetMapping("{id}")
    public ResponseEntity<Zamestnanec> getById(@PathVariable Long id){
        Zamestnanec zamestnanec=   zamestnanecService.getById(id);
        return ResponseEntity.ok(zamestnanec);
    }
    @PutMapping("{id}")
    public ResponseEntity<Zamestnanec> update(@PathVariable int id, @RequestBody Zamestnanec pacient) {
        zamestnanecService.update(pacient);
        return ResponseEntity.ok(pacient);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deletet(@PathVariable Long id){
        //pacientService.getById(id);
        zamestnanecService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}

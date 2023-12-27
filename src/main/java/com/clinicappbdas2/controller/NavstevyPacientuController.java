package com.clinicappbdas2.controller;

import com.clinicappbdas2.model.views.NavstevaPacienta;
import com.clinicappbdas2.service.NavstevyPacientuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:5173"}, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/navstevy-pacientu")
@RequiredArgsConstructor
public class NavstevyPacientuController {

    private final NavstevyPacientuService navstevyService;

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<NavstevaPacienta>> getAll() {
        return ResponseEntity.ok(navstevyService.getAll());
    }


    @GetMapping("{id}")
    public ResponseEntity<NavstevaPacienta> getByNavstevaId(@PathVariable Long id){
        return ResponseEntity.ok(navstevyService.getByNavstevaId(id));
    }
    @GetMapping("pacient/{id}")
    public ResponseEntity<List<NavstevaPacienta>>getAllByPacientId(@PathVariable Long id){
        return ResponseEntity.ok(navstevyService.getAllByPacientId(id));
    }
    @GetMapping("zamestnanec/{id}")
    public ResponseEntity<List<NavstevaPacienta>>getAllByZamestnanecId(@PathVariable Long id){
        return ResponseEntity.ok(navstevyService.getAllByZamestnanecId(id));
    }

    @GetMapping("oddeleni/{id}")
    public ResponseEntity<List<NavstevaPacienta>>getAllByOddeleniId(@PathVariable Long id){
        return ResponseEntity.ok(navstevyService.getAllByOddeleniId(id));
    }
    @PostMapping
    public void createNavsteva(@RequestBody NavstevaPacienta navsteva) {
        navstevyService.createNavsteva(navsteva);
    }
    @PutMapping("{id}")
    public ResponseEntity<NavstevaPacienta> updateNavsteva(@PathVariable int id, @RequestBody NavstevaPacienta navsteva) {
        navstevyService.updateNavsteva(navsteva);
        return ResponseEntity.ok(navsteva);
    }

    @GetMapping("/recommendation/{id}")
    public ResponseEntity<?> getRecommendation(@PathVariable Long id) {
        navstevyService.getPatientRecommendation(id);
        return ResponseEntity.ok("Recommendation updated");
    }



    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteNavsteva(@PathVariable Long id) {
        navstevyService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

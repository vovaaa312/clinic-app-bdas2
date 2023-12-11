package com.clinicappbdas2.controller;

import com.clinicappbdas2.model.views.PacientAdresa;
import com.clinicappbdas2.model.views.PacientAnalyza;
import com.clinicappbdas2.service.PacientAnalyzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:5173"}, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/pacienti-analyzy")
@RequiredArgsConstructor
public class PacientAnalyzaController {
    private final PacientAnalyzaService pacientService;

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<PacientAnalyza>> getAll() {
        return ResponseEntity.ok(pacientService.getAll());
    }

    @PostMapping
    public void create(@RequestBody PacientAnalyza pacient) {
        pacientService.save(pacient);
    }

    @GetMapping("{id}")
    public ResponseEntity<PacientAnalyza> getByAnalysisId(@PathVariable Integer id) {
        PacientAnalyza pacient = pacientService.getByAnalysisId(id);
        return ResponseEntity.ok(pacient);
    }



    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deletePacient(@PathVariable int id) {
        pacientService.deleteAnalysis(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}

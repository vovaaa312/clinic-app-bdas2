package com.clinicappbdas2.controller;

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
    public void save(@RequestBody PacientAnalyza pacient) {
        pacientService.save(pacient);
    }

    @PutMapping("{id}")
    public ResponseEntity<PacientAnalyza> updateAnalyza(@RequestBody PacientAnalyza analyza) {
        pacientService.updateAnalyza(analyza);
        return ResponseEntity.ok(analyza);
    }


    @GetMapping("pacient/{id}")
    public ResponseEntity<List<PacientAnalyza>> getAllByPacId(@PathVariable Long id)
    {
        return ResponseEntity.ok(pacientService.getByPacientId(id));
    }

    @GetMapping("oddeleni/{id}")
    public ResponseEntity<List<PacientAnalyza>> getAllByOddId(@PathVariable Long id)
    {
        return ResponseEntity.ok(pacientService.getByOddeleniId(id));
    }

    @GetMapping("{id}")
    public ResponseEntity<PacientAnalyza> getByAnalysisId(@PathVariable Long id) {
        PacientAnalyza pacient = pacientService.getByAnalysisId(id);
        return ResponseEntity.ok(pacient);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteAnalysis(@PathVariable Long id) {
        pacientService.deleteAnalysis(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}

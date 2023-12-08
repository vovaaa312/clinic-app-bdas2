package com.clinicappbdas2.controller;

import com.clinicappbdas2.model.Oddeleni;
import com.clinicappbdas2.service.repository.OddeleniRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:5173"}, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/oddeleni")
@RequiredArgsConstructor
public class OddeleniController {
    private final OddeleniRepository oddeleniRepository;

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<Oddeleni>> getAll() {
        return ResponseEntity.ok(oddeleniRepository.getAll());
    }


}
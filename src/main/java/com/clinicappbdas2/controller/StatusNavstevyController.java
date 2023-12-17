package com.clinicappbdas2.controller;

import com.clinicappbdas2.model.StatusNavstevy;
import com.clinicappbdas2.service.StatusNavstevyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:5173"}, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/status-navstevy")
@RequiredArgsConstructor
public class StatusNavstevyController {

    private final StatusNavstevyService statusService;

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<StatusNavstevy>> getAll() {
        return ResponseEntity.ok(statusService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<StatusNavstevy> getById(@PathVariable Long id){
        return ResponseEntity.ok(statusService.getById(id));
    }
}

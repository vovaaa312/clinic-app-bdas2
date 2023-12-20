package com.clinicappbdas2.controller;

import com.clinicappbdas2.model.LogData;
import com.clinicappbdas2.service.DatabaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:5173"}, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/logs")
@RequiredArgsConstructor
public class LogController {

    private final DatabaseService databaseService;

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<LogData>> getAll() {
        return ResponseEntity.ok(databaseService.getLogs());
    }


}

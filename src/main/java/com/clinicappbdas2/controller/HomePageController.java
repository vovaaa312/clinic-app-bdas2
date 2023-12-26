package com.clinicappbdas2.controller;

import com.clinicappbdas2.service.OddeleniService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/homepage")
@RequiredArgsConstructor
public class HomePageController {

    private final OddeleniService oddeleniService;

    @GetMapping("beds/{id}")
    public ResponseEntity<Long> getAvailableBedsInDepartment(@PathVariable Long id) {

        return ResponseEntity.ok(oddeleniService.getAvailableBeds(id));
    }

}

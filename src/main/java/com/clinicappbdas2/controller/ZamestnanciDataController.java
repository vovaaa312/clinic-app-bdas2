package com.clinicappbdas2.controller;


import com.clinicappbdas2.model.views.ZamestnanecData;
import com.clinicappbdas2.service.ZamestnanecDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:5173"}, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/zamestnanci-data")
@RequiredArgsConstructor
public class ZamestnanciDataController {

    private final ZamestnanecDataService zamestnanciService;

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<ZamestnanecData>> getAll() {
        return ResponseEntity.ok(zamestnanciService.findAll());
    }

    @PostMapping
    public void createZamestnanecData(@RequestBody ZamestnanecData pacient) {
        zamestnanciService.save(pacient);
    }

    @GetMapping("{id}")
    public ResponseEntity<ZamestnanecData> getZamestnanecDataById(@PathVariable Integer id) {
        ZamestnanecData data = zamestnanciService.getById(id);
        return ResponseEntity.ok(data);
    }
    @GetMapping("oddeleni/{id}")
    public ResponseEntity<List<ZamestnanecData>> getAllByOddeleni(@PathVariable Long id) {
        return ResponseEntity.ok(zamestnanciService.getAllByOddeleniId(id));
    }


    @PutMapping("{id}")
    public ResponseEntity<ZamestnanecData> updateZamestnanecData(@PathVariable int id, @RequestBody ZamestnanecData data) {
        zamestnanciService.update(data);
        return ResponseEntity.ok(data);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteZamestnanecData(@PathVariable int id) {
        zamestnanciService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}

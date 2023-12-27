package com.clinicappbdas2.controller;

import com.clinicappbdas2.model.request.PrumVekRequest;
import com.clinicappbdas2.model.views.PacientAdresa;
import com.clinicappbdas2.model.views.PacientKarta;
import com.clinicappbdas2.service.PacientAddressService;
import com.clinicappbdas2.service.PacientKartaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:5173"}, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/pacienti-adresy")
@RequiredArgsConstructor
public class PacientAddressController {

    private final PacientAddressService pacientAddressService;
    private final PacientKartaService pacientKartaService;


    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<PacientAdresa>> getAll() {
        return ResponseEntity.ok(pacientAddressService.getAll());
    }


    //        return axios.get<PacientAdresa[]>(`${BASE_URL}/oddeleni/${oddeleniId}`);
    @GetMapping("oddeleni/{id}")
    public ResponseEntity<List<PacientKarta>> getAllByOddeleni(@PathVariable Long id) {
        return ResponseEntity.ok(pacientKartaService.getAllByOddeleniId(id));
    }

//    @GetMapping("prum-vek")
//    public ResponseEntity<Double> vypocitatPrumernyVekPacientu(@RequestParam("datumOd") Date datumOd,
//                                                               @RequestParam("datumDo") Date datumDo,
//                                                               @RequestParam("pohlavi") String pohlavi) {
//        return ResponseEntity.ok(pacientAddressService.vypocitatPrumernyVekPacientu(new PrumVekRequest(datumOd,datumDo, pohlavi)));
//    }

    @PostMapping("prum-vek")
    public ResponseEntity<Double> vypocitatPrumernyVekPacientu(@RequestBody PrumVekRequest request) {
        return ResponseEntity.ok(pacientAddressService.vypocitatPrumernyVekPacientu(request));
    }


    @PostMapping
    public void createPacientAddress(@RequestBody PacientAdresa pacient) {
        pacientAddressService.save(pacient);
    }

    @GetMapping("{id}")
    public ResponseEntity<PacientAdresa> getPacientAddressById(@PathVariable Integer id) {
        PacientAdresa pacient = pacientAddressService.getById(id);
        return ResponseEntity.ok(pacient);
    }

    @PutMapping("{id}")
    public ResponseEntity<PacientAdresa> updatePacientAddress(@PathVariable int id, @RequestBody PacientAdresa pacient) {
        pacientAddressService.update(pacient);
        return ResponseEntity.ok(pacient);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deletePacient(@PathVariable int id) {
        pacientAddressService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}

package com.clinicappbdas2.service;

import com.clinicappbdas2.model.request.PrumVekRequest;
import com.clinicappbdas2.model.views.PacientAdresa;
import com.clinicappbdas2.service.repository.PacientAdressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PacientAddressService {


    private final PacientAdressRepository pacientAdressRepository;


    public List<PacientAdresa> getAll() {
        return pacientAdressRepository.getAllPacients();
    }

    public PacientAdresa getById(int id) {
        return pacientAdressRepository.getPacientById(id);
    }

    public void save(PacientAdresa pacientAdresa) {
        pacientAdressRepository.createPacient(pacientAdresa);
    }

    public void delete(int id) {
        pacientAdressRepository.deletePacient(id);
    }

    public void update(PacientAdresa pacientAdresa) {
        pacientAdressRepository.updatePacient(pacientAdresa);
    }

    public Double vypocitatPrumernyVekPacientu(PrumVekRequest request) {
        return pacientAdressRepository.vypocitatPrumernyVekPacientu(
                request.getDatumOd(),
                request.getDatumDo(),
                request.getPohlavi()
                );
    }

//    public List<PacientKarta> getAllByOddeleniId(Long id) {
//        return pacientAdressRepository.getAllByOddeleniId(id);
//    }
}
package com.clinicappbdas2.service;

import com.clinicappbdas2.model.Pacient;
import com.clinicappbdas2.service.repository.PacientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PacientService {

    private final PacientRepository pacientRepository;

    public List<Pacient> getAll() {
        return pacientRepository.getAll();
    }

    public Pacient getById(int id) {
        return pacientRepository.getById(id);
    }

    public void save(Pacient pacient) {
        pacientRepository.save(pacient);
    }

    public void update(Pacient pacient) {
        pacientRepository.update(pacient);
    }
    public void delete(int id){
        pacientRepository.deleteById(id);
    }

    public List<Pacient> getByJmeno(String jmeno) {
        return pacientRepository.getByJmeno(jmeno);
    }

    public List<Pacient> getByPrijmeni(String prijmeni) {
        return pacientRepository.getByPrijmeni(prijmeni);
    }

    public List<Pacient> getByCisloTelefonu(Integer cisloTelefonu) {
        return pacientRepository.getByCisloTelefonu(cisloTelefonu);
    }
}

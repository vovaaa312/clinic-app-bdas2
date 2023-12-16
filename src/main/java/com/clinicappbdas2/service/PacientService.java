package com.clinicappbdas2.service;

import com.clinicappbdas2.model.Pacient;
import com.clinicappbdas2.service.repository.PacientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PacientService {

    private final PacientRepository pacientRepository;
    private final JdbcTemplate jdbcTemplate;

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

    public double calculateAverageAge() {
        return jdbcTemplate.queryForObject(
                "SELECT vypocitat_prumerny_vek_pacientu() FROM dual",
                Double.class
        );
    }
}

package com.clinicappbdas2.service.repository;

import com.clinicappbdas2.model.Pacient;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PacientRepository {

    private final JdbcTemplate jdbcTemplate;


    public void save(Pacient pacient) {
        String sql = "INSERT INTO ST64550.PACIENTI " +
                "( ID_ADRESA, JMENO, PRIJMENI, DATUM_HOSPITALIZACE, DATUM_NAROZENI, CISLO_TELEFONU, POHLAVI) " +
                "VALUES ( ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, pacient.getJmeno(), pacient.getPrijmeni(),
                pacient.getDatumHospitalizace(), pacient.getDatumNarozeni(),
                pacient.getCisloTelefonu(), pacient.getPohlavi());
    }


    public void update(Pacient pacient) {
        jdbcTemplate.update("UPDATE PACIENTI SET ID_ADRESA=?, JMENO=?, PRIJMENI=?, DATUM_HOSPITALIZACE=?, DATUM_NAROZENI=?, CISLO_TELEFONU=?, POHLAVI=? WHERE ID_PACIENT=?",
                pacient.getIdAdresa(), pacient.getJmeno(), pacient.getPrijmeni(), pacient.getDatumHospitalizace(), pacient.getDatumNarozeni(), pacient.getCisloTelefonu(), pacient.getPohlavi(), pacient.getIdPacient());
    }

    public Pacient getById(Integer id) {
        String sql = "SELECT * FROM PACIENTI WHERE ID_PACIENT = ?";

        // Используем BeanPropertyRowMapper для маппинга результата на объект Pacient
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Pacient.class));
    }

    public void deleteById(Integer id) {
        String sql = "DELETE FROM PACIENTI WHERE ID_PACIENT=?";
        jdbcTemplate.update(sql, id);
    }


    public List<Pacient> getAll() {
        return jdbcTemplate.query("SELECT * from PACIENTI",
                BeanPropertyRowMapper.newInstance(Pacient.class));
    }

    public List<Pacient> getByJmeno(String jmeno) {
        return jdbcTemplate.query("SELECT * from PACIENTI WHERE jmeno=?",
                BeanPropertyRowMapper.newInstance(Pacient.class), jmeno);
    }

    public List<Pacient> getByPrijmeni(String prijmeni) {
        return jdbcTemplate.query("SELECT * from PACIENTI WHERE prijmeni=?",
                BeanPropertyRowMapper.newInstance(Pacient.class), prijmeni);
    }

    public List<Pacient> getByCisloTelefonu(Integer cisloTelefonu) {
        return jdbcTemplate.query("SELECT * from PACIENTI WHERE cislo_telefonu=?",
                BeanPropertyRowMapper.newInstance(Pacient.class), cisloTelefonu);
    }

}


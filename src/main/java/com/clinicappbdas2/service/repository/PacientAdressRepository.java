package com.clinicappbdas2.service.repository;

import com.clinicappbdas2.model.views.PacientAddressMapper;
import com.clinicappbdas2.model.views.PacientAdresa;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PacientAdressRepository {

    private final JdbcTemplate jdbcTemplate;

    public List<PacientAdresa> getAllPacients(){
        String sql = "SELECT * FROM PACIENTI_VIEW";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(PacientAdresa.class));
    }

    public void createPacient(PacientAdresa pacientAdresa){
        String sql = "CALL VLOZ_PACIENTA(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, pacientAdresa.getJmeno(), pacientAdresa.getPrijmeni(),
                pacientAdresa.getDatumHospitalizace(), pacientAdresa.getDatumNarozeni(),
                pacientAdresa.getCisloTelefonu(), pacientAdresa.getPohlavi(),
                pacientAdresa.getZeme(), pacientAdresa.getMesto(),
                pacientAdresa.getAdresa(), pacientAdresa.getPsc());
    }

    public PacientAdresa getPacientById(Integer id){
        String sql = "SELECT * FROM PACIENTI_VIEW WHERE ID_PACIENT = ?";
        return jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                new PacientAddressMapper()
        );
    }

    public void updatePacient(PacientAdresa pacientAdresa) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("UPDATE_PACIENT");

        MapSqlParameterSource in = new MapSqlParameterSource()
                .addValue("p_id_pacient", pacientAdresa.getIdPacient())
                .addValue("p_jmeno", pacientAdresa.getJmeno())
                .addValue("p_prijmeni", pacientAdresa.getPrijmeni())
                .addValue("p_datum_hospitalizace", pacientAdresa.getDatumHospitalizace())
                .addValue("p_datum_narozeni", pacientAdresa.getDatumNarozeni())
                .addValue("p_cislo_telefonu", pacientAdresa.getCisloTelefonu())
                .addValue("p_pohlavi", pacientAdresa.getPohlavi())

                .addValue("p_id_adresa", pacientAdresa.getIdAdresa())
                .addValue("p_zeme", pacientAdresa.getZeme())
                .addValue("p_mesto", pacientAdresa.getMesto())
                .addValue("p_adresa", pacientAdresa.getAdresa())
                .addValue("p_psc", pacientAdresa.getPsc())
                ;

        simpleJdbcCall.execute(in);
    }

    public void deletePacient(Integer id){
        String sql = "DELETE FROM PACIENTI WHERE ID_PACIENT = ?";
        jdbcTemplate.update(sql, id);
    }



}
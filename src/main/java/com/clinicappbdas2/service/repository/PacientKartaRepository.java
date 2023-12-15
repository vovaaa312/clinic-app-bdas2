package com.clinicappbdas2.service.repository;

import com.clinicappbdas2.model.views.PacientKarta;
import com.clinicappbdas2.model.mapper.PacientKartaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PacientKartaRepository {

    private final JdbcTemplate jdbcTemplate;


    public List<PacientKarta> getAll(){
        String sql = "SELECT * FROM PACIENTI_KARTY_VIEW";
        return jdbcTemplate.query(sql, new PacientKartaMapper());
    }

    public void save(PacientKarta pacient){
        String sql = "CALL VLOZ_KARTU_PACIENTA(?,?,?,?)";
        jdbcTemplate.update(sql,
                pacient.getJmeno(),
                pacient.getPrijmeni(),
                pacient.getCisloTelefonu(),
                pacient.getNazevOddeleni());
    }

    public void update(PacientKarta pacientKarta){
        String sql = "UPDATE KARTY_PACIENTU SET ID_PACIENT=?,ID_ODDELENI=? WHERE ID_KARTA =?";
        jdbcTemplate.update(sql,
                pacientKarta.getIdPacient(), pacientKarta.getIdOddeleni(), pacientKarta.getIdKarta());
    }

    public void deleteByKartaId(Integer id){
        String sql = "DELETE FROM KARTY_PACIENTU WHERE ID_KARTA = ?";
        jdbcTemplate.update(sql, id);
    }

    public List <PacientKarta> getByPacientId(Integer id){
        String sql = "SELECT * FROM PACIENTI_KARTY_VIEW WHERE ID_PACIENT = ?";

        return jdbcTemplate.query(sql, new Object[]{id}, new PacientKartaMapper());
    }

    public PacientKarta getByKartaId(Integer id){
        String sql = "SELECT * FROM PACIENTI_KARTY_VIEW WHERE ID_KARTA = ?";
        return jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                new PacientKartaMapper()
        );
    }


}

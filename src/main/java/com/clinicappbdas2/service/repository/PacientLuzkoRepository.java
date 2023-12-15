package com.clinicappbdas2.service.repository;

import com.clinicappbdas2.model.mapper.PacientLuzkoMapper;
import com.clinicappbdas2.model.views.PacientLuzko;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PacientLuzkoRepository {
    private final JdbcTemplate jdbcTemplate;

    public List<PacientLuzko> getAll(){
        String sql = "SELECT * FROM PACIENTI_LUZKA_VIEW";
        return jdbcTemplate.query(sql, new PacientLuzkoMapper());
    }

    public List<PacientLuzko> getLuzkaByPokojId(Integer id){
        String sql = "SELECT * FROM PACIENTI_LUZKA_VIEW WHERE ID_POKOJ = ?";
        return jdbcTemplate.query(sql, new Object[]{id}, new PacientLuzkoMapper());

    }

    public PacientLuzko getByLuzkoId(Integer id){
        String sql = "SELECT * FROM PACIENTI_LUZKA_VIEW WHERE ID_LUZKO = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new PacientLuzkoMapper());

    }

    public void save (PacientLuzko luzko){
        String sql = "CALL VLOZ_LUZKO(?,?,?,?,?)";
        jdbcTemplate.update(
                sql,
                luzko.getIdPokoj(),
                luzko.getIdPacient(),
                luzko.getDatumRezervace(),
                luzko.getDatumPropusteni(),
                luzko.getCislo()
        );
    }
    public void releaseLuzko(Integer id){
        String sql = "CALL UVOLNI_LUZKO(?)";
        jdbcTemplate.update(sql, id);
    }


    public void pridejLuzkoPacientovi(Integer luzkoId, Integer pacientId, Date datumRezervace){
        String sql = "CALL VLOZ_PACIENTA_V_LUZKO(?,?,?)";
        jdbcTemplate.update(sql, luzkoId, pacientId, datumRezervace);

    }

    public void delete(Integer id){
        String sql = "DELETE FROM LUZKA WHERE ID = ?";
        jdbcTemplate.update(sql,id);
    }


    public void update(PacientLuzko luzko) {
        String sql = "CALL UPDATE_LUZKO(?,?,?,?,?)";
        jdbcTemplate.update(
                sql,
                luzko.getIdLuzko(),
                luzko.getIdPokoj(),
                luzko.getCislo(),
                luzko.getDatumRezervace(),
                luzko.getDatumPropusteni());

    }
}

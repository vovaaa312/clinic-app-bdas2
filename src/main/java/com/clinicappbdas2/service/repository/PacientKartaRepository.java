package com.clinicappbdas2.service.repository;

import com.clinicappbdas2.model.mapper.PacientKartaMapper;
import com.clinicappbdas2.model.views.PacientKarta;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PacientKartaRepository {

    private final JdbcTemplate jdbcTemplate;


    public List<PacientKarta> getAll(){
        String sql = "SELECT * FROM PACIENTI_KARTY_VIEW ORDER BY NAZEV_ODDELENI";
        return jdbcTemplate.query(sql, new PacientKartaMapper());
    }

    public void save(PacientKarta pacient){
        String sql = "CALL VLOZ_KARTU_PACIENTA(?,?)";
        jdbcTemplate.update(sql,
                pacient.getIdPacient(),
                pacient.getIdOddeleni());
    }

    public void update(PacientKarta pacientKarta){
//        String sql = "CALL UPDATE_KARTA(?,?,?)";
//        jdbcTemplate.update(sql,
//                pacientKarta.getIdPacient(), pacientKarta.getIdOddeleni(), pacientKarta.getIdKarta());

//        SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("UPDATE_KARTA");
//        MapSqlParameterSource in = new MapSqlParameterSource()
//                .addValue("PACIENT_ID_P", pacientKarta.getIdPacient())
//                .addValue("ODDELENI_ID_P", pacientKarta.getIdOddeleni())
//                .addValue("KARTA_ID_P", pacientKarta.getIdKarta());
//        call.execute(in);

        String sql = "UPDATE KARTY_PACIENTU SET ID_PACIENT =?, ID_ODDELENI = ? WHERE ID_KARTA=?";
        jdbcTemplate.update(sql, pacientKarta.getIdPacient(), pacientKarta.getIdOddeleni(), pacientKarta.getIdKarta());


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


    public List<PacientKarta> getAllByOddeleniId(Long id) {
        String sql = "SELECT * FROM PACIENTI_KARTY_VIEW WHERE ID_ODDELENI = ?";
        return jdbcTemplate.query(sql,new Object[]{id},new PacientKartaMapper());
    }
}

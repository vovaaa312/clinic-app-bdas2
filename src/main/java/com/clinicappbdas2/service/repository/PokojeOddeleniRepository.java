package com.clinicappbdas2.service.repository;

import com.clinicappbdas2.model.mapper.PokojeOddeleniMapper;
import com.clinicappbdas2.model.views.PokojeOddeleni;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PokojeOddeleniRepository {

    private final JdbcTemplate jdbcTemplate;

    public List<PokojeOddeleni> getAll() {
        String sql = "SELECT * FROM POKOJE_ODDELENI_VIEW";
        return jdbcTemplate.query(sql, new PokojeOddeleniMapper());
    }

    public List<PokojeOddeleni> getByOddeleniId(Long id) {
        String sql = "SELECT * FROM POKOJE_ODDELENI_VIEW WHERE ID_ODDELENI = ?";
        return jdbcTemplate.query(sql, new Object[]{id}, new PokojeOddeleniMapper());

    }

    public void addPokoj(PokojeOddeleni pokoj) {
        String sql = "CALL VLOZ_POKOJ(?,?,?)";
        jdbcTemplate.update(
                sql,
                pokoj.getPatro(),
                pokoj.getIdOddeleni(),
                pokoj.getCislo()

        );
    }

    public void deletePokoj(Long id) {
        String sql = "CALL ODEBER_POKOJ(?)";
        jdbcTemplate.update(sql, id);
    }

    public void updatePokoj(PokojeOddeleni pokoj) {
        String sql = "CALL UPDATE_POKOJ(?,?,?,?)";
        jdbcTemplate.update(
                sql,
                pokoj.getIdPokoj(),
                pokoj.getPatro(),
                pokoj.getIdOddeleni(),
                pokoj.getCislo());
    }

    public PokojeOddeleni getByPokojId(Long id){
        String sql = "SELECT * FROM POKOJE_ODDELENI_VIEW WHERE ID_POKOJ = ?";
        return jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                new PokojeOddeleniMapper()
        );
    }

}

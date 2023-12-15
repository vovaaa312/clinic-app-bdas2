package com.clinicappbdas2.service.repository;

import com.clinicappbdas2.model.Luzko;
import com.clinicappbdas2.model.mapper.LuzkoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class LuzkoRepository {

    private final JdbcTemplate jdbcTemplate;

    public List<Luzko> getAll() {
        String sql = "SELECT * FROM LUZKA";
        return jdbcTemplate.query(sql, new LuzkoMapper());
    }

    public List<Luzko> getByPokojId(Integer id){
        String sql = "SELECT * FROM LUZKA WHERE ID_POKOJ = ?";
        return jdbcTemplate.query(sql,new Object[]{id}, new LuzkoMapper());
    }

    public Luzko getByLuzkoId(Integer id){
        String sql = "SELECT * FROM LUZKA WHERE ID_LUZKO =?";
        return null;

    }

    public void deleteByLuzkoId(Integer id) {
        String sql = "DELETE FROM LUZKA WHERE ID_LUZKO =?";
        jdbcTemplate.update(sql,id);
    }

    public void releaseLuzko(Integer id){
        String sql = "CALL UVOLNI_LUZKO(?)";
        jdbcTemplate.update(sql, id);
    }
}

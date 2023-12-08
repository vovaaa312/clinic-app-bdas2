package com.clinicappbdas2.service.repository;

import com.clinicappbdas2.model.Oddeleni;
import com.clinicappbdas2.model.Pacient;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OddeleniRepository {

    private final JdbcTemplate jdbcTemplate;

    public void save(Oddeleni oddeleni) {
        String sql = "INSERT INTO ST64550.ODDELENI " +
                "(  NAZEV_ODDELENI) " +
                "VALUES (  ?)";
        jdbcTemplate.update(sql, oddeleni.getNazevOddeleni());
    }

    public List<Oddeleni> getAll() {
        return jdbcTemplate.query("SELECT * from ODDELENI",
                BeanPropertyRowMapper.newInstance(Oddeleni.class));
    }

}

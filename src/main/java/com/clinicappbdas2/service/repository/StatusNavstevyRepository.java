package com.clinicappbdas2.service.repository;

import com.clinicappbdas2.model.StatusNavstevy;
import com.clinicappbdas2.model.mapper.StatusNavstevyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StatusNavstevyRepository {

    private final JdbcTemplate jdbcTemplate;

    public List<StatusNavstevy> getAll(){
        String sql = "SELECT * FROM STATUS_NAVSTEVY";
        return jdbcTemplate.query(sql, new StatusNavstevyMapper());
    }

    public StatusNavstevy getById(Long id){
        String sql = "SELECT * FROM STATUS_NAVSTEVY WHERE ID_STATUS = ?";
        return jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                new StatusNavstevyMapper()
        );
    }
}

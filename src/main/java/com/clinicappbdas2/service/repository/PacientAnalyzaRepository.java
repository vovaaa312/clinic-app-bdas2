package com.clinicappbdas2.service.repository;

import com.clinicappbdas2.model.views.PacientAnalyzaMapper;
import com.clinicappbdas2.model.views.PacientiAnalyza;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PacientAnalyzaRepository {

    private final JdbcTemplate jdbcTemplate;

    public List<PacientiAnalyza> getAllAnalysis() {
        String sql = "SELECT * FROM PACIENTI_ANALYZY_VIEW";
        return jdbcTemplate.query(sql, new PacientAnalyzaMapper());
    }
}

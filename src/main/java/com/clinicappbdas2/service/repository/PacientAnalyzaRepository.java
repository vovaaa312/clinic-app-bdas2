package com.clinicappbdas2.service.repository;

import com.clinicappbdas2.model.mapper.PacientAnalyzaMapper;
import com.clinicappbdas2.model.views.PacientAnalyza;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PacientAnalyzaRepository {

    private final JdbcTemplate jdbcTemplate;

    public List<PacientAnalyza> getAllAnalysis() {
        String sql = "SELECT * FROM PACIENTI_ANALYZY_VIEW";
        return jdbcTemplate.query(sql, new PacientAnalyzaMapper());
    }

    public void save(PacientAnalyza analyza) {

        String sql = "CALL VLOZ_ANALYZU(?,?,?,?,?,?)";
        jdbcTemplate.update(
                sql,
                analyza.getIdKarta(),
                analyza.getDatum(),
                analyza.getRbc(),
                analyza.getWbc(),
                analyza.getHgb(),
                analyza.getPlt());
    }


    public List<PacientAnalyza> getByPacientId(Integer id) {
        String sql = "SELECT * FROM PACIENTI_ANALYZY_VIEW WHERE ID_PACIENT = ?";

        return jdbcTemplate.query(sql, new Object[]{id}, new PacientAnalyzaMapper());
    }

    public PacientAnalyza getByAnalysisId(Integer id) {
        String sql = "SELECT * FROM PACIENTI_ANALYZY_VIEW WHERE ID_ANALYZA = ?";
        return jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                new PacientAnalyzaMapper()
        );
    }

    public void deleteAnalysis(Integer id) {
        String sql = "DELETE FROM ANALYZY WHERE ID_ANALYZA = ?";
        jdbcTemplate.update(sql, id);
    }


    public void updateAnalyza(PacientAnalyza analyza) {
        String sql = "CALL UPDATE_ANALYZA(?,?,?,?,?,?)";
        jdbcTemplate.update(
                sql,
                analyza.getIdAnalyza(),
                analyza.getRbc(),
                analyza.getWbc(),
                analyza.getHgb(),
                analyza.getPlt(),
                analyza.getDatum());
    }

}

package com.clinicappbdas2.service.repository;

import com.clinicappbdas2.model.mapper.PacientAnalyzaMapper;
import com.clinicappbdas2.model.views.PacientAnalyza;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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


    public List<PacientAnalyza> getByPacientId(Long id) {
        String sql = "SELECT * FROM PACIENTI_ANALYZY_VIEW WHERE ID_PACIENT = ?";

        return jdbcTemplate.query(sql, new Object[]{id}, new PacientAnalyzaMapper());
    }

    public List<PacientAnalyza>getByOddeleniId(Long id){
        //select * from PACIENTI_ANALYZY_VIEW where ID_ODDELENI
        String sql = "SELECT * FROM PACIENTI_ANALYZY_VIEW WHERE ID_ODDELENI = ?";

        return jdbcTemplate.query(sql, new Object[]{id}, new PacientAnalyzaMapper());
    }

    public PacientAnalyza getByAnalysisId(Long id) {
        String sql = "SELECT * FROM PACIENTI_ANALYZY_VIEW WHERE ID_ANALYZA = ?";
        return jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                new PacientAnalyzaMapper()
        );
    }

    public void deleteAnalysis(Long id) {
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

    public List<Map<String, Object>> vypocitatScoreZdraviOddeleni() {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withFunctionName("vypocitat_skore_zdravi_oddeleni")
                .returningResultSet("result", new RowMapper<Map<String, Object>>() {
                    @Override
                    public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
                        // Обработка строки результата
                        return Map.of(
                                "NAZEV_ODDELENI", rs.getString("nazev_oddeleni"),
                                "PRUM_ZDRAV_SKORE", rs.getDouble("prum_zdrav_skore")
                        );
                    }
                });

        Map<String, Object> result = jdbcCall.execute();
        List<Map<String, Object>> resultList = (List<Map<String, Object>>) result.get("result");
        return resultList;
    }

}

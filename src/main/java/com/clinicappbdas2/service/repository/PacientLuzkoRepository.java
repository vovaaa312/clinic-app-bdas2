package com.clinicappbdas2.service.repository;

import com.clinicappbdas2.model.mapper.PacientLuzkoMapper;
import com.clinicappbdas2.model.views.PacientLuzko;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.*;

@Repository
@RequiredArgsConstructor
public class PacientLuzkoRepository {
    private final JdbcTemplate jdbcTemplate;

    public List<PacientLuzko> getAll() {
        String sql = "SELECT * FROM PACIENTI_LUZKA_VIEW";
        return jdbcTemplate.query(sql, new PacientLuzkoMapper());
    }

    public List<PacientLuzko> getLuzkaByPokojId(Long id) {
        String sql = "SELECT * FROM PACIENTI_LUZKA_VIEW WHERE ID_POKOJ = ?";
        return jdbcTemplate.query(sql, new Object[]{id}, new PacientLuzkoMapper());

    }

    public PacientLuzko getLuzkoByPacId(Long id) {
        String sql = "SELECT * FROM PACIENTI_LUZKA_VIEW WHERE ID_PACIENT = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new PacientLuzkoMapper());
    }


    public PacientLuzko getByLuzkoId(Long id) {
        String sql = "SELECT * FROM PACIENTI_LUZKA_VIEW WHERE ID_LUZKO = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new PacientLuzkoMapper());

    }

    public void save(PacientLuzko luzko) {
        String sql = "CALL VLOZ_LUZKO(?,?)";
        jdbcTemplate.update(
                sql,
                luzko.getIdPokoj(),
                luzko.getCislo()
        );

    }

    public void releaseLuzko(Long id) {
        String sql = "CALL UVOLNI_LUZKO(?)";
        jdbcTemplate.update(sql, id);
    }


    public void rezervaceLuzka(Long luzkoId, Long pacientId, Date datumRezervace, Date datumPropusteni) {
        String sql = "CALL REZERVACE_LUZKA(?,?,?,?)";
        jdbcTemplate.update(sql, luzkoId, pacientId, datumRezervace, datumPropusteni);

    }

    public void delete(Long id) {
        String sql = "DELETE FROM LUZKA WHERE ID_LUZKO = ?";
        jdbcTemplate.update(sql, id);
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

    public int getAvailableBeds(Long oddelId) {
        return jdbcTemplate.queryForObject(
                "SELECT get_volna_luzka_pocet(?) FROM dual",
                new Object[]{oddelId},
                Integer.class
        );
    }

    /**
     * Vypocita prumernou dobu pobytu vsech pacientu na zadanem oddeleni v hodinach.
     *
     * @param oddeleniId ID oddeleni, pro ktere se ma prumerna doba pobytu vypocitat
     * @return Prumerna doba pobytu vsech pacientu na oddeleni v hodinach
     */
    public Double calculateAverageStayDuration(Integer oddeleniId) {
        StoredProcedure procedure = new StoredProcedure(jdbcTemplate.getDataSource(), "vypocitat_prumernou_dobu_pobytu") {
            {
                declareParameter(new SqlParameter("p_oddeleni_id", Types.INTEGER));
                declareParameter(new SqlOutParameter("p_average_duration", Types.DOUBLE));
                compile();
            }
        };

        Map<String, Object> inParameters = new HashMap<>();
        inParameters.put("p_oddeleni_id", oddeleniId);

        Map<String, Object> outParameters = procedure.execute(inParameters);

        Double averageDuration = (Double) outParameters.get("p_average_duration");
        return (averageDuration != null) ? averageDuration : 0.0;
    }
}
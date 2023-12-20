package com.clinicappbdas2.model.mapper;

import com.clinicappbdas2.model.views.PacientAnalyza;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PacientAnalyzaMapper implements RowMapper<PacientAnalyza> {
    @Override
    public PacientAnalyza mapRow(ResultSet rs, int rowNum) throws SQLException {
        PacientAnalyza pacient = new PacientAnalyza();
        pacient.setIdPacient(rs.getInt("ID_PACIENT"));
        pacient.setJmeno(rs.getString("JMENO"));
        pacient.setPrijmeni(rs.getString("PRIJMENI"));
        pacient.setPohlavi(rs.getString("POHLAVI"));
        pacient.setCisloTelefonu(rs.getLong("CISLO_TELEFONU"));

        pacient.setIdKarta(rs.getInt("ID_KARTA"));
        pacient.setIdAnalyza(rs.getInt("ID_ANALYZA"));

        pacient.setRbc(rs.getInt("RBC"));
        pacient.setWbc(rs.getInt("WBC"));
        pacient.setHgb(rs.getInt("HGB"));
        pacient.setPlt(rs.getInt("PLT"));
        pacient.setDatum(rs.getDate("DATUM"));

        return pacient;
    }
}

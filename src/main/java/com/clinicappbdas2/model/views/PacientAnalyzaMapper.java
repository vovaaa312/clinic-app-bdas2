package com.clinicappbdas2.model.views;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PacientAnalyzaMapper implements RowMapper<PacientiAnalyza> {
    @Override
    public PacientiAnalyza mapRow(ResultSet rs, int rowNum) throws SQLException {
        PacientiAnalyza pacient = new PacientiAnalyza();
        pacient.setIdPacient(rs.getInt("ID_PACIENT"));
        pacient.setJmeno(rs.getString("JMENO"));
        pacient.setPrijmeni(rs.getString("PRIJMENI"));
        pacient.setPohlavi(rs.getString("POHLAVI"));
        pacient.setIdKarta(rs.getInt("ID_KARTA"));
        pacient.setIdAnalyza(rs.getInt("ID_ANALYZA"));

        pacient.setRBC(rs.getInt("RBC"));
        pacient.setWBC(rs.getInt("WBC"));
        pacient.setHGB(rs.getInt("HGB"));
        pacient.setPLT(rs.getInt("PLT"));
        pacient.setDatum(rs.getDate("DATUM"));

        return pacient;
    }
}

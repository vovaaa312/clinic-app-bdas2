package com.clinicappbdas2.model.mapper;

import com.clinicappbdas2.model.views.NavstevaPacienta;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NavstevaPacientaMapper implements RowMapper<NavstevaPacienta> {
    @Override
    public NavstevaPacienta mapRow(ResultSet rs, int rowNum) throws SQLException {
        NavstevaPacienta navsteva = new NavstevaPacienta();
        navsteva.setIdNavsteva(rs.getInt("ID_NAVSTEVA"));
        navsteva.setDatum(rs.getDate("DATUM"));
        navsteva.setIdPacient(rs.getInt("ID_PACIENT"));
        navsteva.setIdZamestnanec(rs.getInt("ID_ZAMESTNANEC"));
        navsteva.setProblem(rs.getString("PROBLEM"));
        navsteva.setRekomendace(rs.getString("REKOMENDACE"));
        navsteva.setIdStatus(rs.getInt("ID_STATUS"));
        navsteva.setPacientJmeno(rs.getString("PACIENT_JMENO"));
        navsteva.setPacientPrijmeni(rs.getString("PACIENT_PRIJMENI"));
        navsteva.setCisloTelefonu(rs.getInt("CISLO_TELEFONU"));
        navsteva.setZamestnanecJmeno(rs.getString("ZAMESTNANEC_JMENO"));
        navsteva.setZamestnanecPrijmeni(rs.getString("ZAMESTNANEC_PRIJMENI"));
        navsteva.setStatus(rs.getString("STATUS"));
        return null;
    }
}

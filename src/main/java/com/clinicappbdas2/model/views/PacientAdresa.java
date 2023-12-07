package com.clinicappbdas2.model.views;

import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

@Data
public class PacientAdresa {
    private int idAdresa;
    private String jmeno;
    private String prijmeni;
    private Date datumHospitalizace;
    private Date datumNarozeni;
    private int cisloTelefonu;
    private String pohlavi;
    private String zeme;
    private String mesto;
    private String adresa;
    private int psc;

    public PacientAdresa getMapRow(ResultSet rs, int rowNum) throws SQLException {
        PacientAdresa pacientAdresa = new PacientAdresa();
        pacientAdresa.setIdAdresa(rs.getInt("ID_ADRESA"));
        pacientAdresa.setJmeno(rs.getString("JMENO"));
        pacientAdresa.setPrijmeni(rs.getString("PRIJMENI"));
        pacientAdresa.setDatumHospitalizace(rs.getDate("DATUM_HOSPITALIZACE"));
        pacientAdresa.setDatumNarozeni(rs.getDate("DATUM_NAROZENI"));
        pacientAdresa.setCisloTelefonu(rs.getInt("CISLO_TELEFONU"));
        pacientAdresa.setPohlavi(rs.getString("POHLAVI"));
        pacientAdresa.setZeme(rs.getString("ZEME"));
        pacientAdresa.setMesto(rs.getString("MESTO"));
        pacientAdresa.setAdresa(rs.getString("ADRESA"));
        pacientAdresa.setPsc(rs.getInt("PSC"));

        return pacientAdresa;


    }
}

package com.clinicappbdas2.model.mapper;

import com.clinicappbdas2.model.views.PokojeOddeleni;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PokojeOddeleniMapper implements RowMapper<PokojeOddeleni> {
    @Override
    public PokojeOddeleni mapRow(ResultSet rs, int rowNum) throws SQLException {
        PokojeOddeleni pokojeOddeleni = new PokojeOddeleni();
        pokojeOddeleni.setIdPokoj(rs.getInt("ID_POKOJ"));
        pokojeOddeleni.setPatro(rs.getInt("PATRO"));
        pokojeOddeleni.setCislo(rs.getInt("CISLO"));

        pokojeOddeleni.setIdOddeleni(rs.getInt("ID_ODDELENI"));
        pokojeOddeleni.setIdPokoj(rs.getInt("ID_POKOJ"));
        pokojeOddeleni.setNazevOddeleni(rs.getString("NAZEV_ODDELENI"));
        pokojeOddeleni.setPocetLuzek(rs.getInt("POCET_LUZEK"));



        return pokojeOddeleni;
    }
}

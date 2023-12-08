package com.clinicappbdas2.model.views;


import com.clinicappbdas2.model.Zamestnanec;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
public class ZamestnanecDataMapper implements RowMapper<ZamestnanecData>{
    @Override
    public ZamestnanecData mapRow(ResultSet rs, int rowNum) throws SQLException {
        ZamestnanecData zamestnanec = new ZamestnanecData();
        zamestnanec.setIdZamestnanec(rs.getInt("ID_ZAMESTNANEC"));
        zamestnanec.setJmeno(rs.getString("JMENO"));
        zamestnanec.setPrijmeni(rs.getString("PRIJMENI"));
        zamestnanec.setDatumNarozeni(rs.getDate("DATUM_NAROZENI"));
        zamestnanec.setCisloTelefonu(rs.getInt("CISLO_TELEFONU"));
        zamestnanec.setPracovniZkusenosti(rs.getInt("PRACOVNI_ZKUSENOSTI"));
        zamestnanec.setIdAdresa(rs.getInt("ID_ADRESA"));
        zamestnanec.setZeme(rs.getString("ZEME"));
        zamestnanec.setMesto(rs.getString("MESTO"));
        zamestnanec.setAdresa(rs.getString("ADRESA"));
        zamestnanec.setPsc(rs.getInt("PSC"));
        zamestnanec.setIdOddeleni(rs.getInt("ID_ODDELENI"));
        zamestnanec.setNazevOddeleni(rs.getString("NAZEV_ODDELENI"));
        return zamestnanec;
    }
}

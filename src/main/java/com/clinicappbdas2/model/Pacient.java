package com.clinicappbdas2.model;
import com.clinicappbdas2.model.security.User;
import lombok.Data;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigInteger;
import java.util.Date;

@Data
public class Pacient {
    private Integer idPacient;
    private Integer idAdresa;
    private String jmeno;
    private String prijmeni;
    private Date datumHospitalizace;
    private Date datumNarozeni;
    private Integer cisloTelefonu; // Используйте BigInteger если значения могут быть очень большими
    private String pohlavi;


    // Добавлен конструктор без аргументов
    public Pacient() {
    }

    public Pacient(Integer id_adresa, String jmeno, String prijmeni, Date datumHospitalizace, Date datumNarozeni, Integer cisloTelefonu, String pohlavi) {
        this.idAdresa = id_adresa;
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.datumHospitalizace = datumHospitalizace;
        this.datumNarozeni = datumNarozeni;
        this.cisloTelefonu = cisloTelefonu;
        this.pohlavi = pohlavi;
    }

    public static RowMapper<Pacient> getUserMapper() {
        return (rs, rowNum) -> {
            Pacient pacient = new Pacient();
            pacient.setIdPacient(rs.getInt("ID_PACIENT"));
            pacient.setIdAdresa(rs.getInt("ID_ADRESA"));
            pacient.setJmeno(rs.getString("JMENO"));
            pacient.setPrijmeni(rs.getString("PRIJMENI"));
            pacient.setPohlavi(rs.getString("POHLAVI"));
            pacient.setDatumHospitalizace(rs.getDate("DATUM_HOSPITALIZACE"));
            pacient.setDatumNarozeni(rs.getDate("DATUM_NAROZENI"));

            return pacient;
        };
    }
}

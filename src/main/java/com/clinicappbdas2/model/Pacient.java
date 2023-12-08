package com.clinicappbdas2.model;
import lombok.Data;
import java.math.BigInteger;
import java.util.Date;

@Data
public class                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            Pacient {
    private BigInteger idPacient;
    private BigInteger adresyIdAdresa;
    private String jmeno;
    private String prijmeni;
    private Date datumHospitalizace;
    private Date datumNarozeni;
    private BigInteger cisloTelefonu; // Используйте BigInteger если значения могут быть очень большими
    private String pohlavi;


    // Добавлен конструктор без аргументов
    public Pacient() {
    }

    public Pacient(BigInteger id_adresa, String jmeno, String prijmeni, Date datumHospitalizace, Date datumNarozeni, BigInteger cisloTelefonu, String pohlavi) {
        this.adresyIdAdresa = id_adresa;
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.datumHospitalizace = datumHospitalizace;
        this.datumNarozeni = datumNarozeni;
        this.cisloTelefonu = cisloTelefonu;
        this.pohlavi = pohlavi;
    }
}

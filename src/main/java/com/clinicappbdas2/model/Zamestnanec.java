package com.clinicappbdas2.model;
import lombok.*;

import java.util.Date;

@Data
public class Zamestnanec {
    int idZamestnanec;
    int idAdresa;
    String jmeno;
    String prijmeni;
    Date datumNarozeni;
    int cisloTelefonu;
    int pracovniZkusenosti;
    int idOddeleni;

    public Zamestnanec(){}

    public Zamestnanec(int idZamestnanec, int idAdresa, String jmeno, String prijmeni, Date datumNarozeni, int cisloTelefonu, int pracovniZkusenosti, int idOddeleni) {
        this.idZamestnanec = idZamestnanec;
        this.idAdresa = idAdresa;
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.datumNarozeni = datumNarozeni;
        this.cisloTelefonu = cisloTelefonu;
        this.pracovniZkusenosti = pracovniZkusenosti;
        this.idOddeleni = idOddeleni;
    }


}

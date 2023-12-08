package com.clinicappbdas2.model.views;

import lombok.Data;

import java.util.Date;

@Data
public class ZamestnanecData {
    private Integer idZamestnanec;
    private String jmeno;
    private String prijmeni;
    private Date datumNarozeni;
    private Integer cisloTelefonu;
    private Integer pracovniZkusenosti;
    private Integer idAdresa;
    private String zeme;
    private String mesto;
    private String adresa;
    private Integer psc;
    private Integer idOddeleni;
    private String nazevOddeleni;


}

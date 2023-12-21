package com.clinicappbdas2.model.views;

import lombok.Data;

import java.util.Date;

@Data
public class ZamestnanecData {
    private Long idZamestnanec;
    private String jmeno;
    private String prijmeni;
    private Date datumNarozeni;
    private Long cisloTelefonu;
    private Long pracovniZkusenosti;
    private String pohlavi;
    private Long idAdresa;
    private String zeme;
    private String mesto;
    private String adresa;
    private Long psc;
    private Integer idOddeleni;
    private String nazevOddeleni;


}

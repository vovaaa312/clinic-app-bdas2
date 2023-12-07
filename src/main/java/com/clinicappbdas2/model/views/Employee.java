package com.clinicappbdas2.model.views;

import java.util.Date;
import lombok.Data;

@Data
public class Employee {
    private int id;
    private String jmeno;
    private String prijmeni;
    private Date datumNarozeni;
    private int cisloTelefonu;
    private int pracovniZkusenosti;
    private int idAdresa;
    private int psc;
    private String adresa;
    private String mesto;
    private String zeme;
}

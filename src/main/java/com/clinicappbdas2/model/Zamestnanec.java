package com.clinicappbdas2.model;
import lombok.*;

import java.util.Date;

@Value
public class Zamestnanec {
    int idZamestnanec;
    int idAdresa;
    String jmeno;
    String prijmeni;
    Date datumNarozeni;
    int cisloTelefonu;
    int pracovniZkusenosti;
    int idOddeleni;
}

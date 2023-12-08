package com.clinicappbdas2.model;

import lombok.Data;

@Data
public class Oddeleni {
    private Integer idOddeleni;
    private String nazevOddeleni;

    public Oddeleni(){}

    public Oddeleni(Integer idOddeleni, String nazevOddeleni) {
        this.idOddeleni = idOddeleni;
        this.nazevOddeleni = nazevOddeleni;
    }


}

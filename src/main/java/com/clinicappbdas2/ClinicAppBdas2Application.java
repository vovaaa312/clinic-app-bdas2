package com.clinicappbdas2;

import com.clinicappbdas2.service.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClinicAppBdas2Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ClinicAppBdas2Application.class, args);
    }

    @Autowired
    PacientAnalyzaRepository repo;
    @Override
    public void run(String... args) throws Exception {
        System.out.println(repo.getAllAnalysis());
    }
}

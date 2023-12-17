package com.clinicappbdas2;


import com.clinicappbdas2.service.StatusNavstevyService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class ClinicAppBdas2Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ClinicAppBdas2Application.class, args);
    }

    final StatusNavstevyService repo;
    @Override
    public void run(String... args) throws Exception {
        System.out.println(repo.getAll());
    }
}

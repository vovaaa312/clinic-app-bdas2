package com.clinicappbdas2;

import com.clinicappbdas2.service.repository.OddeleniRepository;
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

    final OddeleniRepository repository;
    @Override
    public void run(String... args) throws Exception {


        //System.out.println(repository.calculateAverageStayDuration(70000));
    }
}

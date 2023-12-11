package com.clinicappbdas2;

import com.clinicappbdas2.model.views.PacientAnalyza;
import com.clinicappbdas2.service.UserService;
import com.clinicappbdas2.service.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ClinicAppBdas2Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ClinicAppBdas2Application.class, args);
    }
//
//    @Autowired
//    UserRepository  repo;
    @Override
    public void run(String... args) throws Exception {
//        repo.setPacientUser(80384,180024);

    }
}

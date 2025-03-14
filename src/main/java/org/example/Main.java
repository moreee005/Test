package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement  // Memastikan transaksi diaktifkan
@EnableJpaRepositories(basePackages = "org.example.repository") // Menambahkan base package untuk repository

public class Main {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Main.class, args);
        System.out.println("Hello world!");
    }
}

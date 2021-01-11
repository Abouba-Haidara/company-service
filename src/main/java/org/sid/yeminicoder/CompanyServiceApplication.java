package org.sid.yeminicoder;

import org.sid.yeminicoder.entities.Company;
import org.sid.yeminicoder.repositories.CompanyRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class CompanyServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompanyServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner star(CompanyRepository companyRepository) {
        return  args -> {
            Stream.of("Bank BAO", "BCEAO", "UBA", "ECO BANK").forEach(c-> {
                companyRepository.save(new Company(null, c, "",100 + Math.random() * 900));
            });
            companyRepository.findAll().forEach(System.out::println);
        };
    }
}

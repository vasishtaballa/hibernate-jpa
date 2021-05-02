package dev.vasishta.jpa.hibernate;

import dev.vasishta.jpa.hibernate.repository.CourseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class HibernateJpaApplication implements CommandLineRunner {

    @Autowired
    private CourseRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(HibernateJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repository.playWithEntityManager();
    }
}

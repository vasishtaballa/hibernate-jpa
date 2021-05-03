package dev.vasishta.jpa.hibernate;

import dev.vasishta.jpa.hibernate.entity.FullTimeEmployee;
import dev.vasishta.jpa.hibernate.entity.PartTimeEmployee;
import dev.vasishta.jpa.hibernate.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@Slf4j
@SpringBootApplication
public class HibernateJpaApplication implements CommandLineRunner {

    @Autowired
    private EmployeeRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(HibernateJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // repository.saveStudentWithPassport();
        // List<Review> reviews = new ArrayList<>();
        // reviews.add(new Review("FIVE", "Great! Hats-off stuff"));
        // reviews.add(new Review("THREE", "Average content"));
        // repository.addReviewsForCourse(10003L, reviews);
        // repository.insertStudentAndCourse();
        repository.insertEmployee(new FullTimeEmployee("Jack", new BigDecimal(10000)));
        repository.insertEmployee(new PartTimeEmployee("Jill", new BigDecimal(50)));
        log.info("FullTime employees: {}", repository.getAllFullTimeEmployees());
        log.info("PartTime employees: {}", repository.getAllPartTimeEmployees());
    }
}

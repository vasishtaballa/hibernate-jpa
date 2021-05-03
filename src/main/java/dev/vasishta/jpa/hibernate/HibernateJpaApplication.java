package dev.vasishta.jpa.hibernate;

import dev.vasishta.jpa.hibernate.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class HibernateJpaApplication implements CommandLineRunner {

    @Autowired
    private StudentRepository repository;

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
        repository.insertStudentAndCourse();
    }
}

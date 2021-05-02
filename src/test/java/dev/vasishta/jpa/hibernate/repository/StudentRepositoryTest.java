package dev.vasishta.jpa.hibernate.repository;

import dev.vasishta.jpa.hibernate.HibernateJpaApplication;
import dev.vasishta.jpa.hibernate.entity.Passport;
import dev.vasishta.jpa.hibernate.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HibernateJpaApplication.class)
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository repository;

    @Autowired
    private EntityManager em;

    @Test
    @Transactional
    public void getStudentAndPassportDetails() {
        Student student = em.find(Student.class, 20001L);
        log.info("Student with id 20001 -> {}", student);
        log.info("Passport of the student is -> {}", student.getPassport());
    }

    @Test
    @Transactional
    public void getPassportAndAssociatedStudent() {
        Passport passport = em.find(Passport.class, 40001L);
        log.info("Passport with id 40001 -> {}", passport);
        log.info("Student of the corresponding passport is -> {}", passport.getStudent());
    }

}

package dev.vasishta.jpa.hibernate.repository;

import dev.vasishta.jpa.hibernate.entity.Passport;
import dev.vasishta.jpa.hibernate.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
@Slf4j
public class StudentRepository {

    @PersistenceContext
    private EntityManager em;

    public Student findById(Long id) {
        return em.find(Student.class, id);
    }

    public void deleteById(Long id) {
        Student student = findById(id);
        em.remove(student);
    }

    public Student save(Student student) {
        if (student.getId() == null) {
            // insert
            em.persist(student);
        } else {
            // update
            em.merge(student);
        }
        return student;
    }

    public void saveStudentWithPassport() {
        Passport passport = new Passport("Z123456");
        em.persist(passport);

        Student student = new Student("Mike");

        student.setPassport(passport);
        em.persist(student);
    }
}

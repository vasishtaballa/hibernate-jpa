package dev.vasishta.jpa.hibernate.repository;

import dev.vasishta.jpa.hibernate.entity.Course;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
@Slf4j
public class CourseRepository {

    @PersistenceContext
    private EntityManager em;

    public Course findById(Long id) {
        return em.find(Course.class, id);
    }

    public void deleteById(Long id) {
        Course course = findById(id);
        em.remove(course);
    }

    public Course save(Course course) {
        if (course.getId() == null) {
            // insert
            em.persist(course);
        } else {
            // update
            em.merge(course);
        }
        return course;
    }

    public void playWithEntityManager() {
        Course course1 = new Course("Web services in 100 steps");
        em.persist(course1);
        Course course2 = findById(10002L);
        course2.setName("Course 2 renamed");
    }
}

package dev.vasishta.jpa.hibernate.repository;

import dev.vasishta.jpa.hibernate.HibernateJpaApplication;
import dev.vasishta.jpa.hibernate.entity.Course;
import dev.vasishta.jpa.hibernate.repository.CourseRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HibernateJpaApplication.class)
public class CourseRepositoryTest {

    @Autowired
    private CourseRepository repository;

    @Test
    public void testFindById() {
        Assert.assertEquals("JPA in 50 steps", repository.findById(10001L).getName());
    }

    @Test
    @DirtiesContext
    public void testDeleteById() {
        repository.deleteById(10001L);
        Assert.assertNull(repository.findById(10001L));
    }

    @Test
    @DirtiesContext
    public void testSaveCourse() {
        Course course = repository.findById(10001L);
        Assert.assertEquals("JPA in 50 steps", course.getName());
        course.setName("JPA in 50 steps - Updated");
        repository.save(course);
        course = repository.findById(10001L);
        Assert.assertEquals("JPA in 50 steps - Updated", course.getName());
    }

    @Test
    public void testPlayWithEm() {
        repository.playWithEntityManager();
    }

}
package dev.vasishta.jpa.hibernate.repository;

import dev.vasishta.jpa.hibernate.HibernateJpaApplication;
import dev.vasishta.jpa.hibernate.entity.Course;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HibernateJpaApplication.class)
public class JPQLTest {

    @Autowired
    private EntityManager em;

    @Test
    public void testJpqlBasic() {
        List resultList = em.createQuery("Select c From Course c").getResultList();
        log.info("Select c From Course c -> {}", resultList);
    }

    @Test
    public void testJpql_Typed() {
        TypedQuery<Course> typedQuery = em.createQuery("Select c From Course c", Course.class);
        log.info("Select c From Course c -> {}", typedQuery.getResultList());
    }

    @Test
    public void testJpql_Where() {
        TypedQuery<Course> typedQuery = em.createQuery("Select c From Course c where name like '%100%'", Course.class);
        log.info("Select c From Course c where name like %100% -> {}", typedQuery.getResultList());
    }

    @Test
    public void testJpql_Named() {
        Query namedQuery = em.createNamedQuery("get_all_courses");
        log.info("namedQuery: get_all_courses -> {}", namedQuery.getResultList());
    }

    @Test
    public void testJpql_NamedQueries() {
        Query namedQuery1 = em.createNamedQuery("get_100_step_courses");
        log.info("namedQuery: get_100_step_courses -> {}", namedQuery1.getResultList());
        Query namedQuery2 = em.createNamedQuery("get_50_step_courses");
        log.info("namedQuery: get_50_step_courses -> {}", namedQuery2.getResultList());
    }
}
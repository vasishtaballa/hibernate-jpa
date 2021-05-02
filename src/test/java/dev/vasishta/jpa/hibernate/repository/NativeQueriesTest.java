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

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HibernateJpaApplication.class)
public class NativeQueriesTest {

    @Autowired
    private EntityManager em;

    @Test
    public void testNativeQuery() {
        Query nativeQuery = em.createNativeQuery("select * from course", Course.class);
        log.info("nativeQuery -> {}", nativeQuery.getResultList());
    }

    @Test
    public void testNativeQuery_Where() {
        Query nativeQuery = em.createNativeQuery("select * from course where name like ?", Course.class);
        nativeQuery.setParameter(1, "%100%");
        log.info("nativeQueryWhere -> {}", nativeQuery.getResultList());
    }

    @Test
    public void testNativeQuery_Named_Parameter() {
        Query nativeQuery = em.createNativeQuery("select * from course where name like :name", Course.class);
        nativeQuery.setParameter("name", "%100%");
        log.info("nativeQueryWhere -> {}", nativeQuery.getResultList());
    }

}

package dev.vasishta.jpa.hibernate.repository;

import dev.vasishta.jpa.hibernate.entity.Employee;
import dev.vasishta.jpa.hibernate.entity.FullTimeEmployee;
import dev.vasishta.jpa.hibernate.entity.PartTimeEmployee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@Slf4j
public class EmployeeRepository {

    @Autowired
    private EntityManager em;

    public void insertEmployee(Employee employee) {
        em.persist(employee);
    }

    public List<PartTimeEmployee> getAllPartTimeEmployees() {
        return em.createQuery("select e from PartTimeEmployee e").getResultList();
    }

    public List<FullTimeEmployee> getAllFullTimeEmployees() {
        return em.createQuery("select e from FullTimeEmployee e").getResultList();
    }

}

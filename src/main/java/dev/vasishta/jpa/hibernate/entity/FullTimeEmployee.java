package dev.vasishta.jpa.hibernate.entity;

import lombok.Getter;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Getter
public class FullTimeEmployee extends Employee {

    private BigDecimal salary;

    protected FullTimeEmployee() {

    }

    public FullTimeEmployee(String name, BigDecimal salary) {
        super(name);
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "FullTimeEmployee{" +
                "name=" + getName() +
                "salary=" + salary +
                '}';
    }
}

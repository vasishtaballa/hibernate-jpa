package dev.vasishta.jpa.hibernate.entity;

import lombok.Getter;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Getter
public class PartTimeEmployee extends Employee {

    private BigDecimal hourlyWage;

    protected PartTimeEmployee() {

    }

    public PartTimeEmployee(String name, BigDecimal hourlyWage) {
        super(name);
        this.hourlyWage = hourlyWage;
    }

    @Override
    public String toString() {
        return "PartTimeEmployee{" +
                "name=" + getName() +
                "hourlyWage=" + hourlyWage +
                '}';
    }
}

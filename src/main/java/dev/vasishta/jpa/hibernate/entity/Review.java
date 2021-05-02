package dev.vasishta.jpa.hibernate.entity;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@ToString
public class Review {

    @Id
    @GeneratedValue
    private Long id;

    private String rating;

    @Column(nullable = false)
    private String description;

    protected Review() {
    }

    public Review(String rating, String description) {
        this.rating = rating;
        this.description = description;
    }

    public void setRating(String rating) {

        this.rating = rating;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

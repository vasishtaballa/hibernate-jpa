package dev.vasishta.jpa.hibernate.entity;

import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "Course")
@NamedQuery(name = "get_all_courses", query = "Select c from Course c")
@NamedQueries(value = {
        @NamedQuery(name = "get_100_step_courses", query = "Select c from Course c where name like '%100%'"),
        @NamedQuery(name = "get_50_step_courses", query = "Select c from Course c where name like '%50%'"),
        @NamedQuery(name = "get_0_courses", query = "Select c from Course c where name like '%0 steps'")
})
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @CreationTimestamp
    private LocalDateTime createdDate;

    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;

    @OneToMany(mappedBy = "course")
    private List<Review> reviews;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students = new ArrayList<>();

    protected Course() {
    }

    public Course(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean addReview(Review review) {
        return this.reviews.add(review);
    }

    public boolean removeReview(Review review) {
        return this.reviews.remove(review);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdDate=" + createdDate +
                ", lastUpdatedDate=" + lastUpdatedDate +
                '}';
    }

    public boolean addStudent(Student student) {
        return this.students.add(student);
    }
}

package com.example.demo.student;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

@Entity(name = "Student")
@Table(
        name = "student",
        uniqueConstraints = {
                @UniqueConstraint(name = "student_unique_email", columnNames = "email")
        }
)
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@EqualsAndHashCode
public class Student implements Serializable {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )

    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;

    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT",
            unique = true
    )
    private String email;
    private LocalDate dob;
    @Transient
    private Integer age;
    private String imageUrl;
    private String phone;

    public Student(String name, String email, LocalDate dob, String imageUrl, String phone) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.imageUrl = imageUrl;
        this.age = Period.between(this.dob, LocalDate.now()).getYears();
        this.phone = phone;
    }

}

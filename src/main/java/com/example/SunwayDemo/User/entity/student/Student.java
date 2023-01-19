package com.example.SunwayDemo.User.entity.student;

import com.example.SunwayDemo.User.entity.faculty.Faculty;
import lombok.*;

import javax.persistence.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name = "students", uniqueConstraints = {
        @UniqueConstraint(
                name = "UNIQUE_STUDENT_ROLLNUM",
                columnNames = {
                        "rollNum"
                })})
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String phoneNo;
    private String rollNum;

    private  String batch;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "faculty_id", foreignKey = @ForeignKey(name = "FK_STUDENT_FACULTY"))
    private Faculty faculty;

    public Student(Integer id) {
        this.id = id;
    }
}

package org.students.model;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(name = "Student id")
    private Long id;

    @Schema(name = "First name")
    private String firstName;

    @Schema(name = "Last name")
    private String lastName;

    @Schema(name = "List of grades")
    @OneToMany(orphanRemoval = true, mappedBy = "grade", fetch = FetchType.LAZY)
//    @ToString.Exclude
    private List<StudentGrade> grades;

    @ManyToOne(optional = false)
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private StudentGroup group;

}

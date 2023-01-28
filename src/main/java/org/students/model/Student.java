package org.students.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String FirstName;

    private String lastName;

    @OneToMany(orphanRemoval = true, mappedBy = "grade", fetch = FetchType.LAZY)
//    @ToString.Exclude
    private List<StudentGrade> grades;


}

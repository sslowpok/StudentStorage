package org.students.model;

import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Data
@Entity
@Where(clause = "deleted=false")
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private boolean deleted;

//    @Schema(name = "List of grades")
//    @OneToMany(orphanRemoval = true, mappedBy = "grade", fetch = FetchType.LAZY)
////    @ToString.Exclude
//    private List<StudentGrade> grades;
//
//    @ManyToOne(optional = false)
//    @JoinColumn(name = "group_id", referencedColumnName = "id")
//    private StudentGroup group;

}

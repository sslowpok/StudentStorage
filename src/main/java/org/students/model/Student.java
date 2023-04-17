package org.students.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Data
@Entity
@Table(name = "student")
@Where(clause = "deleted=false")
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
    @ManyToOne(optional = false)
    @JsonBackReference
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private StudentGroup group;

}

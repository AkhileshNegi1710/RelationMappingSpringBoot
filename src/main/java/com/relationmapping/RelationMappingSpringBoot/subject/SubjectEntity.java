package com.relationmapping.RelationMappingSpringBoot.subject;

import com.relationmapping.RelationMappingSpringBoot.student.StudentEntity;
import com.relationmapping.RelationMappingSpringBoot.teacher.TeacherEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//ong is a primitive type, while Long is a Java class (and so it will inherit Object).
//long must be assigned with a valid number, while Long can be null
//long instances can't use the benefits of OO, while instances of Long are real Java objects
//Long is a serializable so it will be very useful when doing file, database or network IO
//long is more efficient than Long considering memory space and processing speed
//If you are doing heavy calculations, use primitive types. Otherwise if you're concerning more about design, the object counter parts will be very useful.

@Getter
@Setter
@Entity
@Table(name="subjects")
public class SubjectEntity {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
Long id;
private String subject;



//using studententity inside Subject Entity
@ManyToMany

//We are creating new Table with two columns and storing ids of both after mapping subject id with student id
@JoinTable(name="student_enrolled", joinColumns = @JoinColumn(name="subject_id"), inverseJoinColumns = @JoinColumn(name="student_id"))
//HashSet Implements SET interface and has only single null value with add() operation
private Set<StudentEntity> enrolledStudent=new HashSet<>();



    //    Many represent the current class and one is the object
@ManyToOne(cascade = CascadeType.ALL)
//referencedColumnName will use teacher id
@JoinColumn(name="teacher_id",referencedColumnName = "id")
private TeacherEntity teacherEntity;



public void enrolledStudentEntity(StudentEntity newStudentEntity) {
    enrolledStudent.add(newStudentEntity);
    }


    public void addTeachertoSubjectEntity(TeacherEntity newTeacherEntity) {
        this.teacherEntity=teacherEntity;
    }
}

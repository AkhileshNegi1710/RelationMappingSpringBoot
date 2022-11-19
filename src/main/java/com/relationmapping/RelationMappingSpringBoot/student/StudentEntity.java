package com.relationmapping.RelationMappingSpringBoot.student;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.relationmapping.RelationMappingSpringBoot.subject.SubjectEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="student")
public class StudentEntity {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
Long id;
private String name;
//enrolledStudent object will go directly to SubjectEntity object of Set Interface in SubjectEntity class
//    @JsonIgnore will ignore the recursive problem
    @JsonIgnore
    //    Many represent the current class and Many is the object
    @ManyToMany(mappedBy = "enrolledStudent")
    private Set<SubjectEntity> newSubject=new HashSet<>();


}

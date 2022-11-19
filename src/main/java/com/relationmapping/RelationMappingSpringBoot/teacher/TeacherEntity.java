package com.relationmapping.RelationMappingSpringBoot.teacher;

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
@Table(name="Teachers")
public class TeacherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    private String teacherName;


    @JsonIgnore
//    One represent the current class and Many is the object
    @OneToMany(mappedBy = "teacherEntity")
    private Set<SubjectEntity> subjectEntitySet=new HashSet<>();

}

package com.relationmapping.RelationMappingSpringBoot.subject;

import com.relationmapping.RelationMappingSpringBoot.student.StudentEntity;
import com.relationmapping.RelationMappingSpringBoot.student.StudentRepository;
import com.relationmapping.RelationMappingSpringBoot.teacher.TeacherEntity;
import com.relationmapping.RelationMappingSpringBoot.teacher.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//long is a primitive type, while Long is a Java class (and so it will inherit Object).
//long must be assigned with a valid number, while Long can be null
//long instances can't use the benefits of OO, while instances of Long are real Java objects
//Long is a serializable so it will be very useful when doing file, database or network IO
//long is more efficient than Long considering memory space and processing speed
//If you are doing heavy calculations, use primitive types. Otherwise if you're concerning more about design, the object counter parts will be very useful.

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    SubjectRepository subjectRepository;
//if two repository is used , Use Service class but for simplicity we are using directly using studentRepository
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TeacherRepository teacherRepository;
//get all subjects
    @GetMapping
    public List<SubjectEntity> getAllSubject()
    {
        return subjectRepository.findAll();

    }

//    create new subject name
    @PostMapping("/addsubject")
    public SubjectEntity createNewSubject(@RequestBody SubjectEntity subjectEntity)
    {
        return subjectRepository.save(subjectEntity);

    }
//enrolling student to the particular subject
    @PutMapping("/{subjectId}/students/{studentId}")
    public SubjectEntity enrolledStudenttoSubject(
            @PathVariable Long subjectId,
            @PathVariable Long studentId)
    {
//        getOne() method avoids database roundtrip from the JVM as it never hits the database
        SubjectEntity newSubjectEntity= subjectRepository.findById(subjectId).get();
        StudentEntity newStudentEntity=studentRepository.findById(studentId).get();

//        adding student in the subject json
        newSubjectEntity.enrolledStudentEntity(newStudentEntity);
//saving  subject and student json
        return subjectRepository.save(newSubjectEntity);
    }





    //adding subject to the particular teacher
    @PutMapping("/{subjectId}/teacher/{teacherId}")
    public SubjectEntity addTeachertoSubject(
            @PathVariable Long subjectId,
            @PathVariable Long teacherId)
    {
//        getOne() method avoids database roundtrip from the JVM as it never hits the database
        SubjectEntity newSubjectEntity= subjectRepository.findById(subjectId).get();
        TeacherEntity newTeacherEntity =teacherRepository.findById(teacherId).get();

//        adding student in the subject json
        newSubjectEntity.addTeachertoSubjectEntity(newTeacherEntity);
//saving  subject and student json
        return subjectRepository.save(newSubjectEntity);
    }


}

package com.relationmapping.RelationMappingSpringBoot.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

//long is a primitive type, while Long is a Java class (and so it will inherit Object).
//long must be assigned with a valid number, while Long can be null
//long instances can't use the benefits of OO, while instances of Long are real Java objects
//Long is a serializable so it will be very useful when doing file, database or network IO
//long is more efficient than Long considering memory space and processing speed
//If you are doing heavy calculations, use primitive types. Otherwise if you're concerning more about design, the object counter parts will be very useful.

    @Autowired
    TeacherRepository teacherRepository;

//    get all teachers
    @GetMapping
    public List<TeacherEntity> getAllTeachers()
    {
        return teacherRepository.findAll();

    }


//    Add new teacher
    @PostMapping("/addTeacher")
    public TeacherEntity addTeacher(@RequestBody TeacherEntity teacherEntity)
    {
        return teacherRepository.save(teacherEntity);

    }
}

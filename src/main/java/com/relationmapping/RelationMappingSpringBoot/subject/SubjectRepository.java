package com.relationmapping.RelationMappingSpringBoot.subject;

import com.relationmapping.RelationMappingSpringBoot.student.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<SubjectEntity, Long> {
}

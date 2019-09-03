package com.tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutorial.model.Subject;

@Repository("subjectRepository")
public interface SubjectRepository extends JpaRepository<Subject, Long> {

}

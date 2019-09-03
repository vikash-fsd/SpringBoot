package com.tutorial.service;

import java.util.List;


import com.tutorial.model.Subject;

public interface SubjectService {

	Subject findByID(long subjectid);
	
	void save(Subject subject);
	
	List<Subject> list();
	
	void delete(long subjectid);

}

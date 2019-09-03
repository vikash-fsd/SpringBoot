package com.tutorial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tutorial.model.Subject;
import com.tutorial.repository.SubjectRepository;

@Service
public class SubjectServiceImpl implements SubjectService{

	@Autowired
	private SubjectRepository subjectRepo;
	
	@Transactional
	public Subject findByID(long subjectid){
		return subjectRepo.getOne(subjectid);
	}
		 
	@Transactional
	public void save(Subject subject) {
		subjectRepo.save(subject);
	}
	 
	@Transactional(readOnly = true)
	public List<Subject> list() {
		return subjectRepo.findAll();
	}
	
	@Transactional
	public void delete(long subjectid) {
		subjectRepo.deleteById(subjectid);
	}

}

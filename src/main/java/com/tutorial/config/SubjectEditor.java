package com.tutorial.config;

import java.beans.PropertyEditorSupport;

import org.springframework.stereotype.Component;

import com.tutorial.model.Subject;
import com.tutorial.service.SubjectService;

@Component
public class SubjectEditor extends PropertyEditorSupport{
	// Do not use @Autowired.
    // Use dependency injection in class constructor.
    private final SubjectService subjectService;
     
    public SubjectEditor() {
        this.subjectService = null;
    }
     
    //This constructor will be used to inject the subjectService.
    public SubjectEditor(SubjectService subjectService) {
        this.subjectService = subjectService;
    }
     
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        // Find a Subject by its subjectId from text
        if(text!=null && text!="") {
        	try {
        		Subject subject = subjectService.findByID(Long.parseLong(text));
        		setValue(subject);
        	}catch(Exception e)
        	{
        		e.printStackTrace();
        	}
        }
    }   

}

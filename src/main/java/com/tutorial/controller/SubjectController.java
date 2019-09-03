package com.tutorial.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tutorial.model.Subject;
import com.tutorial.service.SubjectService;

@Controller
public class SubjectController {
	 
    @Autowired
    private SubjectService subjectService;
 
    @GetMapping("/Subject")
    public String subjectForm(Locale locale, Model model) {
        model.addAttribute("subjects", subjectService.list());
        return "Subject";
    }
    
    @PostMapping("/searchSubject")
    public String searchBook(Subject subject,
            BindingResult result, Model model) {
        try {
        	model.addAttribute("subjects", subjectService.findByID(subject.getSubjectid()));
        }catch(Exception e) {
        	e.printStackTrace();
        }
        return "Subject";
    }
    
    @GetMapping("/deleteSubject")
    public String deleteSubject(@RequestParam("subjectid")long subjectid) {
    	subjectService.delete(subjectid);
        return "redirect:/Subject";
    }
     
    @ModelAttribute("subject")
    public Subject formBackingObject() {
        return new Subject();
    }
    
    @GetMapping("/addSubject")
    public String addSubject(Model model) {
    	Subject subject = new Subject();
    	model.addAttribute("subject", subject);
    	return "addSubject";
    }
 
    @PostMapping("/saveSubject")
    public String saveSubject(@ModelAttribute("subject") @Valid Subject subject,
                            BindingResult result, Model model) {
 
        if (result.hasErrors()) {
            return "addSubject";
        }
 
        subjectService.save(subject);
        return "redirect:/Subject";
    }
}

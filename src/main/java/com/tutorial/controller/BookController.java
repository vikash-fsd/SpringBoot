package com.tutorial.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tutorial.config.SubjectEditor;
import com.tutorial.model.Book;
import com.tutorial.model.Subject;
import com.tutorial.service.BookService;
import com.tutorial.service.SubjectService;

@Controller
public class BookController {
	 
    @Autowired
    private BookService bookService;
    
    @Autowired
    private SubjectService subjectService;
    
    // Registering SubjectEditor class.
    // If you need any other editor class declaration, you can register inside this method.
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Subject.class, new SubjectEditor(subjectService));
    }
    
    @GetMapping("/Book")
    public String bookForm(Locale locale, Model model) {
    	model.addAttribute("books", bookService.list());
        return "Book";
    }
    
    @PostMapping("/searchBook")
    public String searchBook(Book book,
            BindingResult result, Model model) {
        try {
        	model.addAttribute("books", bookService.findByID(book.getBookid()));
        }catch(Exception e) {
        	e.printStackTrace();
        }
        return "Book";
    }
    
    @GetMapping("/deleteBook")
    public String deleteBook(@RequestParam("bookid")long bookid) {
        bookService.delete(bookid);
        return "redirect:/Book";
    }
     
    @ModelAttribute("book")
    public Book formBackingObject() {
        return new Book();
    }
    
    @GetMapping("/addBook")
    public String addBook(Model model) {
    	Book book = new Book();
    	model.addAttribute("book", book);
    	model.addAttribute("subjects", subjectService.list());
        return "addBook";
    }
 
    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("book") @Valid Book book,
                            BindingResult result, Model model) {
    	if (result.hasErrors()) {
    		return "addBook";
        }
 
        bookService.save(book);
        return "redirect:/Book";
    }
}

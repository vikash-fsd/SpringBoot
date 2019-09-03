package com.tutorial.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.Set;

@Entity
@Table(name = "Subject")
public class Subject {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "subjectid")
	long subjectid;
	
	@Column(name = "subtitle")
	String subtitle;
	
	@Column(name = "duration_in_hours")
	int duration_in_hours;
	
	@OneToMany(mappedBy="subject")
	Set<Book> books;


	public long getSubjectid() {
		return subjectid;
	}

	public void setSubjectid(long subjectid) {
		this.subjectid = subjectid;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public int getDuration_in_hours() {
		return duration_in_hours;
	}

	public void setDuration_in_hours(int duration_in_hours) {
		this.duration_in_hours = duration_in_hours;
	}
	
	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	
}

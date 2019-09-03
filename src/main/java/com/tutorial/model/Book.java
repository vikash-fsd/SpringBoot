package com.tutorial.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Book")
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "bookid")
	long bookid;
	
	@Column(name = "title")
	String title;
	
	@Column(name = "price")
	double price;
	
	@Column(name = "volume")
	int volume;
	
	@Column(name = "published_date")
	Date published_date;

	@ManyToOne
	@JoinColumn(name="fk_subjectid", nullable=false)
	private Subject subject;


	public long getBookid() {
		return bookid;
	}

	public void setBookid(long bookid) {
		this.bookid = bookid;
	}

	public String getTitle()

	{
		return title;
	}

	public void setTitle(String title)

	{
		this.title = title;
	}

	public double getPrice()

	{
		return price;
	}

	public void setPrice(double price)

	{
		this.price = price;
	}

	public int getVolume()

	{
		return volume;
	}

	public void setVolume(int volume)

	{
		this.volume = volume;
	}

	public Date getPublished_date() {
		return published_date;
	}

	public void setPublished_date(Date published_date) {
		this.published_date = published_date;
	}
	
	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
	@Override
    public String toString() {
        return "Book [bookid=" + bookid + ", title=" + title + ", price=" + price + ", volume=" + volume + ", published_date=" + published_date + ", subject=" + subject + "]";
    }

}

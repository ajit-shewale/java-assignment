package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="library_table",catalog="library_schema")
class Book {
	@Id
	@Column(name="Book_Id")
	private int id;
	@Column(name="Title")
	private String title;
	@Column(name="Author")
	private String author;
	@Column(name="Cost")
	private double price;
	@Column(name="Quantity")
	private int quantity;

	public Book() {
		super();
//		id = 0;
//		title = null;
//		author = null;
//		price = 0;
//		quantity = 0;
	}

	public Book(int id, String title, String author, double price, int quantity) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", price=" + price + ", quantity="
				+ quantity + "]";
	}
	
}


package com.springWeb2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="library_table")
public class BookDao {
	@Id
	@Column(name="Book_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int id;
	@Column(name="Title")
	private String title;
	@Column(name="Author")
	private String author;
	@Column(name="Cost")
	private double cost;
	@Column(name="Quantity")
	private int quantity;

	public BookDao() {
		super();
	}

	public BookDao(int id, String title, String author, double cost, int quantity) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.cost = cost;
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

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", cost=" + cost + ", quantity="
				+ quantity + "]";
	}
	
}


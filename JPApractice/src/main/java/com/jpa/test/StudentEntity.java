package com.jpa.test;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class StudentEntity {

	@Id
	private int id;
	private String name;

	public StudentEntity(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public StudentEntity() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

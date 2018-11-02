package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trainee {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	@Column(length = 200)
	private String name;
	
	public Trainee (int ID, String name) {
		this.setID(ID);
		this.setName(name); 
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

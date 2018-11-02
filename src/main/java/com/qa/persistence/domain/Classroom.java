package com.qa.persistence.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Classroom {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	@Column(length = 200)
	private String trainer;
	
	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="TRAINEE_ID")
	private Trainee trainee;
	
	public Classroom(int ID, String trainer, Trainee trainee) {
		this.setID(ID);
		this.setTrainer(trainer);
		this.setTrainee(trainee);
		
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public Trainee getTrainee() {
		return trainee;
	}

	public void setTrainee(Trainee trainee) {
		this.trainee = trainee;
	}

	
}

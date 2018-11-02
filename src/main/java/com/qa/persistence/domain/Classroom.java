package com.qa.persistence.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Classroom")
public class Classroom {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="trainee_ID")
	private int ID;
	@Column(length = 200)
	private String trainer;
	
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	  @JoinColumn(name="trainee_ID", referencedColumnName="trainee_ID")
    private List<Trainee> trainee;
	
	public Classroom() {}
	public Classroom(int ID, String trainer) {
		this.setID(ID);
		this.setTrainer(trainer);
		
	}
	public Classroom(int ID, String trainer, List<Trainee> trainee) {
		this.setID(ID);
		this.setTrainer(trainer);
		this.setTrainee(trainee);
		
	}
	
	private void setTrainee(List<Trainee> trainee2) {
		// TODO Auto-generated method stub
		this.trainee = trainee2;
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

	public List<Trainee> getTrainee() {
		return trainee;
	}

	

	
}

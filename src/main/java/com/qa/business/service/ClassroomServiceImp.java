package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.repository.ClassroomRepository;



public class ClassroomServiceImp implements ClassroomService {

	@Inject
	private ClassroomRepository repo;
	
	public String addClassroom(String room) {
		return repo.addClassroom(room);
	}

	public String deleteClassroom(int id) {
		// TODO Auto-generated method stub
		return repo.deleteClassroom(id);
	}

	public String ammendClassroom(String id) {
		// TODO Auto-generated method stub
		return repo.ammendClassroom(id);
	}

	public String getAClassroom(int id) {
		// TODO Auto-generated method stub
		return repo.getClassroom(id);
	}

	public String getAllClassrooms() {
		// TODO Auto-generated method stub
		return repo.getAllClassrooms();
	}
	
	public void setRepo(ClassroomRepository repo) {
		this.repo = repo;
	}

}

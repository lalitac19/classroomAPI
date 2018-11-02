package com.qa.business.service;

public interface ClassroomService {

	
	String addClassroom(String room);
	String deleteClassroom(int id);
	String ammendClassroom (String id);
	String getAClassroom(int id);
	String getAllClassrooms();
}

package com.qa.persistence.repository;

public interface ClassroomRepository {
	
	String addClassroom(String classroom);
	String deleteClassroom(int id);
	String ammendClassroom(String id);
	String getClassroom(int id);
	String getAllClassrooms();

}

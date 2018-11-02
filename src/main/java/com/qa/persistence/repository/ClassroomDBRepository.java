package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Classroom;
import com.qa.persistence.domain.Trainee;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class ClassroomDBRepository implements ClassroomRepository {
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;
	
	@Inject
	private JSONUtil jsonConverter;
	
	@Transactional(REQUIRED)
	public String addClassroom(String classroom) {
		Classroom aClassroom = util.getObjectForJSON(classroom, Classroom.class);
		Query query = manager.createQuery("INSET INTO Classroom (trainer) VALUES (' "+classroom +"')");
		manager.persist(aClassroom);
		return "{\"message\": \"classroom has been sucessfully added\"}";
	}

	@Transactional(REQUIRED)
	public String deleteClassroom(int id) {
		Classroom roomInDB = findClassroom(id); 
		if (roomInDB != null) {
			manager.remove(roomInDB);
		}
		return "{\"message\": \"classroom sucessfully deleted\"}";
	}

	
	public String ammendClassroom(String id) {
		Classroom classroom = jsonConverter.getObjectForJSON(id, Classroom.class);
		int roomInDB = classroom.getID();
		manager.remove(roomInDB);
		manager.persist(classroom);
		return "{\"Account has been successfully updated\"}";
	}

	public String getAClassroom(int id) {
		Query query = manager.createQuery("SELECT * FROM Classroom WHERE ID = " + id);
		return util.getJSONForObject(query);
	}

	public String getAllClassrooms() {
		Query query = manager.createQuery("Select a FROM Classroom a");
		Collection<Classroom> classroom = (Collection<Classroom>) query.getResultList();
		return util.getJSONForObject(classroom);
	}
	
	private Classroom findClassroom(int id) {
		return manager.find(Classroom.class, id);
	}
	
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}
	
	public void setUtil(JSONUtil util) {
		this.util = util;
	}
}

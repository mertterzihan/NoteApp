package com.globalmaksimum.noteapp.model.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public abstract class AbstractDataSource {
	
	private EntityManagerFactory emf;
	
	protected EntityManager openConnection(){
		return emf.createEntityManager();
	}
	
	protected void closeConnection(EntityManager em){
		em.close();
	}
	
	public void setEmf(EntityManagerFactory temp){
		this.emf = temp;
	}

}

package com.jpa.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistStudent {

	public static void main(String args[]) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Student_details");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		StudentEntity s1 = new StudentEntity();
		s1.setId(11);
		s1.setName("rakesh");

		StudentEntity s2 = new StudentEntity();
		s2.setId(12);
		s2.setName("ankit");

		em.persist(s1);
		em.persist(s2);

		em.getTransaction().commit();

		emf.close();
		em.close();

	}
}
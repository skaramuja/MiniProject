package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Person;

public class PersonHelper {

	// Create database connection
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Addresses");

	public void insertPerson(Person person) {
		EntityManager entityManager = emfactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(person);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	/**
	 * Query people table and return all rows
	 * @return rows in people table
	 */
	public List showAllPeople() {
		EntityManager entityManager = emfactory.createEntityManager();
		List allPeople = entityManager.createQuery("SELECT i from Person i").getResultList();
		return allPeople;

	}

	/**
	 * Delete user selected row in people table
	 * @param person
	 */
	public void deletePerson(Person person) {
		EntityManager entityManager = emfactory.createEntityManager();
		entityManager.getTransaction().begin();
		TypedQuery<Person> typedQuery = entityManager
				.createQuery("select person from Person person where person.id = :selectedPerson", Person.class);

		typedQuery.setParameter("selectedPerson", person.getId());

		typedQuery.setMaxResults(1);

		Person result = typedQuery.getSingleResult();

		entityManager.remove(result);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	/**
	 * Query people table based on user id selection
	 * @param id
	 * @return person
	 */
	public Person searchForPersonById(int id) {
		EntityManager entityManager = emfactory.createEntityManager();
		entityManager.getTransaction().begin();

		Person person = entityManager.find(Person.class, id);
		entityManager.close();
		return person;
	}

	/**
	 * Update person in person table based on user edit selection
	 * @param person
	 */
	public void updatePerson(Person person) {
		EntityManager entityManager = emfactory.createEntityManager();
		entityManager.getTransaction().begin();

		entityManager.merge(person);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	// Closing the EntityManagerFactory
	public void cleanUp() {
		emfactory.close();
	}

}

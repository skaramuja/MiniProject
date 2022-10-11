package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Address;

public class AddressHelper {

	// Create database connection
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Addresses");

	public void insertAddress(Address adress) {
		EntityManager entityManager = emfactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(adress);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	/**
	 * Delete user selected row in address table
	 * @param address
	 */
	public void deleteAddress(Address address) {
		EntityManager entityManager = emfactory.createEntityManager();
		entityManager.getTransaction().begin();
		TypedQuery<Address> typedQuery = entityManager
				.createQuery("select address from Address address where address.id = :selectedAddress", Address.class);

		typedQuery.setParameter("selectedAddress", address.getId());

		typedQuery.setMaxResults(1);

		Address result = typedQuery.getSingleResult();

		entityManager.remove(result);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	/**
	 * Query address table based on user id selection
	 * @param id
	 * @return address
	 */
	public Address searchForAddressById(int id) {
		EntityManager entityManager = emfactory.createEntityManager();
		entityManager.getTransaction().begin();

		Address address = entityManager.find(Address.class, id);
		entityManager.close();
		return address;
	}

	/**
	 * Update address in address table based on user edit selection
	 * @param address
	 */
	public void updateAddress(Address address) {
		EntityManager entityManager = emfactory.createEntityManager();
		entityManager.getTransaction().begin();

		entityManager.merge(address);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	// Closing the EntityManagerFactory
	public void cleanUp() {
		emfactory.close();
	}

}

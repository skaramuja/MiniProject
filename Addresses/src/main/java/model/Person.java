/**
 * @author Sabina Johnson - skaramuja
 * CIS175 - Fall 2022
 * October 10, 2022
 */

package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table (name="Person")
public class Person {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="FIRSTNAME")
	private String firstName;
	@Column(name="LASTNAME")
	private String lastName;
	@Column(name="BIRTHDATE")
	private LocalDate birthDate;
	
	// A Person can have many addresses and many people can have the same address
	@ManyToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<Address> listOfAddresses;
	
	/**
	 * Default constructor with no parameters
	 */
	public Person() {

	}

	/**
	 * Non-default constructor that takes id, fist name, last name, birthdate, and list of addresses as parameters
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param birthdate
	 * @param listOfAddresses
	 */
	public Person(int id, String firstName, String lastName, LocalDate birthdate, List<Address> listOfAddresses) {
		setId(id);
		setFirstName(firstName);
		setLastName(lastName);
		setBirthDate(birthdate);
		setListOfAddresses(listOfAddresses);
	}
	
	/**
	 * Non-default constructor that takes fist name, last name, and list of addresses as parameters
	 * @param firstName
	 * @param lastName
	 */
	public Person(String firstName, String lastName, LocalDate birthdate) {
		setFirstName(firstName);
		setLastName(lastName);
		setBirthDate(birthdate);
	}

	/**
	 * Getter for id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter for id
	 */
	private void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter for first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Setter for first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Getter for last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Setter for last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	

	/**
	 * Getter for birthDate
	 */
	public LocalDate getBirthDate() {
		return birthDate;
	}

	/**
	 * Setter for birthDate
	 */
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * Getter for lists
	 */
	public List<Address> getListOfAddresses() {
		return listOfAddresses;
	}

	/**
	 * Setter for lists
	 */
	public void setListOfAddresses(List<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}

	@Override
	public String toString() {
		return "Person [id=" + getId() + ", firstName=" + getFirstName() + ", lastName=" + getLastName() + ", birthdate=" + getBirthDate()
				+ ", listOfAddresses=" + getListOfAddresses() + "]";
	}
}

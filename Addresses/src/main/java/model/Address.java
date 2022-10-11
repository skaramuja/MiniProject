/**
 * @author Sabina Johnson - skaramuja
 * CIS175 - Fall 2022
 * October 10, 2022
 */

package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Address")
public class Address {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="STREET")
	private String street;
	@Column(name="CITY")
	private String city;
	@Column(name="STATE")
	private String state;
	@Column(name="ZIPCODE")
	private int zipCode;
	
	/**
	 * Default constructor with no parameters
	 */
	public Address() {
		
	}

	/**
	 * Non-default constructor that takes id, street, city, state, and zip code as parameters
	 * @param id
	 * @param street
	 * @param city
	 * @param state
	 * @param zipCode
	 */
	public Address(int id, String street, String city, String state, int zipCode) {
		setId(id);
		setStreet(street);
		setCity(city);
		setState(state);
		setZipCode(zipCode);
	}
	
	/**
	 * Non-default constructor that takes street, city, state, and zip code as parameters
	 * @param street
	 * @param city
	 * @param state
	 * @param zipCode
	 */
	public Address(String street, String city, String state, int zipCode) {
		setStreet(street);
		setCity(city);
		setState(state);
		setZipCode(zipCode);
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
	 * Getter for street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * Setter for street
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * Getter for city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Setter for city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Getter for state
	 */
	public String getState() {
		return state;
	}

	/**
	 * Setter for state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Getter for zip code
	 */
	public int getZipCode() {
		return zipCode;
	}

	/**
	 * Setter for zip code
	 */
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "Address [id=" + getId() + ", street=" + getStreet() + ", city=" + getCity() + ", state=" + getState()
				+ ", zipCode=" + getZipCode() + "]";
	}
	
}

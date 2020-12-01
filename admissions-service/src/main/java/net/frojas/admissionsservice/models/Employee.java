package net.frojas.admissionsservice.models;

public class Employee {

	private String id;
	private String firstName;
	private String lastName;
	private String specialty;
	
	public Employee() {
		
	}
	
	public Employee(String id, String firstName, String lastName, String specialty) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.specialty = specialty;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
}

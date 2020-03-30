package com.javra.medical.insurance.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sample.reference.dto.MedicalClaimDto;

@Entity
@Table(name = "USER")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private long id;

	private String Name;
	

	private String Designation;

	private String Department;

	private String ContactNumber;

	private String AssociateEmail;

	private String BeginDate;

	private String Country;

	private String SuperVisor;

	private String SupervisorEmail;
	
	private String password;

	@OneToMany(mappedBy = "user")
	private Set<Role> role;
	
	@OneToMany(mappedBy = "user")
	private Set<MedicalClaim> medicalClaims;

	public Set<MedicalClaim> getMedicalClaims() {
		return medicalClaims;
	}

	public void setMedicalClaims(Set<MedicalClaim> medicalClaims) {
		this.medicalClaims = medicalClaims;
	}

	public Set<Role> getRole() {
		return role;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return Name;
	}

	public String getDesignation() {
		return Designation;
	}

	public String getDepartment() {
		return Department;
	}

	public String getContactNumber() {
		return ContactNumber;
	}

	public String getAssociateEmail() {
		return AssociateEmail;
	}

	public String getBeginDate() {
		return BeginDate;
	}

	public String getCountry() {
		return Country;
	}

	public String getSuperVisor() {
		return SuperVisor;
	}

	public String getSupervisorEmail() {
		return SupervisorEmail;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		Name = name;
	}

	public void setDesignation(String designation) {
		Designation = designation;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	public void setContactNumber(String contactNumber) {
		ContactNumber = contactNumber;
	}

	public void setAssociateEmail(String associateEmail) {
		AssociateEmail = associateEmail;
	}

	public void setBeginDate(String beginDate) {
		BeginDate = beginDate;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public void setSuperVisor(String superVisor) {
		SuperVisor = superVisor;
	}

	public void setSupervisorEmail(String supervisorEmail) {
		SupervisorEmail = supervisorEmail;
	}

	public void setRole(Set<Role> role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
package com.javra.medical.insurance.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "medical_claim_tbl")
public class MedicalClaim implements Serializable {

	private static final long serialVersionUID = -3465813074586302847L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "claim_id")
	private int id;

	@Column
	private String nameOfInsured;

	@Column
	private int policyNo;

	@Column
	private int periodOfInsurance;

	@Column
	private String businessAddress;

	@Column
	private String businessPhoneNo;

	@Column
	private String BusinessFaxNo;

	@Column
	private String claimantName;

	@Column
	private String claimantOccupation;

	@Column
	private int claimantAge;

	@Column
	private String claimantSex;

	@Column
	private String patientName;

	@Column
	private String patientSex;

	@Column
	private String patientAge;

	@Column
	private String claimantRelationToPatient;

	@Column
	private String patientResAddress;

	@Column
	private String patientphoneNo;

	@Column
	private String dateOfSymptomsStarted;

	@Column
	private String dateOfFirstIllenessTreatement;

	@Column
	private String dateTimeOfAccident;

	@Column
	private String dateOfFirstAccidentTreatment;

	@Column
	private String symptomOfIllness;

	@Column
	private String natureAndCauseOfInjuries;

	@Column
	private String nameOfAttendingDoctor;

	@Column
	private String doctorQualification;

	@Column
	private String doctorNmcNo;

	@Column
	private String doctorContactAddress;

	@Column
	private String doctorPhoneNo;

	@Column
	private String CoDoctorVisitDate;

	@Column
	private String totalClaimedAmount;

	@Column
	private Date dateOfClaim;
	
	@Column
	private String isApproved;
	
	@Column
	private String comment;
	
	@Column
	private String status;
	
	@Column
	private String filelocation;
	
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	
	@OneToMany(mappedBy = "medicalclaim")
	private Set<ClaimStatement> claimstatement;
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(int policyNo) {
		this.policyNo = policyNo;
	}

	public int getPeriodOfInsurance() {
		return periodOfInsurance;
	}

	public void setPeriodOfInsurance(int periodOfInsurance) {
		this.periodOfInsurance = periodOfInsurance;
	}

	public String getBusinessAddress() {
		return businessAddress;
	}

	public void setBusinessAddress(String businessAddress) {
		this.businessAddress = businessAddress;
	}

	public String getBusinessPhoneNo() {
		return businessPhoneNo;
	}

	public void setBusinessPhoneNo(String businessPhoneNo) {
		this.businessPhoneNo = businessPhoneNo;
	}

	public String getBusinessFaxNo() {
		return BusinessFaxNo;
	}

	public void setBusinessFaxNo(String businessFaxNo) {
		BusinessFaxNo = businessFaxNo;
	}

	public String getClaimantName() {
		return claimantName;
	}

	public void setClaimantName(String claimantName) {
		this.claimantName = claimantName;
	}

	public String getClaimantOccupation() {
		return claimantOccupation;
	}

	public void setClaimantOccupation(String claimantOccupation) {
		this.claimantOccupation = claimantOccupation;
	}

	public int getClaimantAge() {
		return claimantAge;
	}

	public void setClaimantAge(int claimantAge) {
		this.claimantAge = claimantAge;
	}

	public String getClaimantSex() {
		return claimantSex;
	}

	public void setClaimantSex(String claimantSex) {
		this.claimantSex = claimantSex;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientSex() {
		return patientSex;
	}

	public void setPatientSex(String patientSex) {
		this.patientSex = patientSex;
	}

	public String getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(String patientAge) {
		this.patientAge = patientAge;
	}

	public String getClaimantRelationToPatient() {
		return claimantRelationToPatient;
	}

	public void setClaimantRelationToPatient(String claimantRelationToPatient) {
		this.claimantRelationToPatient = claimantRelationToPatient;
	}

	public String getPatientResAddress() {
		return patientResAddress;
	}

	public void setPatientResAddress(String patientResAddress) {
		this.patientResAddress = patientResAddress;
	}

	public String getPatientphoneNo() {
		return patientphoneNo;
	}

	public void setPatientphoneNo(String patientphoneNo) {
		this.patientphoneNo = patientphoneNo;
	}

	public String getDateOfSymptomsStarted() {
		return dateOfSymptomsStarted;
	}

	public void setDateOfSymptomsStarted(String dateOfSymptomsStarted) {
		this.dateOfSymptomsStarted = dateOfSymptomsStarted;
	}

	public String getDateOfFirstIllenessTreatement() {
		return dateOfFirstIllenessTreatement;
	}

	public void setDateOfFirstIllenessTreatement(String dateOfFirstIllenessTreatement) {
		this.dateOfFirstIllenessTreatement = dateOfFirstIllenessTreatement;
	}

	public String getDateTimeOfAccident() {
		return dateTimeOfAccident;
	}

	public void setDateTimeOfAccident(String dateTimeOfAccident) {
		this.dateTimeOfAccident = dateTimeOfAccident;
	}

	public String getDateOfFirstAccidentTreatment() {
		return dateOfFirstAccidentTreatment;
	}

	public void setDateOfFirstAccidentTreatment(String dateOfFirstAccidentTreatment) {
		this.dateOfFirstAccidentTreatment = dateOfFirstAccidentTreatment;
	}

	public String getSymptomOfIllness() {
		return symptomOfIllness;
	}

	public void setSymptomOfIllness(String symptomOfIllness) {
		this.symptomOfIllness = symptomOfIllness;
	}

	public String getNatureAndCauseOfInjuries() {
		return natureAndCauseOfInjuries;
	}

	public void setNatureAndCauseOfInjuries(String natureAndCauseOfInjuries) {
		this.natureAndCauseOfInjuries = natureAndCauseOfInjuries;
	}

	public String getNameOfAttendingDoctor() {
		return nameOfAttendingDoctor;
	}

	public void setNameOfAttendingDoctor(String nameOfAttendingDoctor) {
		this.nameOfAttendingDoctor = nameOfAttendingDoctor;
	}

	public String getDoctorQualification() {
		return doctorQualification;
	}

	public void setDoctorQualification(String doctorQualification) {
		this.doctorQualification = doctorQualification;
	}

	public String getDoctorNmcNo() {
		return doctorNmcNo;
	}

	public void setDoctorNmcNo(String doctorNmcNo) {
		this.doctorNmcNo = doctorNmcNo;
	}

	public String getDoctorContactAddress() {
		return doctorContactAddress;
	}

	public void setDoctorContactAddress(String doctorContactAddress) {
		this.doctorContactAddress = doctorContactAddress;
	}

	public String getDoctorPhoneNo() {
		return doctorPhoneNo;
	}

	public void setDoctorPhoneNo(String doctorPhoneNo) {
		this.doctorPhoneNo = doctorPhoneNo;
	}

	public String getCoDoctorVisitDate() {
		return CoDoctorVisitDate;
	}

	public void setCoDoctorVisitDate(String coDoctorVisitDate) {
		CoDoctorVisitDate = coDoctorVisitDate;
	}

	public String getTotalClaimedAmount() {
		return totalClaimedAmount;
	}

	public void setTotalClaimedAmount(String totalClaimedAmount) {
		this.totalClaimedAmount = totalClaimedAmount;
	}

	public Date getDateOfClaim() {
		return dateOfClaim;
	}

	public void setDateOfClaim(Date dateOfClaim) {
		this.dateOfClaim = dateOfClaim;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getNameOfInsured() {
		return nameOfInsured;
	}

	public void setNameOfInsured(String nameOfInsured) {
		this.nameOfInsured = nameOfInsured;
	}

	public Set<ClaimStatement> getClaimstatement() {
		return claimstatement;
	}

	public void setClaimstatement(Set<ClaimStatement> claimstatement) {
		this.claimstatement = claimstatement;
	}

	public String getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(String isApproved) {
		this.isApproved = isApproved;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFilelocation() {
		return filelocation;
	}

	public void setFilelocation(String filelocation) {
		this.filelocation = filelocation;
	}



}
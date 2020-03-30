package com.sample.reference.dto;


import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class MedicalClaimDto implements Serializable {

	private static final long serialVersionUID = -3465813074586302847L;

	
	private int id;

	
	private String nameOfInsured;

	
	private int policyNo;

	
	private int periodOfInsurance;

	
	private String businessAddress;

	
	private String businessPhoneNo;

	
	private String BusinessFaxNo;

	
	private String claimantName;

	
	private String claimantOccupation;

	
	private int claimantAge;

	
	private String claimantSex;

	
	private String patientName;

	
	private String patientSex;

	
	private String patientAge;

	
	private String claimantRelationToPatient;

	
	private String patientResAddress;

	
	private String patientphoneNo;

	
	private String dateOfSymptomsStarted;

	
	private String dateOfFirstIllenessTreatement;

	
	private String dateTimeOfAccident;

	
	private String dateOfFirstAccidentTreatment;

	
	private String symptomOfIllness;

	
	private String natureAndCauseOfInjuries;

	
	private String nameOfAttendingDoctor;

	
	private String doctorQualification;

	
	private String doctorNmcNo;

	
	private String doctorContactAddress;

	
	private String doctorPhoneNo;

	
	private String CoDoctorVisitDate;

	
	private String totalClaimedAmount;

	
	private String dateOfClaim;
	

//	private String userId;	
//
//	public String getUserId() {
//		return userId;
//	}
//
//	public void setUserId(String userId) {
//		this.userId = userId;
//	}

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

	public String getDateOfClaim() {
		return dateOfClaim;
	}

	public void setDateOfClaim(String dateOfClaim) {
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

}
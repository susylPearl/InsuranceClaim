package com.javra.medical.insurance.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sample.reference.dto.MedicalClaimDto;


public class InsuranceClaimValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return MedicalClaimDto.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		
		
//		Validation for Insurance Claim Form
		System.out.println("InsuranceClaimValidator running");
		
		
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "claimantName",
				"required.claimantName", "claimant name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "claimantOccupation",
				"required.claimantOccupation", "claimant occupation is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "claimantAge",
				"required.claimantAge", "claim age is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "claimantSex",
				"required.claimantSex", "claimant sex is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "patientName",
				"required.patientName", "patient name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "patientAge",
				"required.patientAge", "patient age is required.");
//		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "patientSex",
//				"required.patientSex", "patient sex is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "claimantRelationToPatient",
				"required.claimantRelationToPatient", "claimant relation to patient is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "patientResAddress",
				"required.patientResAddress", "patient address is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "patientphoneNo",
				"required.patientphoneNo", "patient phone number is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "nameOfAttendingDoctor",
				"required.nameOfAttendingDoctor", "doctor name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "doctorQualification",
				"required.doctorQualification", "doctor qualification is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "doctorNmcNo",
				"required.doctorNmcNo", "doctor Nmc No is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "doctorContactAddress",
				"required.doctorContactAddress", "doctor address is required.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "doctorPhoneNo",
				"required.doctorPhoneNo", "doctor phone number is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "dateOfClaim",
				"required.dateOfClaim", "claim date is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "totalClaimedAmount",
				"required.totalClaimedAmount", "total claimed amount is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "CoDoctorVisitDate",
				"required.CoDoctorVisitDate", "doctor visit date is required.");
		
		
//		IF(CLAIMDTO.GETCODOCTORVISITDATE().EQUALS("MM/DD/YYY")){
//			ARG1.REJECTVALUE("CODOCTORVISITDATE", "DOCTOR VISIT DATE FORMAT INVALID!");
//			
//		}
		

		
		
		
	}

}

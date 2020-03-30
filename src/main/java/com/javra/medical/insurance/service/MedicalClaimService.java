package com.javra.medical.insurance.service;

import java.util.List;

import com.javra.medical.insurance.model.ClaimStatement;
import com.javra.medical.insurance.model.MedicalClaim;
import com.sample.reference.dto.MedicalClaimDto;

public interface MedicalClaimService {

	public void addClaim(MedicalClaim medicalclaim);
	
	public Integer getMedicalClaim(MedicalClaim medicalclaim);
	
	
	public List<MedicalClaim> getAllMedicalClaim();

	public void deleteMedicalClaim(Integer claimId);

	public MedicalClaim getMedicalClaim(int claimId);

	public MedicalClaim updateMedicalClaim(MedicalClaim MedicalClaim);

	public List<ClaimStatement> getAllMedicalClaimStatement(String claimtype, Integer claimId);

	public void addClaimStatement(ClaimStatement claimstatement);

	public List<ClaimStatement> getMedicalClaimByClaimId(Integer claimid);

	public List<MedicalClaim> getAllClaimWithStatus(Long userid);

	public ClaimStatement updateSpecificClaimStatement(ClaimStatement claimStatement);
	
	public ClaimStatement getClaimStatementById(Long id);

	

}

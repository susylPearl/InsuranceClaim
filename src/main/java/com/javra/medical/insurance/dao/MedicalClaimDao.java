package com.javra.medical.insurance.dao;

import java.util.List;

import com.javra.medical.insurance.model.ClaimStatement;
import com.javra.medical.insurance.model.MedicalClaim;
import com.sample.reference.dto.MedicalClaimDto;

public interface MedicalClaimDao {

	public void addClaim(MedicalClaim medicalclaim);
	
	public Integer getMedicalClaimObject(MedicalClaim medicalclaim);

	public List<MedicalClaim> getAllMedicalClaim();

	public void deleteMedicalClaim(Integer claimId);

	public MedicalClaim getMedicalClaim(int claimId);

	public MedicalClaim updateMedicalClaim(MedicalClaim MedicalClaim);
	
	public void addClaimStatement(ClaimStatement claimstatement);
	
	public List<ClaimStatement> getAllMedicalClaimStatement(String claimType, Integer claimId);

	public List<ClaimStatement> getMedicalClaimByClaimId(Integer claimid);

	public List<MedicalClaim> getAllMedicalClaimWithStatus(Long userId);

	public ClaimStatement updateSpecificClaimStatement(ClaimStatement claimStatement);

	public ClaimStatement getClaimStatementById(Long id);

}

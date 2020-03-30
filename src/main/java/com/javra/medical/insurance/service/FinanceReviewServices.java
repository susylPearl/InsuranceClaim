package com.javra.medical.insurance.service;

import java.util.List;

import com.javra.medical.insurance.model.ClaimStatement;
import com.javra.medical.insurance.model.MedicalClaim;

public interface FinanceReviewServices {
	
	public int getAllMedicalClaimCount();
	public MedicalClaim getMedicalClaimDetails(int claimId);
	
	public List<MedicalClaim> getAllMedicalClaimForReview();
	
	public MedicalClaim updateMedicalClaim(MedicalClaim MedicalClaim);
	
	public List<ClaimStatement> getAllMedicalClaimStatement(String claimType);

}

package com.javra.medical.insurance.dao;

import java.util.List;

import com.javra.medical.insurance.model.ClaimStatement;
import com.javra.medical.insurance.model.MedicalClaim;

public interface FinanceReviewDao {

	public int getAllMedicalClaimCount();
	public MedicalClaim getMedicalClaimDetails(int claimId);
	
	public List<MedicalClaim> getAllMedicalClaimForReview();
	
	public MedicalClaim updateMedicalClaim(MedicalClaim MedicalClaim);
	
	public List<ClaimStatement> getAllMedicalClaimStatement(String claimType);
	
	public String getDownloadedFilePath(Integer claimid);
}

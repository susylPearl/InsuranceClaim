package com.javra.medical.insurance.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javra.medical.insurance.dao.FinanceReviewDao;
import com.javra.medical.insurance.model.ClaimStatement;
import com.javra.medical.insurance.model.MedicalClaim;
import com.javra.medical.insurance.service.FinanceReviewServices;

@Transactional
@Service
public class FinanceReviewServiceImpl implements FinanceReviewServices{

	 @Autowired
	 private FinanceReviewDao financeReviewDAO; 
	@Override
	public int getAllMedicalClaimCount() {
		// TODO Auto-generated method stub
		return financeReviewDAO.getAllMedicalClaimCount();
	}

	@Override
	public MedicalClaim getMedicalClaimDetails(int claimId) {
		// TODO Auto-generated method stub
		return financeReviewDAO.getMedicalClaimDetails(claimId);
	}

	@Override
	public List<MedicalClaim> getAllMedicalClaimForReview() {
		// TODO Auto-generated method stub
		return financeReviewDAO.getAllMedicalClaimForReview();
	}

	@Override
	public MedicalClaim updateMedicalClaim(MedicalClaim MedicalClaim) {
		// TODO Auto-generated method stub
		return financeReviewDAO.updateMedicalClaim(MedicalClaim);
	}

	@Override
	public List<ClaimStatement> getAllMedicalClaimStatement(String claimType) {
		// TODO Auto-generated method stub
		return financeReviewDAO.getAllMedicalClaimStatement(claimType);
	}

}

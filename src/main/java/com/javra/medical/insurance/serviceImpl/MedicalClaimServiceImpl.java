package com.javra.medical.insurance.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javra.medical.insurance.dao.MedicalClaimDao;
import com.javra.medical.insurance.model.ClaimStatement;
import com.javra.medical.insurance.model.MedicalClaim;
import com.javra.medical.insurance.service.MedicalClaimService;
import com.sample.reference.dto.MedicalClaimDto;

@Service
@Transactional
public class MedicalClaimServiceImpl implements MedicalClaimService {

	@Autowired
	private MedicalClaimDao medicalClaimDAO;

	@Override
	public void addClaim(MedicalClaim medicalclaim) {
		medicalClaimDAO.addClaim(medicalclaim);

	}

	@Override
	public List<MedicalClaim> getAllMedicalClaim() {
		return medicalClaimDAO.getAllMedicalClaim();
	}

	@Override
	public void deleteMedicalClaim(Integer medicalClaimId) {
		medicalClaimDAO.deleteMedicalClaim(medicalClaimId);
	}

	@Override
	public MedicalClaim getMedicalClaim(int medicalClaimId) {
		return medicalClaimDAO.getMedicalClaim(medicalClaimId);
	}

	@Override
	public MedicalClaim updateMedicalClaim(MedicalClaim medicalClaim) {
		return medicalClaimDAO.updateMedicalClaim(medicalClaim);
	}

	@Override
	public Integer getMedicalClaim(MedicalClaim medicalclaim) {
		// TODO Auto-generated method stub
		return medicalClaimDAO.getMedicalClaimObject(medicalclaim);
	}
	
	@Override
	public void addClaimStatement(ClaimStatement medicalclaim) {
		medicalClaimDAO.addClaimStatement(medicalclaim);
		
	}

	@Override
	public List<ClaimStatement> getAllMedicalClaimStatement(String claimType, Integer claimId) {
		return medicalClaimDAO.getAllMedicalClaimStatement(claimType, claimId);
	}

	@Override
	public List<ClaimStatement> getMedicalClaimByClaimId(Integer claimid) {

		return medicalClaimDAO.getMedicalClaimByClaimId(claimid);
	}

	@Override
	public List<MedicalClaim> getAllClaimWithStatus(Long userId) {
		return medicalClaimDAO.getAllMedicalClaimWithStatus(userId);
	}

	@Override
	public ClaimStatement updateSpecificClaimStatement(ClaimStatement claimStatement) {
		return medicalClaimDAO.updateSpecificClaimStatement(claimStatement);
		
	}

	@Override
	public ClaimStatement getClaimStatementById(Long id) {
		return medicalClaimDAO.getClaimStatementById(id);
	}

}

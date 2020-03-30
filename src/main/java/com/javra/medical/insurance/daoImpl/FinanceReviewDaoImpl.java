package com.javra.medical.insurance.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javra.medical.insurance.dao.FinanceReviewDao;
import com.javra.medical.insurance.model.ClaimStatement;
import com.javra.medical.insurance.model.MedicalClaim;
@Repository
public class FinanceReviewDaoImpl implements FinanceReviewDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int getAllMedicalClaimCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MedicalClaim getMedicalClaimDetails(int claimId) {
		// TODO Auto-generated method stub
		return (MedicalClaim) sessionFactory.getCurrentSession().get(MedicalClaim.class, claimId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MedicalClaim> getAllMedicalClaimForReview() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from MedicalClaim where isApproved = '0'").list();
	}

	@Override
	public MedicalClaim updateMedicalClaim(MedicalClaim MedicalClaim) {
		// TODO Auto-generated method stu
	

		sessionFactory.getCurrentSession().update(MedicalClaim);
		return MedicalClaim;
	}

	public List<ClaimStatement> getAllMedicalClaimStatement(String claimType) {
		// TODO Auto-generated method stub
		
		
		Query query = sessionFactory.getCurrentSession().createQuery("from ClaimStatement where claimtype = :claimtype ");
		query.setParameter("claimtype",claimType);
		return  query.list();
			
	}
	
	public String getDownloadedFilePath(Integer claimid) {
		// TODO Auto-generated method stub
		
		
		Query query = sessionFactory.getCurrentSession().createQuery("filelocation from MedicalClaim where claim_id = :claimid ");
		query.setParameter("claimid",claimid);
		return  query.toString();
			
	}

	

}

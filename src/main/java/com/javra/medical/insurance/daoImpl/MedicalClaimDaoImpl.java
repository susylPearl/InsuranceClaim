package com.javra.medical.insurance.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javra.medical.insurance.dao.MedicalClaimDao;
import com.javra.medical.insurance.model.ClaimStatement;
import com.javra.medical.insurance.model.MedicalClaim;

@Repository
public class MedicalClaimDaoImpl implements MedicalClaimDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addClaim(MedicalClaim medicalclaim) {
		sessionFactory.getCurrentSession().saveOrUpdate(medicalclaim);

	}

	@SuppressWarnings("unchecked")
	public List<MedicalClaim> getAllMedicalClaim() {

		return sessionFactory.getCurrentSession().createQuery("from MedicalClaim").list();
	}

	@Override
	public void deleteMedicalClaim(Integer MedicalClaimId) {
		MedicalClaim MedicalClaim = (MedicalClaim) sessionFactory.getCurrentSession().load(MedicalClaim.class,
				MedicalClaimId);
		if (null != MedicalClaim) {
			this.sessionFactory.getCurrentSession().delete(MedicalClaim);
		}

	}

	public MedicalClaim getMedicalClaim(int MedicalClaimId) {
		return (MedicalClaim) sessionFactory.getCurrentSession().get(MedicalClaim.class, MedicalClaimId);
	}

	@Override
	public MedicalClaim updateMedicalClaim(MedicalClaim MedicalClaim) {
		sessionFactory.getCurrentSession().update(MedicalClaim);
		return MedicalClaim;
	}

	@Override
	public Integer getMedicalClaimObject(MedicalClaim medicalclaim) {
		return (Integer)sessionFactory.getCurrentSession().save(medicalclaim);
		
	}
	
	@Override
	public void addClaimStatement(ClaimStatement claimstatement) {
		sessionFactory.getCurrentSession().saveOrUpdate(claimstatement);
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ClaimStatement> getAllMedicalClaimStatement(String claimType, Integer claimId) {
		Session session = configSession(ClaimStatement.class);
	     
		String queryString = "from ClaimStatement where claimtype = :clmTyp AND claim_id = :claimId";
		Query query =  session.createQuery(queryString);
		query.setString("clmTyp", claimType);
		query.setInteger("claimId", claimId);
		
		
		
		return (List<ClaimStatement>)query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ClaimStatement> getMedicalClaimByClaimId(Integer claimid) {
		 
		Session session = configSession(ClaimStatement.class);
	     
		String queryString = "from ClaimStatement where claim_id = :claimId";
		Query query =  session.createQuery(queryString);
		query.setInteger("claimId", claimid);
		
		
		
		return (List<ClaimStatement>)query.list();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MedicalClaim> getAllMedicalClaimWithStatus(Long userId) {
		Session session = configSession(MedicalClaim.class);
		String queryString = "from MedicalClaim where  user_id = :Id AND status IN (:stat)";
		Query query = session.createQuery(queryString);
		List<String> list = new ArrayList<>();
		list.add("Rejected");
		list.add("Approved");
		query.setLong("Id", userId);
		query.setParameterList("stat", list);
		
		
		return (List<MedicalClaim>)query.list();
	}
	
	
	private <T> Session configSession(Class<T> class1){
		
		Configuration config = new Configuration();
	    config.addAnnotatedClass(class1);
	    Session session = this.sessionFactory.getCurrentSession();
	    
	    return session;
	}

	@Override
	public ClaimStatement updateSpecificClaimStatement(ClaimStatement claimStatement) {
		sessionFactory.getCurrentSession().update(claimStatement);
		return claimStatement;
	}

	@Override
	public ClaimStatement getClaimStatementById(Long id) {
		return (ClaimStatement) sessionFactory.getCurrentSession().get(ClaimStatement.class, id);
	}

	
}
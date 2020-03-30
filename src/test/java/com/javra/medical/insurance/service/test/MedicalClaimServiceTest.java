package com.javra.medical.insurance.service.test;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.javra.medical.insurance.model.ClaimStatement;
import com.javra.medical.insurance.model.MedicalClaim;
import com.javra.medical.insurance.model.Role;
import com.javra.medical.insurance.model.User;
import com.javra.medical.insurance.service.MedicalClaimService;
import com.javra.medical.insurance.service.UserService;
import com.sample.reference.dto.MedicalClaimDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationcontext.xml")
public class MedicalClaimServiceTest {
	@Autowired
	private MedicalClaimService claimservice;
	@Autowired
	private UserService userservice;

	@Test
	public void addClaim() {
		
		User user = new User();
		user.setName("javra");
		user.setAssociateEmail("chiran");
		user.setDesignation("developer");
		user.setPassword("chiran");

		MedicalClaim claim = new MedicalClaim();
		claim.setClaimantAge(26);
		claim.setUser(user);
		
		
		
		
		//claimservice.addClaim(claim);
		
		Set<MedicalClaim>medicalClaims = new HashSet<>();
		medicalClaims.add(claim);
		user.setMedicalClaims(medicalClaims);
		
		
		ClaimStatement statement=new ClaimStatement();
		statement.setAmoount("10");
		statement.setBillrefno("10");
		statement.setMedicalclaim(claim);
		
		Set<ClaimStatement> claimstatement = new HashSet<>();
		claimstatement.add(statement);
		
		
		
		
		
		
		claim.setClaimstatement(claimstatement);
		
		userservice.adduser(user);
		claimservice.addClaim(claim);
		claimservice.addClaimStatement(statement);
		
		
		
		
		// add claim statement 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

	@Test
	public void addUser() {
		/*User user = new User();
		user.setName("abishkar");
		Role role = new Role();
		role.setRoletype("developer");
		role.setUser(user);

		Set<Role> roleset = new HashSet<Role>();
		roleset.add(role);
		user.setRole(roleset);
		userservice.adduser(user);
		userservice.addRole(role);*/

	}

}
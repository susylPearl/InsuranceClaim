package com.javra.medical.insurance.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "claim_statement")
public class ClaimStatement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2396384624462222831L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	private String billrefno;

	private String description;

	private String amoount;
	
	private String total;
	
	private String claimtype;
	
	@ManyToOne
	@JoinColumn(name = "claim_id", nullable = false)
	private MedicalClaim medicalclaim;
	
	public long getId() {
		return id;
	}
	public String getClaimtype() {
		return claimtype;
	}
	public void setClaimtype(String claimtype) {
		this.claimtype = claimtype;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBillrefno() {
		return billrefno;
	}
	public void setBillrefno(String billrefno) {
		this.billrefno = billrefno;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAmoount() {
		return amoount;
	}
	public void setAmoount(String amoount) {
		this.amoount = amoount;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public MedicalClaim getMedicalclaim() {
		return medicalclaim;
	}
	public void setMedicalclaim(MedicalClaim medicalclaim) {
		this.medicalclaim = medicalclaim;
	}

}

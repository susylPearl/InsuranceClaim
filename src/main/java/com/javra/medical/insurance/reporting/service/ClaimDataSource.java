package com.javra.medical.insurance.reporting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javra.medical.insurance.service.MedicalClaimService;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ClaimDataSource {
	@Autowired
	private MedicalClaimService medicalclaimservice;

	public JRDataSource getDataSource() {

		JRDataSource ds = new JRBeanCollectionDataSource(medicalclaimservice.getAllMedicalClaim());

		// Return the wrapped collection
		return ds;
	}

}

package com.javra.medical.insurance.reporting.service;

import java.util.Date;
 
import ar.com.fdvs.dj.domain.DynamicReport;
import ar.com.fdvs.dj.domain.builders.ColumnBuilderException;
import ar.com.fdvs.dj.domain.builders.FastReportBuilder;
 
/**
* Everything under the package org.krams.tutorial.dynamicjasper are settings imposed by DynamicJasper (not Jasper)
*<p>
 
* Builds the report layout, the template, the design, the pattern or whatever synonym you may want to call it.
*/
public class ReportLayout {
 
/**
* Builds the report layout. This doesn't have any data yet. This is your template.
* 
* @return the layout
*/
public DynamicReport buildReportLayout() throws ColumnBuilderException, ClassNotFoundException {
 
// The column fields must match the name of the  properties in your datasource
// For example, if in you're datasource, you have a field name firstName, then the column
// field must have a fieldName as well
 
// Create an instance of FastReportBuilder
FastReportBuilder drb = new FastReportBuilder();
 
// Format when adding columns:
// Friendly column name,  Field name (case-sensitive), Type, Width of the column
drb.addColumn("Name Of Insured", "nameOfInsured", String.class.getName(), 50)
.addColumn("PolicyNo", "policyNo" , Integer .class.getName(), 50)
.addColumn("PeriodOfInsurance", "periodOfInsurance", Integer.class.getName(), 50)
.addColumn("BusinessAddress", "businessAddress", String.class.getName(), 50)
.addColumn("BusinessPhoneNo", "businessPhoneNo", String.class.getName(), 50)
.addColumn("BusinessFaxNo", "businessFaxNo", String.class.getName(), 50)
.addColumn("ClaimantName", "claimantName", String.class.getName(), 50)
.addColumn("ClaimantOccupation", "claimantOccupation", String.class.getName(), 50)
.addColumn("ClaimantAge", "claimantAge", Integer.class.getName(), 50)
.addColumn("ClaimantSex", "claimantSex", String.class.getName(), 50)
.addColumn("PatientName", "patientName", String.class.getName(), 50)
.addColumn("PatientSex", "patientSex", String.class.getName(), 50)
.addColumn("PatientAge", "patientAge", String.class.getName(), 50)
.addColumn("ClaimantRelationToPatient", "claimantRelationToPatient", String.class.getName(), 50)
.addColumn("PatientResAddress", "patientResAddress", String.class.getName(), 50)
.addColumn("PatientphoneNo", "patientphoneNo", String.class.getName(), 50)
.addColumn("DateOfSymptomsStarted", "dateOfSymptomsStarted", String.class.getName(), 50)
.addColumn("DateOfFirstIllenessTreatement", "dateOfFirstIllenessTreatement", String.class.getName(), 50)
.setPrintColumnNames(true)
 
// Disables pagination
.setIgnorePagination(true)
 
// Experiment with this numbers to see the effect
.setMargins(0, 0, 0, 0) 
 
// Set the title shown inside the Excel file
.setTitle("Claim Report ") 
 
// Set the subtitle shown inside the Excel file
.setSubtitle("This report was generated at " + new Date()) 
 
// Set to true if you want to constrain your report within the page boundaries
// For longer reports, set it to false
.setUseFullPageWidth(true);
 
// Set the name of the file
drb.setReportName("Claim Report");
 
// Build the report layout
// Note this just the layout. It doesn't have any data yet!
DynamicReport dr = drb.build();
 
// Return the layout
return dr;
}
}
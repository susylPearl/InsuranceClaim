package com.javra.medical.insurance.reporting.service;

import java.io.ByteArrayOutputStream;
 
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRXlsAbstractExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
 
/**
* Everything under the package org.krams.tutorial.jasper are settings imposed by Jasper (not DynamicJasper)
* <p>
 
* An exporter for exporting the report in various formats, i.e Excel, PDF, CSV. Here we declare a PDF exporter
*/
public class Exporter {
 
/**
* Exports a report to XLS (Excel) format. You can declare another export here, i.e PDF or CSV.
* You don't really need to create a separate class or method for the exporter. You can call it
* directly within your Service or Controller.
* 
* @param jp the JasperPrint object
* @param baos the ByteArrayOutputStream where the report will be written
*/
public void export(JasperPrint jp, ByteArrayOutputStream baos) throws JRException {
// Create a JRXlsExporter instance
JRXlsExporter exporter = new JRXlsExporter();
 
// Here we assign the parameters jp and baos to the exporter
exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
 
// Excel specific parameters
// Check the Jasper (not DynamicJasper) docs for a description of these settings. Most are 
// self-documenting
exporter.setParameter(JRXlsAbstractExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
exporter.setParameter(JRXlsAbstractExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
exporter.setParameter(JRXlsAbstractExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
 
// Retrieve the exported report in XLS format
exporter.exportReport();
}
}
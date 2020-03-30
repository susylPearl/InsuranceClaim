package com.javra.medical.insurance.reporting.service;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.fdvs.dj.core.DynamicJasperHelper;
import ar.com.fdvs.dj.core.layout.ClassicLayoutManager;
import ar.com.fdvs.dj.domain.DynamicReport;
import ar.com.fdvs.dj.domain.builders.ColumnBuilderException;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@Service
@Transactional
public class DownloadService {
	@Autowired
	ClaimDataSource claimdatasource;

	/**
	 * Processes the download for Excel format
	 */
	public void downloadXLS(HttpServletResponse response)
			throws ColumnBuilderException, ClassNotFoundException, JRException {

		// Retrieve our data source

		JRDataSource ds = claimdatasource.getDataSource();

		// Create our report layout
		// We delegate the reporting layout to a custom ReportLayout instance
		// The ReportLayout is a wrapper class I made. Feel free to remove or
		// modify it
		ReportLayout layout = new ReportLayout();
		DynamicReport dr = layout.buildReportLayout();

		// params is used for passing extra parameters like when passing
		// a custom datasource, such as Hibernate datasource
		// In this application we won't utilize this parameter
		HashMap params = new HashMap();

		// Compile our report layout
		JasperReport jr = DynamicJasperHelper.generateJasperReport(dr, new ClassicLayoutManager(), params);

		// Creates the JasperPrint object
		// It needs a JasperReport layout and a datasource
		JasperPrint jp = JasperFillManager.fillReport(jr, params, ds);

		// Create our output byte stream
		// This is the stream where the data will be written
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		// Export to output stream
		// The data will be exported to the ByteArrayOutputStream baos
		// We delegate the exporting to a custom Exporter instance
		// The Exporter is a wrapper class I made. Feel free to remove or modify
		// it
		Exporter exporter = new Exporter();
		exporter.export(jp, baos);

		// Set our response properties
		// Here you can declare a custom filename
		String fileName = "claimreport.xls";
		response.setHeader("Content-Disposition", "inline; filename=" + fileName);
		// Make sure to set the correct content type
		// Each format has its own content type
		response.setContentType("application/vnd.ms-excel");
		response.setContentLength(baos.size());

		// Write to reponse stream
		writeReportToResponseStream(response, baos);
	}

	/**
	 * Writes the report to the output stream
	 */
	private void writeReportToResponseStream(HttpServletResponse response, ByteArrayOutputStream baos) {

		try {
			// Retrieve the output stream
			ServletOutputStream outputStream = response.getOutputStream();
			// Write to the output stream
			baos.writeTo(outputStream);
			// Flush the stream
			outputStream.flush();

		} catch (Exception e) {
		}
	}

}
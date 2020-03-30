package com.javra.medical.insurance.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.javra.medical.insurance.model.MedicalClaim;
import com.javra.medical.insurance.reporting.service.DownloadService;
import com.javra.medical.insurance.service.MedicalClaimService;

import ar.com.fdvs.dj.domain.builders.ColumnBuilderException;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping("/report/")
public class ReportController {

	@Autowired
	MedicalClaimService medicalclaimservice;
	
	@Autowired
	private DownloadService downloadService;

	@RequestMapping(method = RequestMethod.GET, value = "pdf")
	public ModelAndView generatePdfReport(ModelAndView modelAndView) {

		Map<String, Object> parameterMap = new HashMap<String, Object>();

		List<MedicalClaim> usersList = medicalclaimservice.getAllMedicalClaim();

		JRDataSource JRdataSource = new JRBeanCollectionDataSource(usersList);

		parameterMap.put("datasource", JRdataSource);

		// pdfReport bean has ben declared in the jasper-views.xml file
		modelAndView = new ModelAndView("pdfReport", parameterMap);

		return modelAndView;

	}// generatePdfReport

	@RequestMapping(method = RequestMethod.GET, value = "xls")
	public ModelAndView generateXlsReport(ModelAndView modelAndView) {

		Map<String, Object> parameterMap = new HashMap<String, Object>();

		List<MedicalClaim> usersList = medicalclaimservice.getAllMedicalClaim();

		JRDataSource JRdataSource = new JRBeanCollectionDataSource(usersList);

		parameterMap.put("datasource", JRdataSource);

		// xlsReport bean has been declared in the jasper-views.xml file
		modelAndView = new ModelAndView("xlsReport", parameterMap);

		return modelAndView;

	}// generatePdfReport

	@RequestMapping(method = RequestMethod.GET, value = "csv")
	public ModelAndView generateCsvReport(ModelAndView modelAndView) {

		Map<String, Object> parameterMap = new HashMap<String, Object>();

		List<MedicalClaim> usersList = medicalclaimservice.getAllMedicalClaim();

		JRDataSource JRdataSource = new JRBeanCollectionDataSource(usersList);

		parameterMap.put("datasource", JRdataSource);

		// xlsReport bean has ben declared in the jasper-views.xml file
		modelAndView = new ModelAndView("csvReport", parameterMap);

		return modelAndView;

	}// generatePdfReport

	@RequestMapping(method = RequestMethod.GET, value = "html")
	public ModelAndView generateHtmlReport(ModelAndView modelAndView) {

		List<MedicalClaim> usersList = medicalclaimservice.getAllMedicalClaim();
		Map<String, Object> parameterMap = new HashMap<String, Object>();

		JRDataSource JRdataSource = new JRBeanCollectionDataSource(usersList);

		parameterMap.put("datasource", JRdataSource);

		// xlsReport bean has ben declared in the jasper-views.xml file
		modelAndView = new ModelAndView("htmlReport", parameterMap);

		return modelAndView;

	}// generatePdfReport
	
	
	@RequestMapping(value = "/download/xls", method = RequestMethod.GET)
    public void doSalesReportXLS(HttpServletResponse response)
    throws ServletException, IOException, ClassNotFoundException,
    SQLException, ColumnBuilderException, JRException {
     
     
    // Call DownloadService to do the actual report processing
    downloadService.downloadXLS(response);
    }


}// ReportController
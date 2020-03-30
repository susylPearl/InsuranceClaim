
package com.javra.medical.insurance.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.javra.medical.insurance.constant.utils.Constant;
import com.javra.medical.insurance.model.ClaimStatement;
import com.javra.medical.insurance.model.MedicalClaim;
import com.javra.medical.insurance.model.User;
import com.javra.medical.insurance.security.SecurityUtils;
import com.javra.medical.insurance.service.FinanceReviewServices;
import com.javra.medical.insurance.service.UserService;
import com.sample.reference.dto.MedicalClaimDto;
import com.sample.reference.model.Employee;

@Controller
public class MedicalClaimFinanceController {
	

	/**
	 * Inialization of the FinanceServices for CRUD operations
	 */
	@Autowired
	private FinanceReviewServices financereviewService;
	/**
	 * Inialization of the SendMailController for sending the mail
	 */
	@Autowired
	private SendMailController sendMailController;
	private String comment;
    private long userID;
    
    private int claimID;
    @Autowired
	private HttpSession session;
    @Autowired
	private UserService userservice;
   
    private ClaimStatement claimstatement;
    
//    @Autowired
//	private FinanceValidator financeValidator;
    
    
    
    
    
	/**
	 * This method is use as the Landing page once the Finance Team Login which
	 * shows the number of counts of the Claim.
	 * 
	 * @param model
	 * @return
	 * @throws IOException
	 */

	@RequestMapping(value = "/getFinanceClaims")
	public ModelAndView listEmployee(ModelAndView model) throws IOException {
		model.setViewName("financeclaims");
		List<MedicalClaim> listEmployee = financereviewService.getAllMedicalClaimForReview();
		
		model.addObject("listclaims", listEmployee);
		return model;
	}

	/**
	 * This method is use as the for showing the data related to the particular
	 * ClaimID
	 * 
	 * @param model
	 * @param request
	 * @param response
	 * @param medicalclaimdetails
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */

	@RequestMapping(value = "/approveClaim", method = RequestMethod.GET)
	public ModelAndView employeeDetailCliamReport(ModelAndView model, HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute Employee medicalclaimdetails)
			throws IOException, ParseException {

		{
			model.setViewName("claimform");
			model.addObject("medicalclaimdetails",
			financereviewService.getMedicalClaimDetails(Integer.parseInt(request.getParameter("claimid"))));
			claimID = Integer.parseInt(request.getParameter("claimid"));
			session.setAttribute("claimid", claimID);
			
			return model;
		}
	}
	
	@RequestMapping(value = "/approveClaim1", method = RequestMethod.GET)
	public ModelAndView employeeDownloadFiles(ModelAndView model, HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute Employee medicalclaimdetails)
			throws IOException, ParseException {

		{
			model.setViewName("claimform");
			model.addObject("medicalclaimdetails",
			financereviewService.getMedicalClaimDetails(Integer.parseInt(request.getParameter("claimid"))));
			claimID = Integer.parseInt(request.getParameter("claimid"));
			session.setAttribute("claimid", claimID);
			
			return model;
		}
	}

	/**
	 * This method is used for retriving the Detail Claim Report for the
	 * Doctor's Consulting Fee , it is redirect to the
	 * financereviewdoctorclinic.jsp page
	 * 
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */

	@RequestMapping(value = "/detailClaimDoctorClinicReport")
	public ModelAndView employeeDetailDoctorClinicCliamReport(ModelAndView model, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ParseException {

		{
			System.out.println("next screen for claim report");
			model.setViewName("financereviewdoctorclinic");
			model.addObject("listclaims", financereviewService.getAllMedicalClaimStatement(Constant.DOCTORS_CLINIC_FEE));

			return model;
		}
	}

	/**
	 * This method is used for the retriving the Detail Claim Report for the
	 * Doctor's Consulting fee for home visit, it is redirect to the
	 * financereviewdoctorhomevisit.jsp page
	 * 
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping(value = "/detailClaimDoctorHomeVisitReport")
	public ModelAndView employeeDetailDoctorHomeVisitCliamReport(ModelAndView model, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ParseException {

		{

			System.out.println("next screen for claim report");
			model.setViewName("financereviewdoctorhomevisit");
			model.addObject("listclaims", financereviewService.getAllMedicalClaimStatement(Constant.DOCTORS_HOME_FEE));

			return model;
		}
	}

	/**
	 * This method is used for the retriving the Detail Claim Report for the
	 * Medicine purchased , it is redirect to the financereviewmedicine.jsp page
	 * 
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping(value = "/detailClaimMedicineReport")
	public ModelAndView employeeDetailMedicineCliamReport(ModelAndView model, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ParseException {

		{

			System.out.println("next screen for claim report");
			model.setViewName("financereviewmedicine");
			model.addObject("listclaims", financereviewService.getAllMedicalClaimStatement(Constant.MEDICINE_FEE));

			return model;
		}
	}

	/**
	 * This method is used for the retriving the Detail Claim Report for the
	 * different Lab Test , it is redirect to the financereviewlabtest.jsp page
	 * 
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping(value = "/detailClaimLabTestReport")
	public ModelAndView employeeDetailLabTestCliamReport(ModelAndView model, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ParseException {

		{

			String decline = request.getParameter("decline");
			String approve = request.getParameter("approve");
			comment = request.getParameter("comment");
			System.out.println("next screen for claim report");
			model.setViewName("financereviewlabtest");
		    int claimid=	(int) session.getAttribute("claimid");
			
		    User user= userservice.findByUserName(SecurityUtils.getCurrentLogin());
						

			if (decline != null) {
				
				if(comment == null || comment.isEmpty() || comment.equals(" ")){
					model.addObject("error", "Comment should not be empty.");
				}else{
						sendMailReject( claimid,user);
						model.addObject("msg", Constant.STATUS_REJECTED_MESSAGE);
					
				}		 
				 
				 
					
				
			} else if (approve != null) {
				
				if(comment == null || comment.isEmpty() || comment.equals(" ")){
					model.addObject("error", "Comment should not be empty.");
				}else{
					sendMailApprove(claimid,user);
					model.addObject("msg", Constant.STATUS_APPROVED_MESSAGE);
					
				}	
				
			}
			model.addObject("listclaims", financereviewService.getAllMedicalClaimStatement(Constant.LABTEST_FEE));
		

			return model;
		}
	}
	
	/*@RequestMapping("/{fileName:.+}")
    public void downloadPDFResource( HttpServletRequest request, 
                                     HttpServletResponse response, 
                                     @PathVariable("fileName") String fileName) 
    {
        //If user is not authorized - he should be thrown out from here itself
         
        //Authorized user will download the file
        String dataDirectory = request.getServletContext().getRealPath("/WEB-INF/");
        Path file = Paths.get(dataDirectory, fileName);
        if (Files.exists(file)) 
        {
            response.setContentType("application/pdf");
            response.addHeader("Content-Disposition", "attachment; filename="+"FIRSTDELEGATEMAILER.pdf");
            try
            {
                Files.copy(file, response.getOutputStream());
                response.getOutputStream().flush();
            } 
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }*/

	/**
	 * This method is use for sending the mail to user by Finance for notifying the status 
	 * of the claim submitted by the User
	 */
	private void sendMailApprove(int claimid,User userinifo) {

		sendMailController.sendHtmlMailApprove(userinifo.getAssociateEmail(), "Remarks by Finance ", userinifo.getName(), comment);
		MedicalClaim medicalclaimobj=	financereviewService.getMedicalClaimDetails(claimid);
		medicalclaimobj.setId(claimid);
		medicalclaimobj.setStatus(Constant.STATUS_APPROVED);
		medicalclaimobj.setIsApproved(Constant.STATUS_APPROVED_FLAG);
		medicalclaimobj.setComment(comment);
		medicalclaimobj.setUser(userinifo);
		financereviewService.updateMedicalClaim(medicalclaimobj);
	}
	
	private void sendMailReject(int claimid,User userinfo)
	{
		sendMailController.sendHtmlMailReject(userinfo.getAssociateEmail(), "Remarks by Finance ", userinfo.getName(), comment);
		MedicalClaim medicalclaimobj1 =	financereviewService.getMedicalClaimDetails(claimid);
		medicalclaimobj1.setId(claimid);
		medicalclaimobj1.setStatus(Constant.STATUS_REJECTED);
		medicalclaimobj1.setIsApproved(Constant.STATUS_REJECTED_FLAG);
		medicalclaimobj1.setComment(comment);
		medicalclaimobj1.setUser(userinfo);
		financereviewService.updateMedicalClaim(medicalclaimobj1);
	}
	
	

}

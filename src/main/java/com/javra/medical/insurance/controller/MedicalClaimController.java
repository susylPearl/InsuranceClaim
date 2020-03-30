package com.javra.medical.insurance.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.javra.medical.insurance.constant.utils.Constant;
import com.javra.medical.insurance.model.ClaimStatement;
import com.javra.medical.insurance.model.MedicalClaim;
import com.javra.medical.insurance.model.User;
import com.javra.medical.insurance.security.SecurityUtils;
import com.javra.medical.insurance.service.MedicalClaimService;
import com.javra.medical.insurance.service.UserService;

import com.javra.medical.insurance.upload.FileUpload;

import com.javra.medical.insurance.validation.ClaimStatementValidator;

import com.javra.medical.insurance.validation.InsuranceClaimValidator;
import com.sample.reference.dto.MedicalClaimDto;

@Controller
public class MedicalClaimController {
	@Autowired
	private MedicalClaimService medicalclaimservice;

	@Autowired
	private UserService userservice;

	@Autowired

	private HttpSession session;
	
	
	
	 @Autowired
	 @Qualifier("insuranceClaimValidator")
	 InsuranceClaimValidator insuranceClaimValidator;
	

	 @Autowired
	 @Qualifier("claimStatementValidator")
	 ClaimStatementValidator claimStatementValidator;
	 


	@RequestMapping(value = "/getAllMedicalClaim")
	public List<MedicalClaim> getAllMedicalClaim() {
		return medicalclaimservice.getAllMedicalClaim();

	}

	@RequestMapping(value = "/getMedicalClaimStatus")
	public ModelAndView claimStatusList(ModelAndView model) {
		model.setViewName("medicalClaimStatusPage");
		User user= userservice.findByUserName(SecurityUtils.getCurrentLogin());
		
		model.addObject("listclaims", medicalclaimservice.getAllClaimWithStatus(user.getId()));
		return model;

	}

	@RequestMapping(value = "/redirectToMedicalClaimPage", method = RequestMethod.POST)
	public ModelAndView getMedicalClaimPage(ModelAndView model,
			@ModelAttribute("medicalclaim") MedicalClaim medicalClaim) {
		model.setViewName("medicalclaim");
		model.addObject("isNew", true);
		return model;

	}

	// @RequestMapping(value = "/addclaim")
	// public List<MedicalClaim> addClaim(@RequestBody MedicalClaim
	// medicalclaim) {
	//
	// medicalclaimservice.addClaim(medicalclaim);
	//
	// return medicalclaimservice.getAllMedicalClaim();
	//
	// }

	@RequestMapping(value = "/addMedicalClaim", method = RequestMethod.POST)
	public ModelAndView addClaim(HttpServletRequest request, ModelAndView model,
			@ModelAttribute("medicalclaim") MedicalClaimDto medicalClaimDto,
			@ModelAttribute("medicalclaim") @Validated MedicalClaimDto medicalclaim, BindingResult bindingResult,
			final RedirectAttributes redirectAttributes) {

	insuranceClaimValidator.validate(medicalclaim, bindingResult);
		String addBtn = request.getParameter("add");

		String editBtn = request.getParameter("edit");

		if (addBtn != null) {

			if (bindingResult.hasErrors()) {
				System.out.println("error occured");
				model.addObject("isNew", true);
				model.addObject("error", "Some fields are missing, please fill it up.");
				model.setViewName("medicalclaim");
			} else {

				Integer claimId = medicalclaimservice.getMedicalClaim(getMedicalClaimModel(medicalClaimDto));
				System.out.println("<<Printing object id before" + claimId);
				medicalClaimDto.setId(claimId);
				model.addObject("medicalclaim", medicalClaimDto);
				model.addObject("msg", "Your form is ready to be sumbitted. You can further edit for any changes.");
				model.setViewName("medicalclaim");
			}

		} else if (editBtn != null) {

			if (bindingResult.hasErrors()) {
				System.out.println("error occured");
				model.addObject("isNew", false);
				model.addObject("error", "Some fields are missing, please fill it up.");
				model.setViewName("medicalclaim");
			} else {
				MedicalClaim medicalClaim = getMedicalClaimModel(medicalClaimDto);

				int objectid = medicalClaimDto.getId();
				System.out.println(medicalClaimDto.getId());
				medicalClaim.setId(medicalClaimDto.getId());
				medicalclaimservice.updateMedicalClaim(medicalClaim);
				// model.addObject("claimtype", "doctorFees");
				model.setViewName("redirect:/claimstatement?claimtype=" + Constant.DOCTORS_CLINIC_FEE);
				session.setAttribute("claimid", objectid);
			}

		}


		return model;
	}

	
	private MedicalClaim getMedicalClaimModel(MedicalClaimDto medicalClaimdto){
		
		 MedicalClaim medicalClaim = new MedicalClaim();
		 
		 medicalClaim.setNameOfInsured(medicalClaimdto.getNameOfInsured());
		 medicalClaim.setPolicyNo(medicalClaimdto.getPolicyNo());
		 medicalClaim.setPeriodOfInsurance(medicalClaimdto.getPeriodOfInsurance());
		 medicalClaim.setBusinessAddress(medicalClaimdto.getBusinessAddress());
		 medicalClaim.setBusinessPhoneNo(medicalClaimdto.getBusinessPhoneNo());
		 medicalClaim.setBusinessFaxNo(medicalClaimdto.getBusinessFaxNo());
		 
		 medicalClaim.setClaimantName(medicalClaimdto.getClaimantName());
		 medicalClaim.setClaimantOccupation(medicalClaimdto.getClaimantOccupation());
		 medicalClaim.setPatientName(medicalClaimdto.getPatientName());
		 medicalClaim.setClaimantRelationToPatient(medicalClaimdto.getClaimantRelationToPatient());
		 medicalClaim.setPatientResAddress(medicalClaimdto.getPatientResAddress());
		 medicalClaim.setPatientphoneNo(medicalClaimdto.getPatientphoneNo());
		 
		 medicalClaim.setDateOfSymptomsStarted(medicalClaimdto.getDateOfSymptomsStarted());
		 medicalClaim.setDateOfFirstIllenessTreatement(medicalClaimdto.getDateOfFirstIllenessTreatement());
		 medicalClaim.setDateTimeOfAccident(medicalClaimdto.getDateTimeOfAccident());
		 medicalClaim.setDateOfFirstAccidentTreatment(medicalClaimdto.getDateOfFirstAccidentTreatment());
		 
		 medicalClaim.setSymptomOfIllness(medicalClaimdto.getSymptomOfIllness());
		 medicalClaim.setNatureAndCauseOfInjuries(medicalClaimdto.getNatureAndCauseOfInjuries());
		 medicalClaim.setNameOfAttendingDoctor(medicalClaimdto.getNameOfAttendingDoctor());
		 medicalClaim.setDoctorQualification(medicalClaimdto.getDoctorQualification());
		 medicalClaim.setDoctorNmcNo(medicalClaimdto.getDoctorNmcNo());
		 medicalClaim.setDoctorContactAddress(medicalClaimdto.getDoctorContactAddress());
		 medicalClaim.setDoctorPhoneNo(medicalClaimdto.getDoctorPhoneNo());
		 
		 medicalClaim.setCoDoctorVisitDate(medicalClaimdto.getCoDoctorVisitDate());
		 medicalClaim.setTotalClaimedAmount(medicalClaimdto.getTotalClaimedAmount());
		 
		 medicalClaim.setStatus(Constant.STATUS_NEW_CLAIM);
		 medicalClaim.setIsApproved(Constant.STATUS_REJECTED_FLAG);
		 
		 //TO DO need to be edited later on in this part of code.
		 
		 User user = new User();
		 user.setAssociateEmail("javratest@gmail.com");
		 userservice.adduser(user);
		 
		 medicalClaim.setUser(user);

		return medicalClaim;

	}

	@RequestMapping(value = "/updateclaim")
	public List<MedicalClaim> editClaim(@RequestBody MedicalClaim medicalclaim) {

		medicalclaimservice.updateMedicalClaim(medicalclaim);

		return medicalclaimservice.getAllMedicalClaim();

	}

	@RequestMapping(value = "/deleteclaim")
	public List<MedicalClaim> deleteClaim(@RequestBody MedicalClaimDto medicalclaim) {

		medicalclaimservice.deleteMedicalClaim(medicalclaim.getId());

		return medicalclaimservice.getAllMedicalClaim();

	}

	@RequestMapping(value = "/getclaimById")
	public MedicalClaim getClaimById(@RequestBody MedicalClaimDto medicalclaim) {

		return medicalclaimservice.getMedicalClaim(medicalclaim.getId());

	}

	@RequestMapping(value = "/claimstatement")
	public ModelAndView listclaim(ModelAndView model, @ModelAttribute("claimstatement") ClaimStatement claimstatement,
			HttpServletRequest r) throws IOException {

		Integer claimid = (Integer) session.getAttribute("claimid");
		String type = r.getParameter("claimtype");

		List<ClaimStatement> claimstatementmodel = medicalclaimservice.getAllMedicalClaimStatement(type, claimid);

		model.addObject("list", claimstatementmodel);
		
		model.setViewName("MedicalClaimListForm");

		return model;
	}

	@RequestMapping(value = "/claimhomestatement")
	public ModelAndView listclaimhome(ModelAndView model,
			@ModelAttribute("claimstatement") ClaimStatement claimstatement) throws IOException {
		Integer claimid = (Integer) session.getAttribute("claimid");

		List<ClaimStatement> claimstatementmodel = medicalclaimservice
				.getAllMedicalClaimStatement(claimstatement.getClaimtype(), claimid);
		model.addObject("MedicalClaimHomeForm", claimstatementmodel);

		model.setViewName("MedicalClaimHomeForm");

		return model;
	}

	@RequestMapping(value = "/saveclaimstatement", method = RequestMethod.POST)
	public ModelAndView saveClaimStatement(HttpServletRequest request, ModelAndView models,
			@ModelAttribute("claimstatement") ClaimStatement claimstatement,
			@ModelAttribute("claimstatement") @Validated ClaimStatement claimStatement2, BindingResult bindingResult) {

		String saveBtn = request.getParameter("save");

		String nextBtn = request.getParameter("next");

		String type = claimstatement.getClaimtype();

		Integer claimid = (Integer) session.getAttribute("claimid");

		if (saveBtn != null) {
			 claimStatementValidator.validate(claimStatement2, bindingResult);
			if (bindingResult.hasErrors()) {
				
				models.setViewName(getRedirectPageSave(claimstatement.getClaimtype()));
				
				System.out.println("value of claim id" + claimid );
				System.out.println("value of claim id" + claimstatement.getClaimtype() );
				
				List<ClaimStatement> listclaimstatement = medicalclaimservice.getAllMedicalClaimStatement(type,
						claimid);
				
				System.out.println("size of listclaimstatement"+ listclaimstatement.size() );

				//ModelAndView model = new ModelAndView(getRedirectPageSave(claimstatement.getClaimtype()));
				models.addObject("list", listclaimstatement);
				
				return models;

			} else {
				System.out.println("claim id for second case" + claimid +  type);
				MedicalClaim medicalclaim = medicalclaimservice.getMedicalClaim(claimid);
				claimstatement.setMedicalclaim(medicalclaim);
				medicalclaimservice.addClaimStatement(claimstatement);

				List<ClaimStatement> listclaimstatement = medicalclaimservice.getAllMedicalClaimStatement(type,
						claimid);

				ModelAndView model = new ModelAndView(getRedirectPageSave(claimstatement.getClaimtype()));
				model.addObject("list", listclaimstatement);
				model.addObject("claimstatement", new ClaimStatement());

				return model;
			}

		} else if (nextBtn != null) {

			ModelAndView model = new ModelAndView(getRedirectPage(claimstatement.getClaimtype()));
			if (getRedirectPage(claimstatement.getClaimtype()).equals("fileuploader")) {
				FileUpload fileModel = new FileUpload();
				model.addObject("fileBucket", fileModel);
			}
			return model;
		}

		return models;
	}

	
	
	private String getRedirectPage(String claimtype){
		
		if(claimtype.equals(Constant.DOCTORS_CLINIC_FEE)){
		
			return "MedicalClaimHomeForm";
			
		}else if(claimtype.equals(Constant.DOCTORS_HOME_FEE)){
			
			return "medicalclaimcharge";
		}else if(claimtype.equals(Constant.MEDICINE_FEE)){
			
			return "medicalclaimtest";
		}else{

			
			return "fileuploader"; 

		}

	}

	
	private String getRedirectPageSave(String claimtype){
			
		
		if(claimtype.equals(Constant.DOCTORS_CLINIC_FEE)){
			
			return "MedicalClaimListForm";
			
		}else if(claimtype.equals(Constant.DOCTORS_HOME_FEE)){
			
			return "MedicalClaimHomeForm";
		}else if(claimtype.equals(Constant.MEDICINE_FEE)){
			
			return "medicalclaimcharge";
		}else{
			
			return "medicalclaimtest"; 
			
		}
	}



	@RequestMapping("/editStatemnet/{billrefno},{description},{amoount},{total},{claimtype},{id}")
    public ModelAndView editclaimStatement( ModelAndView model, @PathVariable("billrefno") String  billrefno,
    		@PathVariable("description") String  description, @PathVariable("amoount") String  amoount, @PathVariable("total") String  total,
    		@PathVariable("claimtype") String  claimtype, @PathVariable("id") String  id){
		
		ClaimStatement claimStatement = new ClaimStatement();
		claimStatement.setBillrefno(billrefno);
		claimStatement.setDescription(description);
		claimStatement.setAmoount(amoount);
		claimStatement.setTotal(total);
		claimStatement.setClaimtype(claimtype);
		claimStatement.setId(Long.parseLong(id));
		
		model.addObject("claimStatement", claimStatement);
	    model.setViewName("editstatement");
	    	 
    	return model;
        
    }
	
	@RequestMapping("editStatemnet/editAndRedirect")
    public ModelAndView saveEditsAndRedirect( ModelAndView model, @ModelAttribute("claimStatement") ClaimStatement claimSt){
		 
		ClaimStatement claimStatement=	medicalclaimservice.getClaimStatementById(claimSt.getId());
		
		System.out.println("reading claimstatement id" + claimStatement.getId());
		System.out.println(claimSt.getBillrefno());
		claimStatement.setBillrefno(claimSt.getBillrefno());
		claimStatement.setDescription(claimSt.getDescription());
		claimStatement.setAmoount(claimSt.getAmoount());
		claimStatement.setTotal(claimSt.getTotal());
		claimStatement.setClaimtype(claimSt.getClaimtype());

		medicalclaimservice.updateSpecificClaimStatement(claimStatement);
		
		model.setViewName("redirect:/claimstatement?claimtype=doctorsClinicFee");
	    model.addObject("claimstatement", claimStatement);
		
    	return model;       
    }

}
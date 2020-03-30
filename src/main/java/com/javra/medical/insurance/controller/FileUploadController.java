package com.javra.medical.insurance.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.javra.medical.insurance.model.MedicalClaim;
import com.javra.medical.insurance.service.MedicalClaimService;
import com.javra.medical.insurance.upload.FileUpload;
import com.javra.medical.insurance.upload.FileValidator;

@Controller
public class FileUploadController {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	private MedicalClaimService medicalclaimservice;
	
	@Autowired
	@Qualifier("uploadValidator")
    FileValidator fileValidator;
 
    protected void initBinderFileBucket(WebDataBinder binder) {
       binder.setValidator(fileValidator);
    }
	
	  private static String UPLOAD_LOCATION="D:/filerepo/";
	    
	 
	    @RequestMapping(value="/upload", method = RequestMethod.POST)
	    public String singleFileUpload(@Valid FileUpload fileBucket, BindingResult result, ModelMap model) throws IOException {
	    	
	    	Integer claimid = (Integer) session.getAttribute("claimid");
	 
	        if (result.hasErrors()) {
	            System.out.println("validation errors");
	            return "fileuploader";
	        } else {            
	           
	            MultipartFile multipartFile = fileBucket.getFile();
	          
	            FileCopyUtils.copy(fileBucket.getFile().getBytes(), new File(UPLOAD_LOCATION + fileBucket.getFile().getOriginalFilename()));
	            
	            MedicalClaim medicalClaim = medicalclaimservice.getMedicalClaim(claimid);
	            medicalClaim.setFilelocation(UPLOAD_LOCATION+ "_"+claimid);
	            
	            medicalclaimservice.updateMedicalClaim(medicalClaim);
	             
	            String fileName = multipartFile.getOriginalFilename();
	            model.addAttribute("fileName", fileName);
	            return "success";
	        }
	    }
	    
	    @RequestMapping(value = "/uploadtest")
		public ModelAndView listclaimhome(ModelAndView model, @ModelAttribute("fileBucket") FileUpload fileBucket) {		
			
			model.setViewName("fileuploader");
		
			return model;
		}
	    
	    @RequestMapping(value={"/","/userDashboard"}, method = RequestMethod.GET)
		public String getHomePage(ModelMap model) {
			return "/userDashboard";
		}

}

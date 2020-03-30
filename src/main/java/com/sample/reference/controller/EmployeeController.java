package com.sample.reference.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.javra.medical.insurance.model.MedicalClaim;
import com.javra.medical.insurance.model.User;
import com.javra.medical.insurance.security.SecurityUtils;
import com.javra.medical.insurance.service.FinanceReviewServices;
import com.javra.medical.insurance.service.MedicalClaimService;
import com.javra.medical.insurance.service.UserService;
import com.javra.medical.insurance.validation.InsuranceClaimValidator;
import com.sample.reference.dto.MedicalClaimDto;
import com.sample.reference.model.Employee;
import com.sample.reference.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	UserService userservice;

	 @Autowired
	 @Qualifier("insuranceClaimValidator")
	 InsuranceClaimValidator insuranceClaimValidator;
	
	@Autowired
	SecurityUtils securityutils;
	
	@Autowired
	MedicalClaimService medicalClaimService;

	/*@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
*/
	private static final Logger logger = Logger.getLogger(EmployeeController.class);

	public EmployeeController() {
		System.out.println("EmployeeController()");
	}

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private FinanceReviewServices financeServices;

	@RequestMapping(value = "/")
	public ModelAndView listEmployee(ModelAndView model,  @ModelAttribute("medicalclaim") MedicalClaim medicalClaim) throws IOException {
//		List<Employee> listEmployee = employeeService.getAllEmployees();
//		model.addObject("listEmployee", listEmployee);
		System.out.println("currently logged in user is" + SecurityUtils.getCurrentLogin());
		User user= userservice.findByUserName(SecurityUtils.getCurrentLogin());
		
		System.out.println(securityutils);

		if(user.getDepartment().equals("finance")){
			model.setViewName("financeDashboard");
			model.addObject("noofclaims", financeServices.getAllMedicalClaimForReview().size());
			return model;
			
		}
		else{
			model.setViewName("userDashboard");
			model.addObject("claimCount", medicalClaimService.getAllClaimWithStatus(user.getId()).size());
			
			return model;
		}
		
	}

	@RequestMapping(value = "/newEmployee", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		Employee employee = new Employee();
		model.addObject("employee", employee);
		model.setViewName("EmployeeForm");
		return model;
	}

	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute Employee employee,@Validated Employee employeevalidation,BindingResult bindingResult) {
		insuranceClaimValidator.validate(employeevalidation, bindingResult);
		if (employee.getId() == 0) { // if employee id is 0 then creating the
			// employee other updating the employee
			if (bindingResult.hasErrors()) {
				return new ModelAndView("EmployeeForm");
			}
			employeeService.addEmployee(employee);
		} else {
			employeeService.updateEmployee(employee);
		}
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(HttpServletRequest request) {
		int employeeId = Integer.parseInt(request.getParameter("id"));
		employeeService.deleteEmployee(employeeId);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int employeeId = Integer.parseInt(request.getParameter("id"));
		Employee employee = employeeService.getEmployee(employeeId);
		ModelAndView model = new ModelAndView("EmployeeForm");
		model.addObject("employee", employee);

		return model;
	}

	// @RequestMapping(value = "/login", method = RequestMethod.GET)
	// public ModelAndView redirectToLogin(HttpServletRequest request) {
	//
	// ModelAndView model = new ModelAndView("login");
	//
	//
	// return model;
	// }

	// Spring Security see this :
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, HttpServletRequest r) {

		System.out.println("<<checking for username and password>>>" + r.getParameter("userName"));
		System.out.println("<<checking for username and password>>>" + r.getParameter("password"));

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;

	}

	@RequestMapping(value = "/user")
	public @ResponseBody MedicalClaimDto ProcessUser() {

		MedicalClaimDto dto = new MedicalClaimDto();
		return dto;

	}



}
package com.javra.medical.insurance.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.javra.medical.insurance.model.ClaimStatement;

public class ClaimStatementValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		 return ClaimStatement.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub
		
		
//		Validation for Login Page
		
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "billrefno",
				"required.billrefno", "billrefno is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "description",
				"required.description", "description is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "amoount",
				"required.amoount", "amount is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "total",
				"required.total", "total is required.");
		
		
		//ClaimStatement claimStatement = (ClaimStatement) arg0;
		
		
	}

}

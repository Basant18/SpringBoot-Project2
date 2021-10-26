package com.example.validations.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<NumberValidator,String>{

	@Override
	public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
		if(phoneNumber != null && !phoneNumber.isEmpty() && phoneNumber.length() == 10)
		{
			String regex = "[0-9]+";
			if(phoneNumber.matches(regex))
				return true;
			else {
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate("Only Integers are allowed").addConstraintViolation();
				return false;
			}
		}
		else {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("It should be 10 digits").addConstraintViolation();
		}
		return false;
	}

}

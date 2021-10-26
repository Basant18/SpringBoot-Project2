package com.example.validations.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DevEmailValidator implements ConstraintValidator<EmailValidator,String>{

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		if(email != null && !email.isEmpty() && email.length() >= 5)
		{
			//String regex = "^$";
			if(!email.matches("^.*[a-zA-Z].*$"))
			{
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate("Alphabets are required").addConstraintViolation();
				return false;
			}
			else if(!email.matches("^.*[0-9].*$"))
			{
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate("At least 1 Digit is required").addConstraintViolation();
				return false;
			}
			else if(!email.matches("^.*[@].*$"))
			{
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate("@ is required").addConstraintViolation();
				return false;
			}
			else
			{
				return true;
			}
		}
		else {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("It should be more than 5 letters").addConstraintViolation();
		}
		return false;
	}

}

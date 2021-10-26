package com.example.validations.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DevAgeValidator implements ConstraintValidator<AgeValidator,Long>{

	@Override
	public boolean isValid(Long age, ConstraintValidatorContext context) {
		if(age != null && age >= 18 && age<=45)
		{
			return true;
		}
		else {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("Age is invalid").addConstraintViolation();
		}
		return false;
	}

}

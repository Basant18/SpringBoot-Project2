package com.example.validations.validators;

import java.util.Objects;
import java.util.stream.Stream;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapperImpl;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class DevAgeGuardianValidator implements ConstraintValidator<AgeGuardianValidator,Object>{

	 //private static final SpelExpressionParser PARSER = new SpelExpressionParser();
	 private String age;
	 private String guardian;

	 @Override
	 public void initialize(AgeGuardianValidator constraintAnnotation) {
	     this.age = constraintAnnotation.age();
	     this.guardian = constraintAnnotation.guardian();
	 }
	
	@Override
	public boolean isValid(Object obj, ConstraintValidatorContext context) {
//		long notNull = Stream.of(fields)
//                .map(field -> PARSER.parseExpression(field).getValue(obj))
//                .filter(Objects::nonNull)
//                .count();
//        return notNull == 0 || notNull == fields.length;
		Object ageValue = new BeanWrapperImpl(obj).getPropertyValue(age);
		Object guardianValue = new BeanWrapperImpl(obj).getPropertyValue(guardian);
		//Object ageValue = PropertyUtils.getProperty(obj,this.age);
		int ageInt = Integer.parseInt((String)ageValue);
		if(ageInt < 18 && guardianValue == "")
		{
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("Age and Guardian is invalid").addPropertyNode(guardian).addConstraintViolation();
			System.out.println("Validation failed............");
			return false;
		}
		return true;
	}

	
	

}

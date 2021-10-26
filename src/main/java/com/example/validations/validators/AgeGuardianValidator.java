package com.example.validations.validators;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy=DevAgeGuardianValidator.class)
@Target({ElementType.TYPE})
@Retention(RUNTIME)
@Documented
public @interface AgeGuardianValidator
{
	String message() default("Validation Failed");
	
	Class<?>[] groups() default{};
	
	Class<? extends Payload>[] payload()default{};

	String age();
	
	String guardian();
	
	@Target({ ElementType.TYPE })
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
		AgeGuardianValidator[] value();
    }

}

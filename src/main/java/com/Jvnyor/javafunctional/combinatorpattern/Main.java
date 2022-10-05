package com.Jvnyor.javafunctional.combinatorpattern;

import static com.Jvnyor.javafunctional.combinatorpattern.CustomerRegistrationValidator.isAnAdult;
import static com.Jvnyor.javafunctional.combinatorpattern.CustomerRegistrationValidator.isEmailValid;
import static com.Jvnyor.javafunctional.combinatorpattern.CustomerRegistrationValidator.isPhoneNumberValid;

import java.time.LocalDate;

import com.Jvnyor.javafunctional.combinatorpattern.CustomerRegistrationValidator.ValidationResult;

public class Main {
	public static void main(String[] args) {
		Customer customer = new Customer(
				"Alice",
				"alice@gmail.com",
				"+089879786879",
				LocalDate.of(2000, 1, 1)
		);
		
//		System.out.println(new CustomerValidatorService().isValid(customer));
		
		// if valid we can store customer in db
		
		// Using combinator pattern
		
		ValidationResult result = isEmailValid()
			.and(isPhoneNumberValid())
			.and(isAnAdult())
			.apply(customer);
		
		System.out.println(result);
		
		if (result != ValidationResult.SUCCESS) {
			throw new IllegalStateException(result.name());
		}
	}
}

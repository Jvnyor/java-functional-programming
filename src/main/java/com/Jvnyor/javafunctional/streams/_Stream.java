package com.Jvnyor.javafunctional.streams;

import java.util.List;
import java.util.function.Predicate;

public class _Stream {
	public static void main(String[] args) {
		List<Person> people = List.of(
				new Person("John", Gender.MALE),
				new Person("Maria", Gender.FEMALE),
				new Person("Aisha", Gender.FEMALE),
				new Person("Alex", Gender.MALE),
				new Person("Alice", Gender.FEMALE)
		);
		
//		people.stream()
//			.map(person -> person.name)
//			.mapToInt(String::length)
//			.forEach(System.out::println);
		
		Predicate<Person> personPredicate = person -> Gender.PREFER_NOT_TO_SAY.equals(person.gender);
		boolean constainsOnlyFemales = people.stream()
			.noneMatch(personPredicate);
		
		System.out.println(constainsOnlyFemales);
	}
	
	static class Person {
		private final String name;
		private final Gender gender;

		public Person(String name, Gender gender) {
			this.name = name;
			this.gender = gender;
		}

		@Override
		public String toString() {
			return "Person [name=" + name + ", gender=" + gender + "]";
		}
	}
	
	enum Gender {
		MALE, FEMALE, PREFER_NOT_TO_SAY
	}
}

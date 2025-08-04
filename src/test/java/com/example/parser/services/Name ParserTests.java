package com.example.parser.services;

import org.apache.commons.logging.Log;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class NameParserTests {
	private final INameParser nameParser = new NameParser();


	@Test
	@DisplayName("Should parse last-name-first format")
	void lastNameFirstTest() throws Exception{
		//Arrange
		String case1 = "Doe, John";
		String case2 = "Kristensen, P. H.";

		//Act
		var result1 = nameParser.parseFullName(case1);
		var result2 = nameParser.parseFullName(case2);

		//Assert
		//To check manually:
		//System.out.println("First Name: "+ result1.getFirstName() + "\nLast Name: " + result1.getLastName());
		//System.out.println("First Name: "+ result2.getFirstName() + "\nLast Name: " + result2.getLastName());

		assertThat(result1)
				.isNotNull()
				.satisfies(a -> {
					assertThat(result1.getFirstName()).isEqualTo("John");
					assertThat(result1.getLastName()).isEqualTo("Doe");
				});
		assertThat(result2)
				.isNotNull()
				.satisfies(a -> {
					assertThat(result2.getFirstName()).isEqualTo("P. H.");
					assertThat(result2.getLastName()).isEqualTo("Kristensen");
				});
	}

	@Test
	@DisplayName("Should parse first-name-first format")
	void firstNameFirstTest() throws Exception{
		//Arrange
		String case1 = "John Doe";
		String case2 = "Hans-Christian Jensen";
		String case3 = "P. H. Kristensen";
		String case4 = "Peter Hans Kristensen";

		//Act
		var result1 = nameParser.parseFullName(case1);
		var result2 = nameParser.parseFullName(case2);
		var result3 = nameParser.parseFullName(case3);
		var result4 = nameParser.parseFullName(case4);

		//Assert
		//To check manually:
		//System.out.println("First Name: "+ result1.getFirstName() + "\nLast Name: " + result1.getLastName());
		//System.out.println("First Name: "+ result2.getFirstName() + "\nLast Name: " + result2.getLastName());
		//System.out.println("First Name: "+ result3.getFirstName() + "\nLast Name: " + result3.getLastName());
		//System.out.println("First Name: "+ result4.getFirstName() + "\nLast Name: " + result4.getLastName());

		assertThat(result1)
				.isNotNull()
				.satisfies(a -> {
					assertThat(result1.getFirstName()).isEqualTo("John");
					assertThat(result1.getLastName()).isEqualTo("Doe");
				});
		assertThat(result2)
				.isNotNull()
				.satisfies(a -> {
					assertThat(result2.getFirstName()).isEqualTo("Hans-Christian");
					assertThat(result2.getLastName()).isEqualTo("Jensen");
				});
		assertThat(result3)
				.isNotNull()
				.satisfies(a -> {
					assertThat(result3.getFirstName()).isEqualTo("P. H.");
					assertThat(result3.getLastName()).isEqualTo("Kristensen");
				});
		assertThat(result4)
				.isNotNull()
				.satisfies(a -> {
					assertThat(result4.getFirstName()).isEqualTo("Peter Hans");
					assertThat(result4.getLastName()).isEqualTo("Kristensen");
				});
	}
}

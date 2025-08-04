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
	void contextLoads() {
	}

	@Test
	@DisplayName("Should parse last-name-first format")
	void lastNameFirstTest() throws Exception{
		var result1 = nameParser.parseFullName("Doe, John");
		var result2 = nameParser.parseFullName("Kristensen, P. H.");

		//To check manually:
		//System.out.println("First Name: "+ result1.firstName + "\nLast Name: " + result1.lastName);
		//System.out.println("First Name: "+ result2.firstName + "\nLast Name: " + result2.lastName);

		assertThat(result1.getFirstName()).isEqualTo("John");
		assertThat(result1.getLastName()).isEqualTo("Doe");
		assertThat(result2.getFirstName()).isEqualTo("P. H.");
		assertThat(result2.getLastName()).isEqualTo("Kristensen");
	}

	@Test
	@DisplayName("Should parse simple first-name-first format")
	void firstNameFirstTest() throws Exception{
		var result1 = nameParser.parseFullName("John Doe");
		var result2 = nameParser.parseFullName("Hans-Christian Jensen");
		var result3 = nameParser.parseFullName("P. H. Kristensen");
		var result4 = nameParser.parseFullName("Peter Hans Kristensen");

		//To check manually:
		//System.out.println("First Name: "+ result1.firstName + "\nLast Name: " + result1.lastName);
		//System.out.println("First Name: "+ result2.firstName + "\nLast Name: " + result2.lastName);
		//System.out.println("First Name: "+ result3.firstName + "\nLast Name: " + result3.lastName);
		//System.out.println("First Name: "+ result4.firstName + "\nLast Name: " + result4.lastName);

		assertThat(result1.getFirstName()).isEqualTo("John");
		assertThat(result1.getLastName()).isEqualTo("Doe");
		assertThat(result2.getFirstName()).isEqualTo("Hans-Christian");
		assertThat(result2.getLastName()).isEqualTo("Jensen");
		assertThat(result3.getFirstName()).isEqualTo("P. H.");
		assertThat(result3.getLastName()).isEqualTo("Kristensen");
		assertThat(result4.getFirstName()).isEqualTo("Peter Hans");
		assertThat(result4.getLastName()).isEqualTo("Kristensen");
	}
}

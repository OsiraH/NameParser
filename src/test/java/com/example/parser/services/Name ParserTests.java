package com.example.parser.services;

import org.apache.commons.logging.Log;
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
	void lastNameFirstTest() throws Exception{
		var result1 = nameParser.parseFullName("Doe, John");
		var result2 = nameParser.parseFullName("Kristensen, P. H.");

		//To check manually:
		//System.out.println("First Name: "+ result1.firstName + "\nLast Name: " + result1.lastName);
		//System.out.println("First Name: "+ result2.firstName + "\nLast Name: " + result2.lastName);

		assertThat(result1.firstName).isEqualTo("John");
		assertThat(result1.lastName).isEqualTo("Doe");
		assertThat(result2.firstName).isEqualTo("P. H.");
		assertThat(result2.lastName).isEqualTo("Kristensen");
	}

	@Test
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

		assertThat(result1.firstName).isEqualTo("John");
		assertThat(result1.lastName).isEqualTo("Doe");
		assertThat(result2.firstName).isEqualTo("Hans-Christian");
		assertThat(result2.lastName).isEqualTo("Jensen");
		assertThat(result3.firstName).isEqualTo("P. H.");
		assertThat(result3.lastName).isEqualTo("Kristensen");
		assertThat(result4.firstName).isEqualTo("Peter Hans");
		assertThat(result4.lastName).isEqualTo("Kristensen");
	}
}

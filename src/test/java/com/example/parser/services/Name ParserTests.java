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
		//System.out.println(result1);
		//System.out.println(result2);

		assertThat(result1).isEqualTo("First Name: John\nLast Name: Doe");
		assertThat(result2).isEqualTo("First Name: P. H.\nLast Name: Kristensen");
	}

	@Test
	void firstNameFirstTest() throws Exception{
		var result1 = nameParser.parseFullName("John Doe");
		var result2 = nameParser.parseFullName("Hans-Christian Jensen");
		var result3 = nameParser.parseFullName("P. H. Kristensen");
		var result4 = nameParser.parseFullName("Peter Hans Kristensen");

		//To check manually:
		//System.out.println(result1);
		//System.out.println(result2);
		//System.out.println(result3);
		//System.out.println(result4);

		assertThat(result1).isEqualTo("First Name: John\nLast Name: Doe");
		assertThat(result2).isEqualTo("First Name: Hans-Christian\nLast Name: Jensen");
		assertThat(result3).isEqualTo("First Name: P. H.\nLast Name: Kristensen");
		assertThat(result4).isEqualTo("First Name: Peter Hans\nLast Name: Kristensen");
	}
}

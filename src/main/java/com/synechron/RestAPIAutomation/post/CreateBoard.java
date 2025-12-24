package com.synechron.RestAPIAutomation.post;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.synechron.RestAPIAutomation.data.GlobalVariables;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateBoard {
	
	@Test
	public void createBoard()
	{
		System.out.println("Creating a Board using REST API!!1");
		
		RestAssured.baseURI = "https://api.trello.com";
		
		RestAssured.
			given().
				param("key", GlobalVariables.key).
				param("token", GlobalVariables.token).
				param("name", "Eclise-REST-Board").
			when().
				post("/1/boards/").
			then().
				assertThat().statusCode(200).and().
				contentType(ContentType.JSON).and().
				body("name", Matchers.equalTo("Eclise-REST-Board"));
				
		
		System.out.println("Board Created Successfully");
				
	}

}

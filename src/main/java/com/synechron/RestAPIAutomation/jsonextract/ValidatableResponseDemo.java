package com.synechron.RestAPIAutomation.jsonextract;

import org.testng.annotations.Test;

import com.synechron.RestAPIAutomation.data.GlobalVariables;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class ValidatableResponseDemo {

	
	@Test
	public void validateJsonUsingDefaultLibs()
	{
		System.out.println("Starting API CALL");
		  ValidatableResponse vResponse = RestAssured.
		given().
			param("key", GlobalVariables.key).
			param("token", GlobalVariables.token).
		when()
			.get("https://api.trello.com/1/boards/" + GlobalVariables.board_id).
		then().
			assertThat().statusCode(200).log().body();
		  
		 
		  System.out.println("ID " + vResponse.extract().path("id"));
		  System.out.println("NAME " + vResponse.extract().path("name"));
		  System.out.println("PREFS  " + vResponse.extract().path("prefs"));
		
		
	}
}

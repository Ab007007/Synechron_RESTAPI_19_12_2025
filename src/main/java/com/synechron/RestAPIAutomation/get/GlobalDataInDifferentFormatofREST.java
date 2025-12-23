package com.synechron.RestAPIAutomation.get;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.synechron.RestAPIAutomation.data.GlobalVariables;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class GlobalDataInDifferentFormatofREST {

	@BeforeMethod
	public void setGlobalVariables()
	{
		RestAssured.baseURI = "https://api.trello.com";
		RestAssured.basePath = "/1/boards/" + GlobalVariables.board_id;
		
	}
	
	@AfterMethod
	public void resetGlobalVariables()
	{
		RestAssured.reset();
	}
	
	@Test
	public void bddFormat() {
		System.out.println("Starting API CALL");
		RestAssured.
		given().
			param("key", GlobalVariables.key).
			param("token", GlobalVariables.token).
		when()
			.get().
		then().
			assertThat().statusCode(200);

		System.out.println("API Call success!!!");
	}

	@Test
	public void RestFormt() {
		System.out.println("Rest assured format - Start");
		RequestSpecification rSpec = RestAssured.given();
		rSpec.param("key", GlobalVariables.key);
		rSpec.param("token", GlobalVariables.token);

		Response res = rSpec.get();

		res.prettyPrint();

		ValidatableResponse validatableResponse = res.then();
		validatableResponse.statusCode(200);
		System.out.println("Rest assured format - End");
	}

	@Test
	public void givenExpect() {
		System.out.println("Starting API CALL");
		RestAssured.given().param("key", GlobalVariables.key).param("token", GlobalVariables.token).expect()
				.statusCode(200).when().get();

		System.out.println("API Call success!!!");
	}
}

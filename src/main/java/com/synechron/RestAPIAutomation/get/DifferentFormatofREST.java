package com.synechron.RestAPIAutomation.get;

import org.testng.annotations.Test;

import com.synechron.RestAPIAutomation.data.GlobalVariables;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class DifferentFormatofREST {

	@Test
	public void bddFormat() {
		System.out.println("Starting API CALL");
		RestAssured.
		given().
			param("key", GlobalVariables.key).
			param("token", GlobalVariables.token).
		when()
			.get("https://api.trello.com/1/boards/" + GlobalVariables.board_id).
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

		Response res = rSpec.get("https://api.trello.com/1/boards/" + GlobalVariables.board_id);

		res.prettyPrint();

		ValidatableResponse validatableResponse = res.then();
		validatableResponse.statusCode(200);
		System.out.println("Rest assured format - End");
	}

	@Test
	public void givenExpect() {
		System.out.println("Starting API CALL");
		RestAssured.given().param("key", GlobalVariables.key).param("token", GlobalVariables.token).expect()
				.statusCode(200).when().get("https://api.trello.com/1/boards/" + GlobalVariables.board_id);

		System.out.println("API Call success!!!");
	}
}

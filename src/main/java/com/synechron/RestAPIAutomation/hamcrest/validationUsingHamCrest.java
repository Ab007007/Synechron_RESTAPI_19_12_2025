package com.synechron.RestAPIAutomation.hamcrest;

import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import org.testng.annotations.Test;

import com.synechron.RestAPIAutomation.data.GlobalVariables;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

public class validationUsingHamCrest {
	
	@Test
	public void validateJsonResponse() {
		System.out.println("Starting API CALL");
		RestAssured.
			given().
				param("key", GlobalVariables.key).
				param("token", GlobalVariables.token).
			when()
				.get("https://api.trello.com/1/boards/" + GlobalVariables.board_id).
			then().
				assertThat().statusCode(200)
				.body("prefs",hasKey("permissionLevel"));
		
		

	}
	
	@Test
	public void validateJsonResponseUsingFunction() {
		System.out.println("Starting API CALL");
		RestAssured.
			given().
				param("key", GlobalVariables.key).
				param("token", GlobalVariables.token).
			when()
				.get("https://api.trello.com/1/boards/" + GlobalVariables.board_id).
			then().
				assertThat().statusCode(200)
				.body("prefs.size()",equalTo(31))
				.body("prefs.size()",lessThan(50))
				.body("prefs.size()",greaterThan(25));
		
		System.out.println("validateJsonResponseUsingFunction--");

	}
	
	@Test
	public void hasEntryTest() {
		System.out.println("Starting API CALL");
		RestAssured.
			given().
				param("key", GlobalVariables.key).
				param("token", GlobalVariables.token).
			when()
				.get("https://api.trello.com/1/boards/" + GlobalVariables.board_id).
			then().
				assertThat().statusCode(200)
				.body("prefs",hasKey("permissionLevel"))
				.body("name",is("POSTMAN_BOARD"))
				.body("id", equalTo("6948f3c52b4c5928258baad8"))
				.body("prefs.switcherViews.viewType", hasItems("Board","Table"));
		
		System.out.println("validateJsonResponseUsingFunction--");

	}
	
	@Test
	public void validateEntireJson() throws JSONException, IOException {
		String actualJson = new String(Files.readAllBytes(Paths.get("response\\response.txt")));
		String responseJson = RestAssured.
		given().
			param("key", GlobalVariables.key).
			param("token", GlobalVariables.token).
		when()
			.get("https://api.trello.com/1/boards/" + GlobalVariables.board_id)
			.asString();
		
		JSONAssert.assertEquals(responseJson, actualJson, true);
		
	System.out.println("validateJsonResponseUsingFunction--");
	
	}


}

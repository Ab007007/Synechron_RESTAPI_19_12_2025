package com.synechron.RestAPIAutomation.log;

import org.testng.annotations.Test;

import com.synechron.RestAPIAutomation.data.GlobalVariables;

import io.restassured.RestAssured;

public class RestExecutionLogEnabled {

	
	
	//@Test
	public void logHeaders()
	{
		System.out.println("Starting API CALL");
		RestAssured.
			given().
				param("key", GlobalVariables.key).
				param("token", GlobalVariables.token).
				log().headers().
			when().
				get("https://api.trello.com/1/boards/" + GlobalVariables.board_id).
			then().
				assertThat().statusCode(200);
		
		System.out.println("API Call success!!!");
	}
	
	
	//@Test
	public void logParams()
	{
		System.out.println("Starting API CALL");
		RestAssured.
			given().
				param("key", GlobalVariables.key).
				param("token", GlobalVariables.token).
				log().headers().
				log().params().
			when().
				get("https://api.trello.com/1/boards/" + GlobalVariables.board_id).
			then().
				assertThat().statusCode(200);
		
		System.out.println("API Call success!!!");
	}
	
	
	//@Test
	public void logResponse()
	{
		System.out.println("Starting API CALL");
		RestAssured.
			given().
				param("key", GlobalVariables.key).
				param("token", GlobalVariables.token).
				log().headers().
				log().params().
			when().
				get("https://api.trello.com/1/boards/" + GlobalVariables.board_id).
			then().
				assertThat().statusCode(200).log().body();
		
		System.out.println("API Call success!!!");
	}
	
	
	@Test
	public void logEverything()
	{
		System.out.println("Starting API CALL");
		RestAssured.
			given().
				param("key", GlobalVariables.key).
				param("token", GlobalVariables.token).
				log().all().
			when().
				get("https://api.trello.com/1/boards/" + GlobalVariables.board_id).
			then().
				assertThat().statusCode(200).log().all();
		
		System.out.println("API Call success!!!");
	}
}

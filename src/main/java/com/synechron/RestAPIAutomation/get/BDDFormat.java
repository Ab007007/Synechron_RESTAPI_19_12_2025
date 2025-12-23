package com.synechron.RestAPIAutomation.get;

import com.synechron.RestAPIAutomation.data.GlobalVariables;

import io.restassured.RestAssured;

public class BDDFormat 
{
	public static void main(String[] args) 
	{
		System.out.println("Starting API CALL");
		RestAssured.
			given().
				param("key", GlobalVariables.key).
				param("token", GlobalVariables.token).
			when().
				get("https://api.trello.com/1/boards/" + GlobalVariables.board_id).
			then().
				assertThat().statusCode(200);
		
		System.out.println("API Call success!!!");
	}
}

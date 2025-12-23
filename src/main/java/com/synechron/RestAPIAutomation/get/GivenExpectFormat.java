package com.synechron.RestAPIAutomation.get;

import com.synechron.RestAPIAutomation.data.GlobalVariables;

import io.restassured.RestAssured;

public class GivenExpectFormat {
	public static void main(String[] args) {
		System.out.println("Starting API CALL");
		RestAssured.
			given().
				param("key", GlobalVariables.key).
				param("token", GlobalVariables.token).
			expect().
				statusCode(200).
			when().
				get("https://api.trello.com/1/boards/" + GlobalVariables.board_id);
			
		
		System.out.println("API Call success!!!");
	}
}

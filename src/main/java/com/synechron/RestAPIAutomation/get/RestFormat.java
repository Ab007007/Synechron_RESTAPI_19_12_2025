package com.synechron.RestAPIAutomation.get;

import com.synechron.RestAPIAutomation.data.GlobalVariables;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class RestFormat 
{
	public static void main(String[] args) {
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

}

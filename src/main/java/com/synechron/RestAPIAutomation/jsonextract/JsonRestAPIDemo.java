package com.synechron.RestAPIAutomation.jsonextract;

import org.testng.annotations.Test;

import com.synechron.RestAPIAutomation.data.GlobalVariables;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JsonRestAPIDemo {
	

	@Test
	public void validateJsonUsingDefaultLibs()
	{
		System.out.println("Starting API CALL");
		Response response = RestAssured.
		given().
			param("key", GlobalVariables.key).
			param("token", GlobalVariables.token).
		when()
			.get("https://api.trello.com/1/boards/" + GlobalVariables.board_id).
		then().
			assertThat().statusCode(200).extract().response();
		
		String strResponse = response.asString();
		
		JsonPath responseBody = new JsonPath(strResponse);
		
		
		System.out.println(" ID " + responseBody.get("id"));
		System.out.println(" NAME " + responseBody.get("name"));
		
	}

}

package com.synechron.RestAPIAutomation.jsonextract;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;
import com.synechron.RestAPIAutomation.data.GlobalVariables;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class JsonJaywayPathDemo 
{
	@Test
	public void bddFormat() {
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
		
		Map<String, ?> rootElement = JsonPath.read(strResponse, "$");
		System.out.println("complete Response " + rootElement);
		
		String id = JsonPath.read(strResponse,"$.id");
		System.out.println("Printing ID " + id);
		
		List<Map<String,?>> backgroundData= JsonPath.read(strResponse,"$.prefs.backgroundImageScaled[*]");
		System.out.println("Printing background Scaled Image Data " );
		
		for (Map<String, ?> item : backgroundData) 
		{
			System.out.println(item);
			
		}
		
		System.out.println("Printing URL " );
		List<String> urls = JsonPath.read(strResponse, "$..url");
		
		for (String url : urls) {
			System.out.println("URL : " + url);
		}
		

		System.out.println("Printing height greater than 1000 " );
		List<Integer> height = JsonPath.read(strResponse, "$.prefs.backgroundImageScaled[*].[?(@.height > 1000)].height");
		
		for (Integer h : height) {
			System.out.println(h);
		}
		

		System.out.println("API Call success!!!");
	}

}

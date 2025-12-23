package com.synechron.RestAPIAutomation.get;

import java.awt.font.GlyphJustificationInfo;

import org.testng.annotations.Test;

import com.synechron.RestAPIAutomation.data.GlobalVariables;

import io.restassured.RestAssured;

public class GetWithGlibalData 
{
	@Test
	public void getRequestWithGlobalVariables()
	{
		RestAssured.baseURI = "https://api.trello.com";
		RestAssured.basePath = "/1/boards/" + GlobalVariables.board_id;
		
		RestAssured.
		given()
			.param("key", GlobalVariables.key)
			.param("token", GlobalVariables.token).
		when().
			get().
		then().
			assertThat().statusCode(200);
			
	}

}

package com.synechron.RestAPIAutomation.delete;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.synechron.RestAPIAutomation.data.GlobalVariables;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class DeleteAPI {

	
	@Test
	public void deleteRepository()
	{
		RestAssured.
		given().
			headers("Authorization",GlobalVariables.git_bearerToken).
			headers("content-type","application/json").
		when().
			delete("https://api.github.com/repos/Ab007007/" + GlobalVariables.git_repo_name).
		then().
			assertThat().statusCode(204).log().all();
	}
	
}

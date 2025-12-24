package com.synechron.RestAPIAutomation.post;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.synechron.RestAPIAutomation.data.GlobalVariables;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class createRepository {
	
	
	
	@Test
	public void createRepository()
	{
		//create repo
		RestAssured.
			given().
				headers("Authorization",GlobalVariables.git_bearerToken).
				headers("content-type","application/json").
				body("{"
						+ "\"name\":\"PostMan-Synechron-RepoFromEclipse\","
						+ "\"description\":\"Description - PostMan-Synechron-Repo\""
						+ "}").
			when().
				post("https://api.github.com/user/repos").
			then().
				assertThat().statusCode(201).and().
				contentType(ContentType.JSON).and().
				body("name", Matchers.equalTo("PostMan-Synechron-RepoFromEclipse"));
			
	}

}

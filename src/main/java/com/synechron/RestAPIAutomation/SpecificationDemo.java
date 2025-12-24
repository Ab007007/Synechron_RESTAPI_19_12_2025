package com.synechron.RestAPIAutomation;

import org.apache.http.client.methods.RequestBuilder;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.synechron.RestAPIAutomation.data.GlobalVariables;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecificationDemo extends BaseClass{
	
	
	
	
//	@Test
	public void getRepository()
	{
		RestAssured.
		given().
			headers("Authorization",GlobalVariables.git_bearerToken).
			headers("content-type","application/json").
		when().
			get("https://api.github.com/repos/Ab007007/" + GlobalVariables.git_repo_name).
		then().
			assertThat().statusCode(200).log().all().and().
			contentType(ContentType.JSON).and().
			body("name", Matchers.equalTo(GlobalVariables.git_repo_name));
	}
	
	
	@Test
	public void getRepositoryUsingSpec()
	{
		RestAssured.
			given().
				spec(reqSpec).
			when().
				get("repos/Ab007007/" + GlobalVariables.git_repo_name).
			then().
				spec(resSpec);
	}
}

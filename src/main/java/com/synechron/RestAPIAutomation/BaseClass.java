package com.synechron.RestAPIAutomation;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;

import com.synechron.RestAPIAutomation.data.GlobalVariables;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseClass {

	public RequestSpecification reqSpec;
	public RequestSpecBuilder reqBuilder;
	
	
	public ResponseSpecification resSpec;
	public ResponseSpecBuilder resBuilder;
	
	
	@BeforeMethod
	public void setup() 
	{
		RestAssured.baseURI = "https://api.github.com/";
		//RestAssured.basePath = "repos/Ab007007/" + GlobalVariables.git_repo_name;
		
		
		System.out.println("########################################");
		reqBuilder = new RequestSpecBuilder();
		reqBuilder.addHeader("Authorization",GlobalVariables.git_bearerToken);
		reqBuilder.addHeader("content-type","application/json");
		reqBuilder.addHeader("Accept","application/vnd.github+json");
		reqSpec = reqBuilder.build();
		
		resBuilder = new ResponseSpecBuilder();
		resBuilder.expectStatusCode(200);
		resBuilder.expectHeader("Server", "github.com");
		resBuilder.expectHeader("Content-Type", "application/json; charset=utf-8");
		resBuilder.expectBody("name", Matchers.equalTo(GlobalVariables.git_repo_name));
		resSpec = resBuilder.build();
	}
}

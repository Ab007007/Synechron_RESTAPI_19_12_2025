package com.synechron.RestAPIAutomation.post;

import org.checkerframework.checker.units.qual.g;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.synechron.RestAPIAutomation.data.GlobalVariables;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import pojo.GitRepoPOJO;

public class createRepositoryusingPOJO {
	
	public GitRepoPOJO gObj = null;
	
	
	@BeforeMethod
	public void initializeObject()
	{
		gObj = new GitRepoPOJO();
		gObj.setName("GitRepoUsingPOJO123");
		gObj.setDesc("Desc - GitRepoUsingPOJO123");
	}
	
	@Test
	public void createRepository()
	{
		//create repo
		RestAssured.
			given().
				headers("Authorization",GlobalVariables.git_bearerToken).
				headers("content-type","application/json").
				body(gObj).
			when().
				post("https://api.github.com/user/repos").
			then().
				assertThat().statusCode(201).and().
				contentType(ContentType.JSON).and().
				body("name", Matchers.equalTo(gObj.getName()));
			
	}

}

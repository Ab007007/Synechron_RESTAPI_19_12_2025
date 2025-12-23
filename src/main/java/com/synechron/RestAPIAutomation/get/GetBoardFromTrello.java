package com.synechron.RestAPIAutomation.get;

import io.restassured.RestAssured;

public class GetBoardFromTrello 
{
	public static void main(String[] args) 
	{
		System.out.println("Starting API CALL");
		RestAssured.
			given().
				param("key", "1bff59ce7cd74e9b9670a5593b785677").
				param("token", "ATTA2fd709c6a3fa855ac7fb479c8c3a102ee0ecdaf8f1bcda27996c3c23b7c4592407623E68").
			when().
				get("https://api.trello.com/1/boards/6948f3c52b4c5928258baad8").
			then().
				assertThat().statusCode(200);
		
		System.out.println("API Call success!!!");
	}
}

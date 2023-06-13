package com.testng;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSenderOptions;
import io.restassured.specification.RequestSpecification;
import netscape.javascript.JSObject;

public class APIDEMO {
	
	
	 @Test
	    public void RegistrationSuccessful() {
	        RestAssured.baseURI = "https://bookstore.toolsqa.com";
	        RequestSpecification request = RestAssured.given();

	        JSONObject requestParams = new JSONObject();
	        /*I have put a unique username and password as below,
	        you can enter any as per your liking. */
	        requestParams.put("UserName", "TOOLSQA-Test");
	        requestParams.put("Password", "Test@@123");

	        request.body(requestParams.toString());
	        Response response = request.post("/Account/v1/User");
	        System.out.println("response:  "+response);
	        Assert.assertEquals(response.getStatusCode(), 201);
	        // We will need the userID in the response body for our tests, please save it in a local variable
	        String userID = response.getBody().jsonPath().getString("userID");
	        System.out.println("userID:  "+userID);
	        
	    }

    public static void main(String[] args) {
        String userID = "9b5f49ab-eea9-45f4-9d66-bcf56a531b85";
        String userName = "TOOLSQA-Test";
        String password = "Test@@123";
        String baseUrl = "https://bookstore.toolsqa.com";

        RestAssured.baseURI = baseUrl;
        RequestSpecification request = RestAssured.given();


        //Step - 1
        //Test will start from generating Token for Authorization
        request.header("Content-Type", "application/json");

        Response response = request.body("{ \"userName\":\"" + userName + "\", \"password\":\"" + password + "\"}")
                .post("/Account/v1/GenerateToken");
        System.out.println("response-200:    "+response);
        Assert.assertEquals(response.getStatusCode(), 200);

        String jsonString = response.asString();
        Assert.assertTrue(jsonString.contains("token"));

        //This token will be used in later requests
        String token = JsonPath.from(jsonString).get("token");
        System.out.println("token-200:    "+token);

        //Step - 2
        // Get Books - No Auth is required for this.
        response = request.get("/BookStore/v1/Books");

        Assert.assertEquals(response.getStatusCode(), 200);

        jsonString = response.asString();
        List<Map<String, String>> books = JsonPath.from(jsonString).get("books");
        Assert.assertTrue(books.size() > 0);

         //This bookId will be used in later requests, to add the book with respective isbn
        String bookId = books.get(0).get("isbn");


        //Step - 3
        // Add a book - with Auth
        //The token we had saved in the variable before from response in Step 1, 
        //we will be passing in the headers for each of the succeeding request
        request.header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");
        System.out.println("bookID-200:    "+bookId);
        response = request.body("{ \"userId\": \"" + userID + "\", " +
                "\"collectionOfIsbns\": [ { \"isbn\": \"" + bookId + "\" } ]}")
                .post("/BookStore/v1/Books");
        System.out.println("getStatusCode-200:    "+response.getStatusCode());
        Assert.assertEquals( 201, response.getStatusCode()); //401

/*
        //Step - 4
        // Delete a book - with Auth
        request.header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");

        response = request.body("{ \"isbn\": \"" + bookId + "\", \"userId\": \"" + userID + "\"}")
                .delete("/BookStore/v1/Book");

        Assert.assertEquals(204, response.getStatusCode());

        //Step - 5
        // Get User
        request.header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");

        response = request.get("/Account/v1/User/" + userID);
        Assert.assertEquals(200, response.getStatusCode());

        jsonString = response.asString();
        List<Map<String, String>> booksOfUser = JsonPath.from(jsonString).get("books");
        Assert.assertEquals(0, booksOfUser.size()); */
    }
}
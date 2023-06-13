package com.testng;
import java.util.ArrayList;

import org.junit.Assert;

import static io.restassured.RestAssured.*;
import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class APIDEMO2 {

   final static String url="http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1";

   public static void main(String args[]) {

     getResponseBody();
     System.out.println("*****");
     getResponseStatus();

; }

   //This will fetch the response body as is and log it. given and when are optional here
   public static void getResponseBody(){
       given().when().get(url).then().log()
      .all();

  given().queryParam("CUSTOMER_ID","68195")
               .queryParam("PASSWORD","1234!")
               .queryParam("Account_No","1") .when().get("http://demo.guru99.com/V4/sinkministatement.php").then().log().body();
   }

public static void getResponseStatus(){
   int statusCode= given().queryParam("CUSTOMER_ID","68195")
           .queryParam("PASSWORD","1234!")
           .queryParam("Account_No","1")
           .when().get("http://demo.guru99.com/V4/sinkministatement.php").getStatusCode();
   System.out.println("The response status is "+statusCode);
   
   String sessionID= given().queryParam("CUSTOMER_ID","68195")
           .queryParam("PASSWORD","1234!")
           .queryParam("Account_No","1")
           .when().get("http://demo.guru99.com/V4/sinkministatement.php").getSessionId();
   System.out.println("The sessionID is "+sessionID);
   
   String statusLine= given().queryParam("CUSTOMER_ID","68195")
           .queryParam("PASSWORD","1234!")
           .queryParam("Account_No","1")
           .when().get("http://demo.guru99.com/V4/sinkministatement.php").getStatusLine();
   System.out.println("The statusLine is "+statusLine);
   

   Assert.assertEquals(statusCode, 200);
//   given().when().get(url).then().assertThat().statusCode(200);
}

}
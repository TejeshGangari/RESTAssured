package testCases;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import base.BaseClass;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestClass extends BaseClass {

	RequestSpecification httpRequest;
	Response httpResponse;
	
	@Test(enabled = false )
	public void sampleGETCall() {
		RestAssured.baseURI = prop.getProperty("GETURL");
		httpRequest = RestAssured.given();
		httpResponse = httpRequest.get("/Hyderabad");
		Headers headers = httpResponse.headers();
		for(Header header:headers) {
			System.out.printf("%10s %50s",header.getName(), header.getValue());
			System.out.println();
		}
		
		JsonPath jsonObj = httpResponse.body().jsonPath();
		System.out.println(jsonObj.prettify());
	} 
	
	@Test
	public void samplePOSTCall() {
		JSONObject reqParms = new JSONObject();
		reqParms.put("FirstName", "Tejesh");
		reqParms.put("LastName", "Gangari");
		reqParms.put("UserName", "TejeshG");
		reqParms.put("Password", "password1");
		RestAssured.baseURI = prop.getProperty("POSTURL");
		httpRequest = RestAssured.given();
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(reqParms.toJSONString());
		httpResponse = httpRequest.post("/register");
		System.out.println(httpResponse.getStatusCode());
		System.out.println(httpResponse.body().asString());
		
	}
}

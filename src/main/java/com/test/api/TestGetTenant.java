package com.test.api;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import java.io.IOException;

import org.springframework.test.context.TestExecutionListeners;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.test.utility.ExtentReportListener;
import com.test.utility.manageConfig;

public class TestGetTenant extends ExtentReportListener{

	
	private String baseURI;
	
	private String jAuthToken;
	
	
	@BeforeMethod()
	public void setup() throws IOException {
		
		 baseURI =manageConfig.GetTenantUrl();
		
		 jAuthToken="Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIxYmEyNTRlOS0zYTY2LTQ2NTgtYTIxMC0yZGFlZmJjN2IwNzAiLCJzdWIiOiJib290c3RyYXAuYWRtaW4iLCJ0dmNVc2VyIjp7InRlbmFudElkIjoiN2EyY2E3NDAtZGZmZi00MzU3LWE2MDctNTZlMWExNTI0ZjA4IiwidXNlckluZm9JZCI6IjAwMDAwMDAwLTAwMDAtMDAwMC0wMDAwLTAwMDAwMDAwMDAwMSIsImJ1c2luZXNzVW5pdElkIjpudWxsLCJncmFudHMiOlt7InJvbGVJZCI6ImJmMjc3YWNlLTA5ZWEtNGU1ZC1hMjc5LTE0MGIyNzdjMTViMSIsImZlYXR1cmVzIjpbIldFQl9MT0dJTiIsIkNVU1RPTUVSX1BST1ZJU0lPTklORyIsIkRDX1NISVBNRU5UX1NIUF9TT1VSQ0VfQlVfTUFOQUdFIiwiRENfU0hJUE1FTlRfU0hQX1NPVVJDRV9CVV9WSUVXIiwiRklMRV9VUExPQURfQ09ORklHIiwiQlVTSU5FU1NfVU5JVF9QUk9WSVNJT05JTkciLCJEQ19SRUNFSVZJTkdfU0hJUE1FTlRfU09VUkNFX0JVX01BTkFHRSIsIlBBU1NXT1JEX1JFQ09WRVJZIiwiQ09OVEFDVF9NQU5BR0VNRU5UIiwiT1JERVJfQ0FMTEJBQ0tfTUFOQUdFTUVOVCIsIlVTRVJfTUFOQUdFTUVOVCIsIkNPTkZJR1VSQVRJT05fTUFOQUdFTUVOVCIsIlRPS0VOX1JFVk9DQVRJT04iLCJVU0VSX1BBU1NXT1JEX01BTkFHRU1FTlQiLCJEQ19SRUNFSVZJTkdfU0hJUE1FTlRfU09VUkNFX0JVX1ZJRVciLCJTRUNVUklUWV9NSUdSQVRJT05fTUFOQUdFTUVOVCIsIkRFVl9QT1JUQUxfQVBQU19NQU5BR0VNRU5UIiwiR0VUX0ZJTEVfVVBMT0FEX0NPTkZJRyIsIk1BVENIX0NST04iXSwiY29udGV4dExldmVsIjoiQ1VTVE9NRVIiLCJjb250ZXh0cyI6W10sInJvbGVOYW1lIjoiSkNJIEFkbWluIiwiY29udGV4dEJ1c2luZXNzVW5pdElkcyI6W10sImNvbnRleHRUZW5hbnRJZHMiOltdLCJjb250ZXh0U2l0ZUlkcyI6W119XSwiYmVhcmVyVG9rZW5WYWx1ZSI6bnVsbCwiZW1haWwiOiJib290c3RyYXAuYWRtaW5AamNpLmNvbSJ9LCJleHAiOjE2NDMyMTkwNjZ9.lJG2xW_zwfN6EQom8Mz-8-TkrjEuLy4KHxQrZ0ng-HORPEnFUDnd2XrczO64aMsdIMttcWHIiFK6tnN2o4cI_g";
		 
	}
	
	
	@Test(description="Getting Tenant List")
	public  void getTenantList() {
		
		
		String resUrl= baseURI+"/tenants";
		
		RestAssured.baseURI= resUrl;
		
		RequestSpecification request = RestAssured.given();
		//request.queryParam("businessUnitId", "b9c53b13-a5d0-4d3f-9095-9c9a22043b99");
		request.headers("Authorization",jAuthToken);
		
		Response response=  request.get(resUrl);
		
	    ResponseBody  body = response.getBody();
	
	    System.out.println(body.prettyPrint());
		
		/*
		 * given().queryParam("businessUnitId", "b9c53b13-a5d0-4d3f-9095-9c9a22043b99").
		 * and().headers("Authorization",AuthToken). when().get(baseURI).
		 * then().assertThat().statusCode(200).and().contentType(ContentType.JSON);
		 */
		
		System.out.println("Get Tenant list call executed successfully");
		
		JsonPath bodyasString = body.jsonPath();
		
		int  numberOfElements = bodyasString.get("numberOfElements");
		
		System.out.println(numberOfElements);
		
		Assert.assertTrue(numberOfElements>=0, "Get Tenant List fails");
		
	}
	
	@Test(description="getting tenant info using tenant Id")
	public  void getTenantListByTenantID() {
		String tenantID= "5e42bb5a-d802-486b-99a2-347531508588";
		
		String resUrl= baseURI+"/tenants/"+tenantID;
		
		RestAssured.baseURI= resUrl;
		
		
		
		RequestSpecification request = RestAssured.given();
	
		//request.queryParam("businessUnitId", "b9c53b13-a5d0-4d3f-9095-9c9a22043b99");
		request.headers("Authorization",jAuthToken);
		
		Response response=  request.get(resUrl);
		
	    ResponseBody  body = response.getBody();
	
	    System.out.println(body.prettyPrint());
	    
	    Assert.assertEquals(response.getStatusCode(),200,"Failed to fetch Tenant Info");
		

		
	}
	
}

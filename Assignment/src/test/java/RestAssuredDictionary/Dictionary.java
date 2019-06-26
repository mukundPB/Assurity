package RestAssuredDictionary;


import com.fasterxml.jackson.databind.JsonNode;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

import Utilities.ConfigProperties;

public class Dictionary {
	Utilities.ConfigProperties config=new Utilities.ConfigProperties();
	
	/******************************************************************************
	 * Get  response json of the  for location search
	 ******************************************************************************/
	public JsonNode genericGetCatalog(String cataloguevalue)
	{
 System.out.print(config.getURL());
	Response response=RestAssured.given().params("catalogue",cataloguevalue).
			get(config.getURL()).then().extract().response();
			JsonNode responseJson = response.getBody().as(JsonNode.class);
			return responseJson;
	}
	

	
}

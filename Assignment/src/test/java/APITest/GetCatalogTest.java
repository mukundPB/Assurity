package APITest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;

import RestAssuredDictionary.Dictionary;

public class GetCatalogTest {
	Utilities.ConfigProperties config=new Utilities.ConfigProperties();
	Dictionary dict=new Dictionary();
	
	
	@Test(priority=1,description="acceptance test")
	public void getAcceptanceTest()
	{
		JsonNode response=dict.genericGetCatalog(config.getCatalog());
		Assert.assertEquals(response.get("Name").toString(),config.getName());
		Assert.assertEquals(response.get("CanRelist").toString(),config.getCanRelist());
		Assert.assertEquals(response.get("Promotions").get(1).get("Name").toString(),config.getDescname());
		Assert.assertTrue(response.get("Promotions").get(1).get("Description").toString().contains(config.getDescription()));
	}

}
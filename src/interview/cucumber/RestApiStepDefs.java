package interview.cucumber;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;

import com.google.gson.JsonParser;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestApiStepDefs {

	@Given("^the system knows about the following fruit:$")
	public void theSystemKnowsAboutTheFollowingFruit(DataTable data) throws Throwable {
		// Here we can learn about converting Data Table into Maps
		List<Map<String, String>> content = data.asMaps(String.class, String.class);
		for (Map<String, String> row : content) {
			for (Entry<String, String> entry : row.entrySet()) {
				String key = entry.getKey();
				String value = entry.getValue();
				System.out.println("KEY is : " + key + " & VALUE is : " + value);
			}
		}
	}

	@When("^the client requests GET /fruits$")
	public void theClientRequestsGETFruits() throws Throwable {
		RestAssured.baseURI = "http://restapi.demoqa.com/fruits";
		RequestSpecification httpRequest = RestAssured.given();
		@SuppressWarnings("unused")
		Response response = httpRequest.request(Method.GET, "/FreshFruits");
	}

	@Then("^the response should be JSON:$")
	public void theResponseShouldBeJSON(String jsonExpected) throws Throwable {
		String jsonFruit = "[ {\"name\": \"banana\", \"color\": \"yellow\"}, {\"name\": \"strawberry\", \"color\": \"red\"} ]";
		JsonParser parser = new JsonParser();
		Assert.assertEquals("Unexpected JSON.", parser.parse(jsonExpected), parser.parse(jsonFruit));
	}
}

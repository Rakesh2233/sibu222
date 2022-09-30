package withOutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProject {
	@Test
	public void createProjectTest() {
		JSONObject job = new JSONObject();
		job.put("createdBy","rocky");
		job.put("projectName", "asdfgk");
		RequestSpecification req = RestAssured.given();
		req.body(job).contentType(ContentType.JSON);
		Response resp = req.post("http://localhost:8084/addProject");
		resp.then().statusCode(201).log().all();
	}
}

package interviewEPAM;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import jdk.internal.net.http.common.Log;

import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class HTTPRequests {
	
	int id;

	
@Test
void getUsers()
{
	given()
	
	.when()
		.get("https://reqres.in/api/users?page=2")
	
	.then()
		.statusCode(200)
		.body("page",equalTo(2))
		.log().all();
	
	}
@Test()
void postUser()
{
	HashMap data = new HashMap();
	data.put("name", "carlos");
	data.put("job", "ENGINEER");
	
	
	
	id=given()
	.contentType("application/json")
	.body(data)
	
	.when()
		.post("https://reqres.in/api/users")
		.jsonPath().getInt("id");
	//.then()
	//	.statusCode(201)
		//.log().all();
	
	}

@Test()
void updateUser()
{
	HashMap data = new HashMap();
	data.put("name", "Jesus");
	data.put("job", "teacher");
	
	
	
	given()
	.contentType("application/json")
	.body(data)
	
	.when()
		.post("https://reqres.in/api/users/"+id)
	
	.then()
		.statusCode(201)
		.log().all();
	
	}

}





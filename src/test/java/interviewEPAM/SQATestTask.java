package interviewEPAM;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import jdk.internal.net.http.common.Log;

import static org.hamcrest.Matchers.*;

import java.util.HashMap;
public class SQATestTask {


	//This test case is to get all posts 
	@Test(priority=1)
	void getAllPosts()
	{
		given()		
		.when()
		.get("https://jsonplaceholder.typicode.com/posts")		
		.then()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.body("size()", greaterThan(0))
		.log().all();

	}

	//This test case is to get a post by an specific id
	@Test(priority=2)
	void getPostById()
	{
		int id = 2;
		given()

		.when()
		.get("https://jsonplaceholder.typicode.com/posts/"+id)

		.then()
		.statusCode(200)
		.body("id", equalTo(id));


	}
	//This test case is to get an status code 404 not found when a post ID does NOT exists
	@Test(priority=3)
	void getPostByIdNegative()
	{
		int id =101;
		given()

		.when()
		.get("https://jsonplaceholder.typicode.com/posts/"+id)

		.then()
		.statusCode(404);	
	}

	//This test case is to get all posts from comments
	@Test
	void getAllComments()
	{
		given()

		.when()
		.get("https://jsonplaceholder.typicode.com/posts/1/comments")

		.then()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.body("size()", greaterThan(0))
		.log().all();

	}
	//This test case is to test a POST request in posts 
	@Test(priority=4)
	void postRequest()
	{
		HashMap data = new HashMap();
		data.put("userId", "1");
		data.put("id", "101");
		data.put("title", "Title of new post for testing");
		data.put("body", "Body of the new post");

		given()
		.contentType(ContentType.JSON)
		.body(data)		
		.when()
		.post("https://jsonplaceholder.typicode.com/posts")	
		.then()
		.statusCode(201)
		.body("title",equalTo("Title of new post for testing"))
		.body("body",equalTo("Body of the new post"))
		.log().all();

	}

	//This test case is to test PUT request in posts
	@Test(priority=5)
	void updateData()
	{
		HashMap updateData = new HashMap();
		updateData.put("userId", "1");
		updateData.put("id", "102");
		updateData.put("title", "UPDATED Title of new post for testing");
		updateData.put("body", "UPDATED Body of the new post");

		given()
		.contentType(ContentType.JSON)
		.body(updateData)

		.when()
		.put("https://jsonplaceholder.typicode.com/posts/1")	
		.then()
		.statusCode(200)
		.body("title",equalTo("UPDATED Title of new post for testing"))
		.body("body",equalTo("UPDATED Body of the new post"))
		.log().all();

	}

	//This test case is to test PATCH request in posts
	@Test(priority=6)
	void patchData()
	{
		HashMap patchData = new HashMap();
		patchData.put("userId", "1");
		patchData.put("id", "102");
		patchData.put("title", "Title of PATCHED post for testing");
		patchData.put("body", "Body of PATCHED the new post");

		given()
		.contentType(ContentType.JSON)
		.body(patchData)

		.when()
		.patch("https://jsonplaceholder.typicode.com/posts/1")	
		.then()
		.statusCode(200)
		.body("title",equalTo("Title of PATCHED post for testing"))
		.body("body",equalTo("Body of PATCHED the new post"))
		.log().all();

	}

	//This test case is to test DELETE request in posts
	@Test(priority=9)
	void deleteTestPosts()
	{													
		given()														
		.when()
		.delete("https://jsonplaceholder.typicode.com/posts/1")	
		.then()
		.statusCode(200);


	}

	//This test case is to test PUT request in posts to update a record that does NOT exists and status code is 500
	@Test(priority=7)
	void updateDataNegative()
	{
		HashMap updateData = new HashMap();
		updateData.put("userId", "1");
		updateData.put("id", "101");
		updateData.put("title", "UPDATED Title of new post for testing");
		updateData.put("body", "UPDATED Body of the new post");

		given()
		.contentType(ContentType.JSON)
		.body(updateData)							
		.when()
		.put("https://jsonplaceholder.typicode.com/posts/101")	
		.then()
		.statusCode(500)							
		.log().all();			
	}

	//This test case is to test PATCH request in posts to replace a record that does NOT exists and status code is 200
	@Test(priority=8)
	void patchDataNegative()
	{
		HashMap patchData = new HashMap();
		patchData.put("userId", "1");
		patchData.put("id", "102");
		patchData.put("title", "Title of PATCHED post for testing");
		patchData.put("body", "Body of PATCHED the new post");							
		given()
		.contentType(ContentType.JSON)
		.body(patchData)							
		.when()
		.patch("https://jsonplaceholder.typicode.com/posts/103")	
		.then()
		.statusCode(200)
		.body("title",equalTo("Title of PATCHED post for testing"))
		.body("body",equalTo("Body of PATCHED the new post"))
		.log().all();							
	}

	//This test case is to test DELETE request in posts which does not exists
	@Test(priority=10)
	void deleteTestPostsNegative()
	{						
		given()						
		.when()
		.delete("https://jsonplaceholder.typicode.com/posts/10000")	
		.then()
		.statusCode(404)
		.body("error", equalTo("User not found"));						
	}


}

# EPAMTestTask
EPAM Test Task for API Testing using RestAssured
# REST API Test Suite  

This test suite validates the functionality of the [JSONPlaceholder](https://jsonplaceholder.typicode.com) REST API using **Rest Assured** in a **layered architecture**.  

## 📌 Features  

- **Layered Architecture** (Core, Domain, Tests)  
- **Parallel Execution** using TestNG  
- **Critical Path Testing** (Positive & Negative cases)  
- **Rest Assured** for API interactions  
- **Proper Code Conventions** (Google Java Style Guide)  

📑 Test Cases
✅ Positive Tests
GET /posts - Validate response status and structure
GET /posts/{id} - Fetch specific post
GET /posts/{id}/comments - Validate post comments
GET /comments?postId={id} - Fetch comments for a post
POST /posts - Create a new post
PUT /posts/{id} - Update a post
PATCH /posts/{id} - Partially update a post
DELETE /posts/{id} - Delete a post
❌ Negative Tests
GET /posts/{invalidId} - Fetch non-existent post
POST /posts - Create post with invalid data
PUT /posts/{invalidId} - Update a non-existent post
PATCH /posts/{invalidId} - Partially update a non-existent post
DELETE /posts/{invalidId} - Delete a non-existent post

## 📂 Project Structure  


## 🛠️ Setup  

### Prerequisites  
- Java 11+  
- Maven  
- TestNG  

### Installation  
1. Clone the repository  
   ```sh
   git clone https://github.com/Brayan023/EPAMTestTask.git
   cd rest-api-test-suite


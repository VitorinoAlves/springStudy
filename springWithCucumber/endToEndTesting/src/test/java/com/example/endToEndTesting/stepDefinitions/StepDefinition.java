package com.example.endToEndTesting.stepDefinitions;

import com.example.endToEndTesting.SpringIntegrationTest;
import com.example.endToEndTesting.studentUtils.StudentFactory;
import com.example.endToEndTesting.studentUtils.StudentRepository;
import com.example.endToEndTesting.studentUtils.domain.Student;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class StepDefinition extends SpringIntegrationTest {
    @Autowired
    private StudentRepository studentRepository;

    Response response;
    List<Student> studentList;
    private Student studentRequestBody;

    @Given("I can request an API")
    public void iCanRequestAnAPI() {
        System.out.println("Step 01");
    }

    @When("I request the API")
    public void iRequestTheAPI() {
        System.out.println("Step 02");
    }

    @Then("the API return the valid data")
    public void theAPIReturnTheValidData() {
        System.out.println("Step 03");
    }

    @Given("there are valid students in the database")
    public void thereAreValidStudentsInTheDatabase() {
        response = null;
        studentList = null;
    }

    @When("I request the all the students using the API")
    public void iRequestTheAllTheStudentsUsingTheAPI() {
        response = RestAssured.given()
                .when()
                .get("http://localhost:8080/api/v1/student");
    }

    @Then("the request should return a code {int} with the list of all students")
    public void theRequestShouldReturnACodeWithTheListOfAllStudents(int statusCode) {
        Assert.assertNotNull(response);
        Assert.assertEquals(statusCode, response.getStatusCode());

        studentList = response.as(new TypeRef<List<Student>>() {});
        Assert.assertNotNull("Students list should not be null", studentList);

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Converted List Size: " + studentList.size());
        System.out.println("First Student Name: " + studentList.get(0).getName());

        System.out.println(response.getBody().asString());
    }

    @Given("I have a valid request body to create a new student")
    public void iHaveAValidRequestBodyToCreateANewStudent() {
        studentRequestBody = StudentFactory.createNewStudentDefault();
    }

    @When("I sent this request body in a POST request")
    public void iSentThisRequestBodyInAPOSTRequest() {
        response = RestAssured.given()
                .contentType("application/json")
                .body(studentRequestBody)
                .when()
                .post("http://localhost:8080/api/v1/student");
    }

    @Then("the new student should be created in the database")
    public void theNewStudentShouldBeCreatedInTheDatabase() {
        Long createdStudentId = response.jsonPath().getLong("id");
        Assert.assertNotNull("The student ID was not found in the response body.", createdStudentId);

        Optional<Student> studentOptional = studentRepository.findById(createdStudentId);
        Assert.assertTrue("Student was not found in the database with ID: " + createdStudentId, studentOptional.isPresent());
        Assert.assertEquals("The name of student in the database and sent in the request doesn't match", studentOptional.get().getName(), studentRequestBody.getName());
        Assert.assertEquals("The email of student in the database and sent in the request doesn't match", studentOptional.get().getEmail(), studentRequestBody.getEmail());
    }

    @And("the request should return a code {int}")
    public void theRequestShouldReturnACode(int expectedStatusCode) {
        Assert.assertEquals("Expected status code " + expectedStatusCode,
                expectedStatusCode, response.getStatusCode());
    }
}

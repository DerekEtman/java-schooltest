package com.lambdaschool.school.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lambdaschool.school.model.Course;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.number.OrderingComparison.lessThan;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CourseControllerIntegrationTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void initializeRestAssuredMockMvcWebApplicationContext()
    {
        RestAssuredMockMvc.webAppContextSetup(webApplicationContext);
    }

//    GET /courses/courses
    @Test
    public void whenMeasuredResponseTime()
    {
        given().when().get("/courses/courses").then().time(lessThan(5000L));
    }

    //    POST /courses/course/add
    @Test
    public void givenPostARestaurant() throws Exception
    {
        ArrayList<Course> thisCourse = new ArrayList<>();
        Course c2 = new Course("How to Say No: 01");

        ObjectMapper mapper = new ObjectMapper();
        String stringC2 = mapper.writeValueAsString(c2);

        given().contentType("application/json").body(stringC2).when().post("/courses/course/add").then().statusCode(201);
    }
}

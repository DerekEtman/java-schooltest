package com.lambdaschool.school.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lambdaschool.school.model.Course;
import com.lambdaschool.school.model.Instructor;
import com.lambdaschool.school.service.CourseService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CourseControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CourseService courseService;

    private List<Course> courseList;

    @Before
    public void setUp() throws Exception {
        courseList = new ArrayList<>();

        Course course1 = new Course("Javascript" );
        Course course2 = new Course("Data Science");
        Course course3 = new Course("Node.js");

        courseList.add(course1);
        courseList.add(course2);
        courseList.add(course3);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void listAllCourses() {
    }

    @Test
    public void getCountStudentsInCourses() {
    }

    @Test
    public void deleteCourseById() {
    }

    @Test
    public void findCourseById() {
    }

    @Test
    public void addNewCourse() throws Exception{
        String apiUrl = "/courses/courses/add";

        Instructor instructor = new Instructor();

        Course c1 = new Course("How to Say No: 01", instructor);
        c1.setCourseid(523);
        ObjectMapper mapper = new ObjectMapper();
        String courseString = mapper.writeValueAsString(c1);

        Mockito.when(courseService.save(any(Course.class))).thenReturn(c1);

        RequestBuilder rb = MockMvcRequestBuilders.post(apiUrl)
                                                  .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
                                                  .content(courseString);
        mockMvc.perform(rb).andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());

    }
}
package Usecase;

import entity.CourseList;

import java.io.IOException;

public interface Gateway {
    CourseList importcourselist() throws IOException, ClassNotFoundException;
    void saveComment(CourseList courseList) throws IOException;
}

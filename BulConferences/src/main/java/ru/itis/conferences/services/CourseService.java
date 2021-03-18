package ru.itis.conferences.services;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import ru.itis.conferences.models.Course;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public interface CourseService {
    void checkRegistration(Model model, String courseName, HttpSession session);

    void registration(HttpSession session, String courseName);

    List<Course> findAll();

    Course findByName(String name);

    void delete(Course entity);

    void add(Course entity);
}

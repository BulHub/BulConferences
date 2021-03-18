package ru.itis.conferences.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import ru.itis.conferences.models.Course;
import ru.itis.conferences.models.User;
import ru.itis.conferences.models.UserCourse;
import ru.itis.conferences.repositories.CourseRepository;
import ru.itis.conferences.repositories.UserCourseRepository;
import ru.itis.conferences.repositories.UserRepository;
import ru.itis.conferences.services.CourseService;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final UserCourseRepository userCourseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository,
                             UserRepository userRepository,
                             UserCourseRepository userCourseRepository) {
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
        this.userCourseRepository = userCourseRepository;
    }

    @Override
    public void checkRegistration(Model model, String courseName, HttpSession session) {
        String email = (String) session.getAttribute("email");
        Optional<User> user = userRepository.findByEmail(email);
        Course course = courseRepository.findByName(courseName);
        UserCourse userCourse = userCourseRepository.findByCourseIdAndUserId(course.getId(), user.get().getId());
        if (userCourse != null) {
            model.addAttribute("something", "Enter the course");
            session.setAttribute("check", true);
        } else {
            model.addAttribute("something", "Sign up");
            session.setAttribute("check", false);
        }
    }

    @Override
    public void registration(HttpSession session, String courseName) {
        String email = (String) session.getAttribute("email");
        Optional<User> user = userRepository.findByEmail(email);
        Course course = courseRepository.findByName(courseName);
        userCourseRepository.save(UserCourse
                .builder()
                .userId(user.get().getId())
                .courseId(course.getId())
                .build());
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course findByName(String name) {
        return courseRepository.findByName(name);
    }

    @Override
    public void delete(Course entity) {
        courseRepository.delete(entity);
    }

    @Override
    public void add(Course entity) {
        courseRepository.save(entity);
    }
}

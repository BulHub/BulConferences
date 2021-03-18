package ru.itis.conferences.services;

import org.springframework.stereotype.Service;
import ru.itis.conferences.models.UserCourse;

import java.util.List;

@Service
public interface UserCourseService {
    List<UserCourse> findAll();

    UserCourse findByCourseIdAndUserId(Long courseId, Long userId);

    void delete(UserCourse entity);

    void add(UserCourse entity);
}

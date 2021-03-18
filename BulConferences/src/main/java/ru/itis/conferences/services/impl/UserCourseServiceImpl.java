package ru.itis.conferences.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.conferences.models.UserCourse;
import ru.itis.conferences.repositories.UserCourseRepository;
import ru.itis.conferences.services.UserCourseService;

import java.util.List;

@Service
public class UserCourseServiceImpl implements UserCourseService {

    private final UserCourseRepository userCourseRepository;

    @Autowired
    public UserCourseServiceImpl(UserCourseRepository userCourseRepository) {
        this.userCourseRepository = userCourseRepository;
    }

    @Override
    public List<UserCourse> findAll() {
        return userCourseRepository.findAll();
    }

    @Override
    public UserCourse findByCourseIdAndUserId(Long courseId, Long userId) {
        return userCourseRepository.findByCourseIdAndUserId(courseId, userId);
    }


    @Override
    public void delete(UserCourse entity) {
        userCourseRepository.delete(entity);

    }

    @Override
    public void add(UserCourse entity) {
        userCourseRepository.save(entity);
    }
}

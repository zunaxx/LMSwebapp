package AppPackage.service;

import AppPackage.dao.CourseDao;

import AppPackage.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    CourseDao courseDao;

    @Autowired
    public CourseServiceImpl(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public Course create(Course course) {
        courseDao.create(course);
        return course;
    }

    @Override
    public void update(Course course) {
        courseDao.update(course);
    }

    @Override
    public void deleteById(long id) {
        courseDao.deleteById(id);
    }

    @Override
    public List<Course> getAll(long id) {
        return courseDao.getAll(id);
    }

    @Override
    public Course getById(long id) {
        return courseDao.getById(id);
    }
}

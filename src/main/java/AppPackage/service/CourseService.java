package AppPackage.service;

import AppPackage.entity.Company;
import AppPackage.entity.Course;

import java.util.List;

public interface CourseService {
    Course create(Course course);
    void update(Course course);
    void deleteById(long id);
    List<Course> getAll(long id);
    Course getById(long id);
}

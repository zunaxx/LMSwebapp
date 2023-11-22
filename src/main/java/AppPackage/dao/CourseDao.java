package AppPackage.dao;

import AppPackage.entity.Course;

import java.util.List;

public interface CourseDao {
    Course create(Course course);
    void update(Course course);
    void deleteById(long id);
    List<Course> getAll(long id);
    Course getById(long id);
}

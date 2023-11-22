package AppPackage.dao;

import AppPackage.entity.Group;
import AppPackage.entity.Student;

import java.util.List;

public interface StudentDao {
    void create(Student student);
    void update(Student student);
    void deleteById(long id);
    List<Student> getAll(long id);
    Student getById(long id);
}

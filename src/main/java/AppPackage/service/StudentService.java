package AppPackage.service;

import AppPackage.entity.Company;
import AppPackage.entity.Student;

import java.util.List;

public interface StudentService {
    void create(Student student);
    void update(Student student);
    void deleteById(long id);
    List<Student> getAll(long id);
    Student getById(long id);
}

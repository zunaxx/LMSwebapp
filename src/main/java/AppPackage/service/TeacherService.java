package AppPackage.service;

import AppPackage.entity.Company;
import AppPackage.entity.Teacher;

import java.util.List;

public interface TeacherService {
    Teacher create(Teacher teacher);
    void update(Teacher teacher);
    void deleteById(long id);
    List<Teacher> getAll(long id);
    Teacher getById(long id);
}

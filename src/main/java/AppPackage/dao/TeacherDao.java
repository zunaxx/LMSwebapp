package AppPackage.dao;

import AppPackage.entity.Company;
import AppPackage.entity.Student;
import AppPackage.entity.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public interface TeacherDao {
    Teacher create(Teacher teacher);
    void update(Teacher teacher);
    void deleteById(long id);
    List<Teacher> getAll(long id);
    Teacher getById(long id);
}

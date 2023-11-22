package AppPackage.service;

import AppPackage.dao.StudentDao;
import AppPackage.entity.Company;
import AppPackage.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    StudentDao studentDao;

    @Autowired
    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public void create(Student student) {
        studentDao.create(student);
    }

    @Override
    public void update(Student student) {
        studentDao.update(student);
    }

    @Override
    public void deleteById(long id) {
        studentDao.deleteById(id);
    }

    @Override
    public List<Student> getAll(long id) {
        return studentDao.getAll(id);
    }

    @Override
    public Student getById(long id) {
        return studentDao.getById(id);
    }
}

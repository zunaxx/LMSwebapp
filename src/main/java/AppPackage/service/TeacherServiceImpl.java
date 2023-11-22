package AppPackage.service;

import AppPackage.dao.TeacherDao;
import AppPackage.dao.TeacherDaoImpl;
import AppPackage.entity.Company;
import AppPackage.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService{

    TeacherDao teacherDao;

    @Autowired
    public TeacherServiceImpl(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Override
    public Teacher create(Teacher teacher) {
        return teacherDao.create(teacher);
    }

    @Override
    public void update(Teacher teacher) {
        teacherDao.update(teacher);
    }

    @Override
    public void deleteById(long id) {
        teacherDao.deleteById(id);
    }

    @Override
    public List<Teacher> getAll(long id) {
        return teacherDao.getAll(id);
    }

    @Override
    public Teacher getById(long id) {
        return teacherDao.getById(id);
    }
}

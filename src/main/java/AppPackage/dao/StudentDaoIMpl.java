package AppPackage.dao;

import AppPackage.entity.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class StudentDaoIMpl implements StudentDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(Student student) {
        entityManager.persist(student);
    }

    @Override
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    public void deleteById(long id) {
        entityManager.remove(id);
    }

    @Override
    public List<Student> getAll(long id) {
        return entityManager.createQuery("select s from Student s where s.group.id=:id").setParameter("id",id).getResultList();
    }

    @Override
    public Student getById(long id) {
        return entityManager.find(Student.class,id);
    }
}

package AppPackage.dao;

import AppPackage.entity.Teacher;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class TeacherDaoImpl implements TeacherDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Teacher create(Teacher teacher) {
        entityManager.persist(teacher);
        return teacher;
    }

    @Override
    public void update(Teacher teacher) {
        entityManager.merge(teacher);
    }

    @Override
    public void deleteById(long id) {
        Teacher teacher  = entityManager.find(Teacher.class,id);
        entityManager.remove(teacher);
    }

    @Override
    public List<Teacher> getAll(long id) {
        return  entityManager.createQuery("select t from Teacher t where t.course.id=:id",Teacher.class).setParameter("id",id).getResultList();
    }

    @Override
    public Teacher getById(long id) {
        return entityManager.find(Teacher.class,id);

    }
}

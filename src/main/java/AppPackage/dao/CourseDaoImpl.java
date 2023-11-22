package AppPackage.dao;

import AppPackage.entity.Company;
import AppPackage.entity.Course;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class CourseDaoImpl implements CourseDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Course create(Course course) {
        entityManager.merge(course);
        return course;
    }

    @Override
    public void update(Course course) {
        entityManager.merge(course);
    }

    @Override
    public void deleteById(long id) {
        Course course = entityManager.find(Course.class,id);
        entityManager.remove(course);
    }

    @Override
    public List<Course> getAll(long id) {
        return entityManager.createQuery("select c from Course c where c.company.id=:id").setParameter("id",id).getResultList();
    }

    @Override
    public Course getById(long id) {
       return entityManager.find(Course.class,id);
    }
}

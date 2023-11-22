package AppPackage.dao;

import AppPackage.entity.Group;
import AppPackage.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class GroupDaoIMpl implements GroupDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Group create(Group group) {
        entityManager.merge(group);
        return group;
    }

    @Override
    public void update(Group group) {
        entityManager.merge(group);
    }

    @Override
    public void deleteById(long id) {
        entityManager.remove(id);
    }

    @Override
    public List<Group> getAll(long id) {
       return entityManager.createQuery("select g from Group g inner join g.course c where c.id in:id").setParameter("id",id).getResultList();
    }

    @Override
    public Group getById(long id) {
       return entityManager.find(Group.class,id);
    }
}

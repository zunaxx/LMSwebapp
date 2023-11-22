package AppPackage.service;

import AppPackage.dao.CourseDao;
import AppPackage.dao.GroupDao;
import AppPackage.entity.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GroupServiceImpl implements GroupService{

    private GroupDao groupDao;
    private CourseDao courseDao;

    @Autowired
    public GroupServiceImpl(GroupDao groupDao, CourseDao courseDao) {
        this.groupDao = groupDao;
        this.courseDao = courseDao;
    }

    @Override
    public Group create(Group group) {
        groupDao.create(group);
        return group;
    }

    @Override
    public void update(Group group) {
        groupDao.update(group);
    }

    @Override
    public void deleteById(long id) {
        groupDao.deleteById(id);
    }

    @Override
    public List<Group> getAll(long id) {
        return groupDao.getAll(id);
    }

    @Override
    public Group getById(long id) {
        return groupDao.getById(id);
    }
}

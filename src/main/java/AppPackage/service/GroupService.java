package AppPackage.service;

import AppPackage.entity.Group;

import java.util.List;

public interface GroupService  {
    Group create(Group group);
    void update(Group group);
    void deleteById(long id);
    List<Group> getAll(long id);
    Group getById(long id);
}

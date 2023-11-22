package AppPackage.dao;

import AppPackage.entity.Course;
import AppPackage.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupDao {
    Group create(Group group);
    void update(Group group);
    void deleteById(long id);
    List<Group> getAll(long id);
    Group getById(long id);
}

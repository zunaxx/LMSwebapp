package AppPackage.entity;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String courseName;
    private String duration;
    @ManyToOne
    private Company company;

    @ManyToMany(cascade = {REMOVE,REFRESH,DETACH,MERGE},fetch = FetchType.LAZY)
    private List<Group> group;

    @OneToOne(mappedBy = "course",cascade = ALL)
    private Teacher teacher;

    public Course(String courseName, String duration, Company company, List<Group> group) {
        this.courseName = courseName;
        this.duration = duration;
        this.company = company;
        this.group = group;
    }

    public Course() {
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Group> getGroup() {
        return group;
    }

    public void setGroup(List<Group> group) {
        this.group = group;
    }
}

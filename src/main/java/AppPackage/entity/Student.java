package AppPackage.entity;

import AppPackage.enumStudyFormat.EnumStudyFormat;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String email;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private EnumStudyFormat studyFormat;
    @ManyToOne
    private Group group;

    public Student(String firstName, String email, String lastName) {
        this.firstName = firstName;
        this.email = email;
        this.lastName = lastName;
    }

    public Student() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public EnumStudyFormat getStudyFormat() {
        return studyFormat;
    }

    public void setStudyFormat(EnumStudyFormat studyFormat) {
        this.studyFormat = studyFormat;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}

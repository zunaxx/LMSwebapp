package AppPackage.entity;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String companyName;
    private String locatedCountry;
    @OneToMany(mappedBy = "company",cascade = ALL)
    private List<Course> course;

    public Company(String companyName, String locatedCountry, List<Course> course) {
        this.companyName = companyName;
        this.locatedCountry = locatedCountry;
        this.course = course;
    }

    public Company() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLocatedCountry() {
        return locatedCountry;
    }

    public void setLocatedCountry(String locatedCountry) {
        this.locatedCountry = locatedCountry;
    }

    public List<Course> getCourse() {
        return course;
    }

    public void setCourse(List<Course> course) {
        this.course = course;
    }
}

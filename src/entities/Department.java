package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Department
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    
    @ManyToOne
    @JoinColumn(name="UNIVERSITY_ID")
    private University university;
    
    @OneToMany(mappedBy="department", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Major> majors = new ArrayList<Major>();
    
    @OneToMany(mappedBy="department", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Course> courses = new ArrayList<Course>();
    
    
    public int getId ()
    {
        return id;
    }
    public void setId (int id)
    {
        this.id = id;
    }
 
    public String getName ()
    {
        return name;
    }
    public void setName (String name)
    {
        this.name = name;
    }
    public University getUniversity ()
    {
        return university;
    }
    public void setUniversity (University university)
    {
        this.university = university;
    }
    public List<Major> getMajors ()
    {
        return majors;
    }
    public void setMajors (List<Major> majors)
    {
        this.majors = majors;
    }
    public List<Course> getCourses ()
    {
        return courses;
    }
    public void setCourses (List<Course> courses)
    {
        this.courses = courses;
    }
    
    
    
    
    
}

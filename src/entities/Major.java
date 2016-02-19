package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Major
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name="MAJOR_COURSE", 
            joinColumns=@JoinColumn(name="COURSE_ID"),
            inverseJoinColumns=@JoinColumn(name="MAJOR_ID"))     
    private List<Course> courses = new ArrayList<Course>();
    
    @ManyToOne
    @JoinColumn(name="DEPARTMENT_ID")
    private Department department;
    
    
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
    public List<Course> getCourses ()
    {
        return courses;
    }
    public void setCourses (List<Course> courses)
    {
        this.courses = courses;
    }
    public Department getDepartment ()
    {
        return department;
    }
    public void setDepartment (Department department)
    {
        this.department = department;
    }
    
    
    
    
}

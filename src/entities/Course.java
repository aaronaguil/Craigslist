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
public class Course
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name="COURSE_PROFESSOR", 
            joinColumns=@JoinColumn(name="COURSE_ID"),
            inverseJoinColumns=@JoinColumn(name="PROFESSOR_ID"))     
    private List<Professor> professors = new ArrayList<Professor>();
    
    @ManyToMany(mappedBy="courses")
    private List<Major> majors = new ArrayList<Major>();
    
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

    public List<Professor> getProfessors ()
    {
        return professors;
    }

    public void setProfessors (List<Professor> professors)
    {
        this.professors = professors;
    }

    public List<Major> getMajors ()
    {
        return majors;
    }

    public void setMajors (List<Major> majors)
    {
        this.majors = majors;
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

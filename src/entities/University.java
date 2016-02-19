package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class University
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String university_name;
    
    @ManyToMany(mappedBy="universities")
    private List<User> users = new ArrayList<User>();
    
    @OneToMany(mappedBy="university", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Department> departments = new ArrayList<Department>();
    
    public int getId ()
    {
        return id;
    }
    public void setId (int id)
    {
        this.id = id;
    }

    public List<User> getUsers ()
    {
        return users;
    }
    public void setUsers (List<User> users)
    {
        this.users = users;
    }
    public List<Department> getDepartments ()
    {
        return departments;
    }
    public void setDepartments (List<Department> departments)
    {
        this.departments = departments;
    }
    public void addUser(User u)
    {
        users.add (u);
    }
    public String getUniversity_name ()
    {
        return university_name;
    }
    public void setUniversity_name (String university_name)
    {
        this.university_name = university_name;
    }
    
    
}

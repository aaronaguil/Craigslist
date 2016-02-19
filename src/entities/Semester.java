package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Semester
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String semester;
    
    @ManyToMany(mappedBy="semesters")
    private List<User> users = new ArrayList<User>();

    public int getId ()
    {
        return id;
    }

    public void setId (int id)
    {
        this.id = id;
    }

    public String getSemester ()
    {
        return semester;
    }

    public void setSemester (String semester)
    {
        this.semester = semester;
    }

    public List<User> getUsers ()
    {
        return users;
    }

    public void setUsers (List<User> users)
    {
        this.users = users;
    }
    public void addUser(User u)
    {
        users.add (u);
    }
    
    
    
}

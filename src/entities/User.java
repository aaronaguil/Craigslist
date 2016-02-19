package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String email;
    private int major_id;
    private int university_id;
    private Date registration_date;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name="USER_SEMESTER", 
            joinColumns=@JoinColumn(name="USER_ID"),
            inverseJoinColumns=@JoinColumn(name="SEMESTER_ID"))     
    private List<Semester> semesters = new ArrayList<Semester>();
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name="USER_UNIVERSITY", 
    joinColumns=@JoinColumn(name="USER_ID"),
    inverseJoinColumns=@JoinColumn(name="UNIVERSITY_ID"))     
    private List<University> universities = new ArrayList<University>();
    
    @OneToMany(mappedBy="user", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Post> posts = new ArrayList<Post>();

    public int getId ()
    {
        return id;
    }

    public void setId (int id)
    {
        this.id = id;
    }

    public String getUsername ()
    {
        return username;
    }

    public void setUsername (String username)
    {
        this.username = username;
    }

    public String getPassword ()
    {
        return password;
    }

    public void setPassword (String password)
    {
        this.password = password;
    }

    public String getEmail ()
    {
        return email;
    }

    public void setEmail (String email)
    {
        this.email = email;
    }

    public int getMajor_id ()
    {
        return major_id;
    }

    public void setMajor_id (int major_id)
    {
        this.major_id = major_id;
    }

    public int getUniversity_id ()
    {
        return university_id;
    }

    public void setUniversity_id (int university_id)
    {
        this.university_id = university_id;
    }

    public Date getRegistration_date ()
    {
        return registration_date;
    }

    public void setRegistration_date (Date registration_date)
    {
        this.registration_date = registration_date;
    }

    public List<Semester> getSemesters ()
    {
        return semesters;
    }

    public void setSemesters (List<Semester> semesters)
    {
        this.semesters = semesters;
    }

    public List<University> getUniversities ()
    {
        return universities;
    }

    public void setUniversities (List<University> universities)
    {
        this.universities = universities;
    }

    public List<Post> getPosts ()
    {
        return posts;
    }

    public void setPosts (List<Post> posts)
    {
        this.posts = posts;
    }
    public void addUniversity(University u)
    {
        universities.add (u);
        
    }
    public void addSemester(Semester s)
    {
        semesters.add (s);
    }
    

   
}

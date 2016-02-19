package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import entities.Major;
import entities.Post;
import entities.Semester;
import entities.University;
import entities.User;

@Component
@Transactional
public class SkuMeDAO
{
    @PersistenceContext
    private EntityManager em;
    
    public List<Major> getMajors()
    {
        List<Major> major = (List<Major>) em.createQuery ("SELECT m FROM Major m").getResultList();
        return major;
    }
    
    public List<University> getUniversities()
    {
        List<University> university = (List<University>) em.createQuery ("SELECT u FROM University u").getResultList();
        return university;
    }
    
    public List<Semester> getSemesters()
    {
        List<Semester> semester = (List<Semester>) em.createQuery ("SELECT s FROM Semester s").getResultList();
        return semester;
    }
    
    public void addNewUser(String username, String password, String email, String major,
            String semester, String university)
    {
            User newUser = new User();
            newUser.setUsername (username);
            newUser.setPassword (password);
            newUser.setEmail (email);
            
            Semester sem = new Semester();
            sem.setSemester (semester);
            
            int majId = (int) em.createQuery ("SELECT m.id FROM Major m WHERE m.name = :name").setParameter("name", major).getSingleResult ();
            newUser.setMajor_id (majId); 
            
            int univId = (int) em.createQuery ("SELECT u.id FROM University u WHERE u.university_name = :name").setParameter("name", university).getSingleResult ();
            newUser.setUniversity_id (univId);
            
            
            University univ = (University) em.createQuery ("SELECT u FROM University u WHERE u.university_name = :name").setParameter("name", university).getSingleResult ();
            univ.addUser(newUser);
            newUser.addUniversity(univ);
            newUser.addSemester (sem);
            sem.addUser(newUser);
            
            System.out.println (newUser.getEmail ());
            System.out.println (newUser.getUsername ());
            System.out.println (newUser.getPassword ());
            System.out.println (newUser.getSemesters ());
            System.out.println (newUser.getMajor_id ());
            System.out.println (newUser.getUniversity_id ());
            em.persist (newUser);
        
    }

    public String getPassword(String name)
    {
        String password = (String) em.createQuery ("SELECT u.password FROM User u WHERE u.username = :name").setParameter("name", name).getSingleResult ();
        
        return password;
    }
    
    public List<Post> getUniversityPosts(String name)
    {
        int univId = (int) em.createQuery ("SELECT u.university_id FROM User u WHERE u.username = :name").setParameter("name", name).getSingleResult ();
        System.out.println (univId);
        
        List<Post> posts = (List<Post>)em.createQuery ("SELECT p FROM Post p WHERE p.university_id = :uid").setParameter("uid", univId).getResultList();
        
        for (Post post : posts)
        {
            System.out.println (post.getMessage ());
            System.out.println (post.getPrice ());
            System.out.println (post.getTitle ());
        }
        
        return posts;
    }
     
    public List<Post> getBookPosts(String book)
    {
        List<Post> posts = new ArrayList<Post>();
        Post post;
        List<Integer> itemId = (List<Integer>)em.createQuery ("SELECT i.id FROM Item i WHERE i.item_type = :type").setParameter("type", book).getResultList();
        
        for (Integer integer : itemId)
        {
            post = (Post)em.createQuery ("SELECT p FROM Post p WHERE p.id = :id").setParameter("id", integer).getSingleResult();   
            posts.add (post);
        }
                
        return posts;
    }
    
    public List<Post> getSchoolPosts(String school)
    {
        List<Post> posts = new ArrayList<Post>();
        Post post;
        List<Integer> itemId = (List<Integer>)em.createQuery ("SELECT i.id FROM Item i WHERE i.item_type = :type").setParameter("type", school).getResultList();
        
        for (Integer integer : itemId)
        {
            post = (Post)em.createQuery ("SELECT p FROM Post p WHERE p.id = :id").setParameter("id", integer).getSingleResult();   
            posts.add (post);
        }
                
        return posts;
    }
    
    public List<Post> getPersonalPosts(String personal)
    {
        List<Post> posts = new ArrayList<Post>();
        Post post;
        List<Integer> itemId = (List<Integer>)em.createQuery ("SELECT i.id FROM Item i WHERE i.item_type = :type").setParameter("type", personal).getResultList();
        for (Integer integer : itemId)
        {
         System.out.println (integer);   
        }
        for (Integer integer : itemId)
        {
            post = (Post)em.createQuery ("SELECT p FROM Post p WHERE p.id = :id").setParameter("id", integer).getSingleResult();   
            posts.add (post);
        }
                
        return posts;
    }
    
    public List<Post> getHomePosts(String home)
    {
        List<Post> posts = new ArrayList<Post>();
        Post post;
        List<Integer> itemId = (List<Integer>)em.createQuery ("SELECT i.id FROM Item i WHERE i.item_type = :type").setParameter("type", home).getResultList();
        
        for (Integer integer : itemId)
        {
            post = (Post)em.createQuery ("SELECT p FROM Post p WHERE p.id = :id").setParameter("id", integer).getSingleResult();   
            posts.add (post);
        }
                
        return posts;
    }

    public int getCourseId(String name)
    {
        int id = (int)em.createQuery ("SELECT c.id FROM Course c WHERE c.name= :name").setParameter ("name", name).getSingleResult ();
        
        return id;
    }

    public void createNewBookPost(Post post)
    {   
        System.out.println ("in dao");
        em.persist (post);
    }
}

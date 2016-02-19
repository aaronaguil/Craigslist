package entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Book
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String item_type;
    private String title;
    private String author;
    private String item_condition;
    private String isbn;
    private int course_id;
    private int major_id;
    private int professor_id;
    private int department_id;
//    private int item_id;
    
    @OneToOne(mappedBy="book", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Item item;

    public int getId ()
    {
        return id;
    }

    public void setId (int id)
    {
        this.id = id;
    }

    public String getItem_type ()
    {
        return item_type;
    }

    public void setItem_type (String item_type)
    {
        this.item_type = item_type;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getAuthor ()
    {
        return author;
    }

    public void setAuthor (String author)
    {
        this.author = author;
    }

    public String getItem_condition ()
    {
        return item_condition;
    }

    public void setItem_condition (String item_condition)
    {
        this.item_condition = item_condition;
    }

    public String getIsbn ()
    {
        return isbn;
    }

    public void setIsbn (String isbn)
    {
        this.isbn = isbn;
    }

    public int getCourse_id ()
    {
        return course_id;
    }

    public void setCourse_id (int course_id)
    {
        this.course_id = course_id;
    }

    public int getMajor_id ()
    {
        return major_id;
    }

    public void setMajor_id (int major_id)
    {
        this.major_id = major_id;
    }

    public int getProfessor_id ()
    {
        return professor_id;
    }

    public void setProfessor_id (int professor_id)
    {
        this.professor_id = professor_id;
    }

    public int getDepartment_id ()
    {
        return department_id;
    }

    public void setDepartment_id (int department_id)
    {
        this.department_id = department_id;
    }

    public Item getItem ()
    {
        return item;
    }

    public void setItem (Item item)
    {
        this.item = item;
    }

//    public int getItem_id ()
//    {
//        return item_id;
//    }
//
//    public void setItem_id (int item_id)
//    {
//        this.item_id = item_id;
//    }

    
   

    
    
}

package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import DAO.SkuMeDAO;
import entities.Book;
import entities.Item;
import entities.Major;
import entities.Post;
import entities.Semester;
import entities.University;

@Controller
@SessionAttributes({"username", "type"})
public class SkuMeController
{
    
    @Autowired
    private SkuMeDAO skumedao;
    
    @ModelAttribute("username")
    public String username()
    {
        String username = "";
        return username;
    }
    
    @ModelAttribute("type")
    public String postType()
    {
        String type = "";
        return type;
    }
    
        @RequestMapping("newUser.do")
        public ModelAndView newUser(Model model, @RequestParam("username") String username, @RequestParam("password") String password,
                    @RequestParam("confirmPassword") String confirmPassword, @RequestParam("email") String email,
                    @RequestParam("major") String major, @RequestParam("semester") String semester, @RequestParam("university") String university)
        {
            if(confirmPassword.equals (password))
            {
                skumedao.addNewUser (username, password, email, major, semester, university);
                List<Post> posts = skumedao.getUniversityPosts (username);
                   
                model.addAttribute ("username", username);
                return new ModelAndView("user.jsp", "posts", posts);
            }
            else
            {
                model.addAttribute ("username", username);
                return new ModelAndView("login.jsp");
            }
        }
        
        @RequestMapping("createNewAccount.do")
        public ModelAndView createNewAccount(Model model, @ModelAttribute("username") String username)
        {
            List<Major> major = skumedao.getMajors();
            List<University> university = skumedao.getUniversities();
            List<Semester> semester = skumedao.getSemesters();
            
            model.addAttribute("major", major);
            model.addAttribute("university", university);
            model.addAttribute("semester", semester);
            model.addAttribute ("username", username);
            return new ModelAndView("createNewAccount.jsp");

        }
        
        @RequestMapping("login.do")
        public ModelAndView login(Model model, @RequestParam("username") String username, @RequestParam("password") String password)
        {
            if(password.equals (skumedao.getPassword (username)))
            {
                List<Post> posts = skumedao.getUniversityPosts (username);
                                
                model.addAttribute ("username", username);
                return new ModelAndView("user.jsp", "posts", posts); 
            }
            else
            {
                model.addAttribute ("username", username);
                return new ModelAndView("login.jsp");
            }
            
        }
        
        @RequestMapping("getAllPosts.do")
        public ModelAndView getAllPosts(Model model, @ModelAttribute("username") String username)
        {    
            List<Post> posts = skumedao.getUniversityPosts (username);
            
            model.addAttribute ("username", username);
            return new ModelAndView("user.jsp", "posts", posts);
        }
        
        @RequestMapping("getUniversityPosts.do")
        public ModelAndView getUniversityPosts(Model model, @ModelAttribute("username") String username)
        {    
            model.addAttribute ("username", username);
            System.out.println (username);
            List<Post> posts = skumedao.getUniversityPosts (username);
            
            return new ModelAndView("user.jsp", "posts", posts);
        }
        
        @RequestMapping("getBookPosts.do")
        public ModelAndView getBookPosts()
        {    
                List<Post> posts = skumedao.getBookPosts ("BOOK");
                if(posts.isEmpty ())
                    {
                    System.out.println ("NOTHING");
                    }
                for (Post post : posts)
                {
                    System.out.println (post.getMessage ());
                    System.out.println (post.getTitle ());
                }
           
                return new ModelAndView("user.jsp", "posts", posts);
        }
        
        @RequestMapping("getPersonalPosts.do")
        public ModelAndView getPersonalPosts()
        {    
            List<Post> posts = skumedao.getPersonalPosts ("PERSONAL");
            
            return new ModelAndView("user.jsp", "posts", posts);
        }
        
        @RequestMapping("getHousePosts.do")
        public ModelAndView getHousePosts()
        {    
            List<Post> posts = skumedao.getHomePosts ("HOUSE");
            
            return new ModelAndView("user.jsp", "posts", posts);
        }
        
        @RequestMapping("getSchoolPosts.do")
        public ModelAndView getSchoolPosts()
        {    
            List<Post> posts = skumedao.getSchoolPosts ("SCHOOL");
            
            return new ModelAndView("user.jsp", "posts", posts);
        }
   
        @RequestMapping("displayUniversities.do")
        public ModelAndView displayUniversities()
        {
           List<University> universities = skumedao.getUniversities ();
           for (University university : universities)
        {
            System.out.println (university.getUniversity_name ());
        }
            return new ModelAndView("universityLoggedIn.jsp", "university", universities);
        }
        
        @RequestMapping("CreateNewPost.do")
        public String createNewPost(Model model, @RequestParam(value="name") String type, @ModelAttribute("type") String type1)
        {
            if(type.equals ("BOOK"))
            {   
                model.addAttribute ("type", type);
                return "createNewBookPost.jsp";
            }
            else
            {
                model.addAttribute ("type", type);
                return "createNewOtherPost.jsp";
            }
        }
        
        @RequestMapping("newBookPost.do")
        public ModelAndView newPost(Model model, @RequestParam("title") String title, @RequestParam("message") String message,
                    @RequestParam("price") Double price, @RequestParam("bookTitle") String bookTitle,
                    @RequestParam("author") String author, @RequestParam("isbn") String isbn, @RequestParam("year") String year,
                    @RequestParam("course") String course, @RequestParam("professor") String professor, @ModelAttribute("type") String type)
        {
            System.out.println ("0");
            Post post = new Post();
            Book book = new Book();
            Item item = new Item();
            System.out.println ("1");
            post.setTitle (title);
            post.setMessage (message);
            post.setPrice (price);
            
            book.setTitle (bookTitle);
            book.setAuthor (author);
            book.setIsbn (isbn);
            book.setCourse_id (1);
            book.setDepartment_id (1);
            book.setMajor_id (1);
            book.setProfessor_id (1);
            System.out.println ("2");
            item.setBook (book);
            post.setItem (item);
            System.out.println ("in controller");
            skumedao.createNewBookPost(post);
            
            
          return new ModelAndView("index.jsp");
        }
        

}

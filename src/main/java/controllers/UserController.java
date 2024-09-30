package controllers;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import models.User;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import dao.UserDAO;
import daoImpl.UserDAOImpl;


/**
 * Servlet implementation class UserController
 */
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EntityManagerFactory entityManageFactory;
	private UserDAO userDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
       
    }

    
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		this.entityManageFactory = Persistence.createEntityManagerFactory("user-management");
		this.userDao = new UserDAOImpl(this.entityManageFactory.createEntityManager());
	}


	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		this.entityManageFactory.close();
		super.destroy();
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String action = request.getParameter("action") != null ? request.getParameter("action") : "";
		 System.out.println(action);
		 switch (action) {
			case "new":
				showRegisterForm(request, response);
				break;
			case "delete":
                deleteUser(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            default:
				listUser(request, response);
				break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String action = request.getParameter("action") != null ? request.getParameter("action") : "";
		 switch (action) {
			case "insert":
                insertUser(request, response);
                break;
            case "update":
                updateUser(request, response);
                break;
			default:
				listUser(request, response);
				break;
		}
	}

	private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> listUser = userDao.findAll();
        System.out.println(listUser);
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/user/list.jsp");
        dispatcher.forward(request, response);
    }
	
	 private void showRegisterForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/user/add.jsp");
        dispatcher.forward(request, response);
     }
	 
	 private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User existingUser = this.userDao.findById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/user/edit.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);
     }
	 
	 private void insertUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String day = request.getParameter("day");
        String month = request.getParameter("month");
        String year = request.getParameter("year");
        LocalDate birthday = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
        String gender = request.getParameter("gender");
        User newUser = new User(firstName, lastName, email, password, birthday, gender);
        
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<User>> violations = validator.validate(newUser);
        
        if (violations.isEmpty()) {
	        this.userDao.save(newUser);
	        response.sendRedirect("users");
        }
        else {
        	RequestDispatcher dispatcher = request.getRequestDispatcher("views/user/add.jsp");
            
            StringBuilder stringBuilder = new StringBuilder();
            violations.forEach(violation -> {
            	stringBuilder.append(violation.getPropertyPath() + ": " + violation.getMessage());
            	stringBuilder.append("<br />");
            });
            
            request.setAttribute("user", newUser);
            request.setAttribute("errors", stringBuilder);
            dispatcher.forward(request, response);
        }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String day = request.getParameter("day");
        String month = request.getParameter("month");
        String year = request.getParameter("year");
        LocalDate birthday = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
        String gender = request.getParameter("gender");
        User user = new User(id, firstName, lastName, email, password, birthday, gender);
        
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        
        if (violations.isEmpty()) {
        	 this.userDao.update(user);
             response.sendRedirect("users");
        }
        else {
        	RequestDispatcher dispatcher = request.getRequestDispatcher("views/user/edit.jsp");
            
            StringBuilder stringBuilder = new StringBuilder();
            violations.forEach(violation -> {
            	stringBuilder.append(violation.getPropertyPath() + ": " + violation.getMessage());
            	stringBuilder.append("<br />");
            });
            
            request.setAttribute("user", user);
            request.setAttribute("errors", stringBuilder);
            dispatcher.forward(request, response);
        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        userDao.delete(id);
        response.sendRedirect("users");
    }

}


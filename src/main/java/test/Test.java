package test;

import java.time.LocalDate;
import java.util.List;

import dao.UserDAO;
import daoImpl.UserDAOImpl;
import jakarta.persistence.Persistence;
import models.User;

public class Test {
	public static void main(String[] args) {
		UserDAO userDao = new UserDAOImpl(Persistence.createEntityManagerFactory("user-management").createEntityManager());
		userDao.save(new User("John1111", "22222222", "john@gmail.com", "USA", LocalDate.of(2000, 10, 10), "Male"));
		userDao.save(new User("Smith111", "22222222", "smith@gmail.com", "UK", LocalDate.of(2000, 10, 10), "Male"));
		userDao.save(new User("David111", "22222222", "david@gmail.com", "USE", LocalDate.of(1999, 9, 1), "Male"));
		List<User> list = userDao.findAll();
		list.forEach(u -> System.out.println(u.getFirstName() + " " + u.getLastName()));
		// After remove the user
//		System.out.println("After remove the user");
//		userDao.delete(1);
//		list = userDao.findAll();
//		list.forEach(u -> System.out.println(u.getName()));
		LocalDate date = LocalDate.of(2000, 10, 10);
		date.getDayOfMonth();
		date.getMonthValue();
		date.getYear();
	}
}

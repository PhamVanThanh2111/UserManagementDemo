package daoImpl;

import java.util.List;

import dao.UserDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import models.User;

@SuppressWarnings("unchecked")
public class UserDAOImpl implements UserDAO {

	private EntityManager entityManager;
	public UserDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public User save(User user) { 
		EntityTransaction transaction = null;
		try {
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(user);
			transaction.commit();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			
			if(transaction!=null && transaction.isActive()) {
				transaction.rollback();
			}
		}
		
		return null;
	}

	@Override
	public User update(User user) {
		EntityTransaction transaction = null;
		try {
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.merge(user);
			transaction.commit();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			
			if(transaction!=null && transaction.isActive()) {
				transaction.rollback();
			}
		}
		return null;
	}

	@Override
	public boolean delete(int id) {
		EntityTransaction transaction = null;
		try {
			transaction = entityManager.getTransaction();
			transaction.begin();
			User user = entityManager.find(User.class, id);
			if (user != null) {
				entityManager.remove(entityManager.contains(user) ? user : entityManager.merge(user));
			}
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			if(transaction!=null && transaction.isActive()) {
				transaction.rollback();
			}
		}
		return false;
	}

	@Override
	public User findById(int id) {
		try {
			User user = entityManager.find(User.class, id);
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<User> findAll() {
		try {
//			return entityManager.createNamedQuery("User.findAllNative").getResultList();
//			return entityManager.createNamedQuery("User.findAll").getResultList();
			return entityManager.createQuery("FROM User").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

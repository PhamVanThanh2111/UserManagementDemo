package dao;

import java.util.List;

import models.User;

public interface UserDAO {
	/**
     * Save User
     * @param user
     * @return 
     */
    public User save(User user);

    /**
     * Update User
     * @param user
     * @return 
     */
    public User update(User user);

    /**
     * Delete User
     * @param id
     * @return
     */
    public boolean delete(int id);

    /**
     * Get User By ID
     * @param id
     * @return
     */
    public User findById(int id) ;

    /**
     * Get all Users
     * @return
     */
    public List<User> findAll();
}

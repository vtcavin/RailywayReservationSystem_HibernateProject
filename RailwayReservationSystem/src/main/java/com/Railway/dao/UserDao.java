package com.Railway.dao;

import java.util.List;

import com.Railway.entity.User;
import com.Railway.entity.Payment;

public interface UserDao {
	
	
	//User
    User createUser(User user);   
    User getUserById(String userId);
    void updateUser(User user);
    List<User> getAllUser();
    void deleteUser(String userId);
    

    

}

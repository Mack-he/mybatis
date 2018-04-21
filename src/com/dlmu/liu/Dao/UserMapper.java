package com.dlmu.liu.Dao;

import java.util.List;

import com.dlmu.liu.pojo.User;

public interface UserMapper {
	
	public User findUserById(int id)throws Exception;
	
	public List<User> findUserByName(String username)throws Exception;
	
	public void insertUser(User user)throws Exception;

}

package com.briup.Dao;

import com.briup.Bean.User;

public interface IUserDao {
	//通过名字产看用户
	User findUserbyUserid(String userid);
	void saveUser(User user);
	void UpdateUser(User user);
}

package com.byh.mall.dao;
import com.byh.mall.entity.User;

public interface UserDAO
{

	public User getKey(Long id);
	public User checkUsername(String username);
	public void saveUser(User user);
	public void updateUser(User user);
	public void deleteUser(Long id);

}

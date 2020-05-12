package com.byh.mall.service;
import com.byh.mall.entity.User;

public interface UserService
{
	public User getKey(Long id);
	public User checkUsername(String username);
	public void saveUser(User user);
	public void updateUser(User user);
	public void deleteUser(Long id);
}

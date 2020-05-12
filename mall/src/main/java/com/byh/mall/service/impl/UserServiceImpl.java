package com.byh.mall.service.impl;
import com.byh.mall.base.BaseService;
import com.byh.mall.dao.UserDAO;
import com.byh.mall.entity.User;
import com.byh.mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl extends BaseService implements UserService
{
	@Autowired
	private UserDAO userDAO;
	@Override
	public User getKey(Long id)
	{
		return userDAO.getKey(id);
	}
	@Override
	public User checkUsername(String username)
	{
		return userDAO.checkUsername(username);
	}
	@Override
	public void saveUser(User user)
	{
		userDAO.saveUser(user);
	}
	@Override
	public void updateUser(User user)
	{
		userDAO.updateUser(user);
	}
	@Override
	public void deleteUser(Long id)
	{
		userDAO.deleteUser(id);
	}
}

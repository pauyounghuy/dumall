package com.byh.mall.dao.impl;
import com.byh.mall.base.BaseDAO;
import com.byh.mall.dao.UserDAO;
import com.byh.mall.dao.mapper.UserMapper;
import com.byh.mall.entity.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

@Repository
public class UserDAOImpl extends BaseDAO implements UserDAO
{
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	@Override
	public User getKey(Long id)
	{
		return userMapper.selectByPrimaryKey(id);
	}
	@Override
	public User checkUsername(String username)
	{
		Example example =new Example(User.class);
		example.createCriteria().orEqualTo("username",username).orEqualTo("email", username).orEqualTo("mobile", username);
		return userMapper.selectOneByExample(example);
	}
	@Override
	public void saveUser(User user)
	{
		userMapper.insertUseGeneratedKeys(user);
	}
	@Override
	public void updateUser(User user)
	{
		userMapper.updateByPrimaryKeySelective(user);
	}
	@Override
	public void deleteUser(Long id)
	{
		userMapper.deleteByPrimaryKey(id);
	}
}

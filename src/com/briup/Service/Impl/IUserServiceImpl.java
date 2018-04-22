package com.briup.Service.Impl;

import org.apache.ibatis.session.SqlSession;

import com.briup.Bean.User;
import com.briup.Dao.IUserDao;
import com.briup.Service.IUserService;
import com.briup.common.exception.ServiceException;
import com.briup.common.util.MyBatisSqlSessionFactory;

public class IUserServiceImpl implements IUserService{
	public IUserDao getIUserDao(){
		SqlSession session=MyBatisSqlSessionFactory.openSession();
		IUserDao dao=session.getMapper(IUserDao.class);
		return dao;
	}
	@Override
	public void updateUserinfo(User user) throws ServiceException {
		SqlSession session=MyBatisSqlSessionFactory.openSession(true);
		IUserDao dao=session.getMapper(IUserDao.class);
		User u=dao.findUserbyUserid(user.getUserid());
		if(u==null){
			throw new ServiceException("用户已经存在");
		}else{
			dao.UpdateUser(user);
		}
	}

	@Override
	public void registerUser(User user) throws ServiceException {
		// TODO Auto-generated method stub
		//查询用户，如果存在抛异常给RegisterSer，直接跳转到register.jsp
		SqlSession session=MyBatisSqlSessionFactory.openSession(true);
		IUserDao dao=session.getMapper(IUserDao.class);
		User u=dao.findUserbyUserid(user.getUserid());
		if(u!=null){
			throw new ServiceException("用户已经存在");
		}
		dao.saveUser(user);
	}

	@Override
	public User login(String userid, String password) throws ServiceException {
		// TODO Auto-generated method stub
		SqlSession session=MyBatisSqlSessionFactory.openSession(true);
		IUserDao dao=session.getMapper(IUserDao.class);
		User user=dao.findUserbyUserid(userid);
		if(user==null){
			throw new ServiceException("用户不存在");
		}else{
			if(!password.equals(user.getPassword())){
				throw new ServiceException("密码错误");
			}
		}
		return user;
	}
	
}







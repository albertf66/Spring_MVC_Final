package com.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.entity.User;
import com.spring.util.MyBatisUtil;

@Repository
public class UserMapper {
	public List<User> getAllGuest(){
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		List<User> guestList = session.selectList("getAllGuest");
		session.commit();
		session.close();
		return guestList;
	}
	
	public List<User> getGuestAccount(){
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		List<User> adminList = session.selectList("findByEmail");
		session.commit();
		session.close();
		return adminList;
	}
	
	public void addUser(User user) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.insert("addUser", user);
		session.commit();
		session.close();
	}
	
	public void deleteUser(int userId) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.delete("deleteUser", userId);
		session.commit();
		session.close();
	}
	
	public User findById(int userId) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		User user = (User) session.selectOne("findById", userId);
		session.commit();
		session.close();
		return user;
	}
	
	public User findByEmail(String userEmail) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		User user = (User) session.selectOne("findByEmail", userEmail);
		session.commit();
		session.close();
		return user;
	}
	
	public String findPw(String userEmail) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		User user = (User) session.selectOne("findByEmail", userEmail);
		session.commit();
		session.close();
		return user.getUser_pw();
	}
	
	public void updateUser(User user) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.update("updateUser", user);
		session.commit();
		session.close();
	}
}

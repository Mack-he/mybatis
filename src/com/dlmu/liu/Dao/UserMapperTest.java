package com.dlmu.liu.Dao;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.dlmu.liu.Dao.UserMapper;
import com.dlmu.liu.pojo.User;

public class UserMapperTest {
	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void setUp() throws Exception {
		String resource = "SqlMapperConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
				
	}

	@Test
	public void testFindUserById() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userDao = sqlSession.getMapper(UserMapper.class);
		User user = userDao.findUserById(1);
		System.out.println(user);
	}
	
	@Test
	public void testFindUserByName()throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> list = userMapper.findUserByName("小明");
		System.out.println(list);
	}
	
	@Test
	public void testInsertUser()throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		user.setAddress("lala");
		user.setBirthday(new Date());
		user.setDetail("123");
		user.setScore(100);
		user.setSex(1);
		user.setUsername("邓珊珊");
		userMapper.insertUser(user);
		sqlSession.commit();
		
	}

}

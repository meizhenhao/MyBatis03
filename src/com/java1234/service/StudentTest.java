package com.java1234.service;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.java1234.mappers.StudentMapper;
import com.java1234.model.Student;
import com.java1234.util.SqlSessionFactoryUtil;

public class StudentTest {

	private static Logger logger=Logger.getLogger(StudentTest.class);
	private SqlSession sqlSession=null;
	private StudentMapper studentMapper=null;
	
	/**
	 * 测试方法前调用
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		sqlSession=SqlSessionFactoryUtil.openSession();
		studentMapper=sqlSession.getMapper(StudentMapper.class);
	}

	/**
	 * 测试方法后调用
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		sqlSession.close();
	}

	@Test
	public void testInsert() {
		logger.info("添加学生");
		Student student=new Student("琪琪",11);
		studentMapper.insertStudent(student);
		sqlSession.commit();
	}
	
	@Test
	public void testUpdate() {
		logger.info("更新学生");
		Student student=new Student(6,"琪琪2",12);
		studentMapper.updateStudent(student);
		sqlSession.commit();
	}
	
	@Test
	public void testDelete() {
		logger.info("删除学生");
		studentMapper.deleteStudent(6);
		sqlSession.commit();
	}
	
	@Test
	public void testGetById() {
		logger.info("通过ID查找学生");
		Student student=studentMapper.getStudentById(1);
		System.out.println(student);
	}
	
	@Test
	public void testFindStudents() {
		logger.info("查找所有学生");
		List<Student> studentList=studentMapper.findStudents();
		for(Student student:studentList){
			System.out.println(student);
		}
	}

}

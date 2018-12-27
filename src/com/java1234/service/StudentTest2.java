package com.java1234.service;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.java1234.mappers.GradeMapper;
import com.java1234.mappers.StudentMapper;
import com.java1234.model.Grade;
import com.java1234.model.Student;
import com.java1234.util.SqlSessionFactoryUtil;

public class StudentTest2 {

	private static Logger logger=Logger.getLogger(StudentTest2.class);
	private SqlSession sqlSession=null;
	private StudentMapper studentMapper=null;
	private GradeMapper gradeMapper=null;
	
	/**
	 * 测试方法前调用
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		sqlSession=SqlSessionFactoryUtil.openSession();
		studentMapper=sqlSession.getMapper(StudentMapper.class);
		gradeMapper=sqlSession.getMapper(GradeMapper.class);
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
	public void testSelectStudentWithAddress() {
		logger.info("查找学生(带地址)");
		Student student=studentMapper.selectStudentWithAddress(3);
		System.out.println(student);
	}
	
	@Test
	public void testSelectGradeWithStudents() {
		logger.info("查找年级(带学生)");
		Grade grade=gradeMapper.findById(2);
		System.out.println(grade);
		List<Student> studentList=grade.getStudents();
		for(Student student:studentList){
			System.out.println(student);
		}
	}
	
	@Test
	public void testSelectStudentWithAddressAndGrade() {
		logger.info("查找学生(带年级，带地址)");
		Student student=studentMapper.selectStudentWithAddressAndGrade(1);
		System.out.println(student);
	}
	
}

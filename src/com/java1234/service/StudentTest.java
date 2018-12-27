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
	 * ���Է���ǰ����
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		sqlSession=SqlSessionFactoryUtil.openSession();
		studentMapper=sqlSession.getMapper(StudentMapper.class);
	}

	/**
	 * ���Է��������
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		sqlSession.close();
	}

	@Test
	public void testInsert() {
		logger.info("���ѧ��");
		Student student=new Student("����",11);
		studentMapper.insertStudent(student);
		sqlSession.commit();
	}
	
	@Test
	public void testUpdate() {
		logger.info("����ѧ��");
		Student student=new Student(6,"����2",12);
		studentMapper.updateStudent(student);
		sqlSession.commit();
	}
	
	@Test
	public void testDelete() {
		logger.info("ɾ��ѧ��");
		studentMapper.deleteStudent(6);
		sqlSession.commit();
	}
	
	@Test
	public void testGetById() {
		logger.info("ͨ��ID����ѧ��");
		Student student=studentMapper.getStudentById(1);
		System.out.println(student);
	}
	
	@Test
	public void testFindStudents() {
		logger.info("��������ѧ��");
		List<Student> studentList=studentMapper.findStudents();
		for(Student student:studentList){
			System.out.println(student);
		}
	}

}

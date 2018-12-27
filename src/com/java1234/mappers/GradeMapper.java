package com.java1234.mappers;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.java1234.model.Grade;

public interface GradeMapper {

	@Select("select * from t_grade where id=#{id}")
	@Results(
			{
				@Result(id=true,column="id",property="id"),
				@Result(column="gradeName",property="gradeName"),
				@Result(column="id",property="students",many=@Many(select="com.java1234.mappers.StudentMapper.selectStudentByGradeId"))
			}
	)
	public Grade findById(Integer id);

}

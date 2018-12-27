package com.java1234.mappers;

import org.apache.ibatis.annotations.Select;

import com.java1234.model.Address;

public interface AddressMapper {

	@Select("select * from t_address where id=#{id}")
	public Address findById(Integer id);

}

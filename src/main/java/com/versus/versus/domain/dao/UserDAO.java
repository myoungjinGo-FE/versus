package com.versus.versus.domain.dao;

import com.versus.versus.domain.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDAO {
    // 사용자 정보 입력
    @Insert("INSERT INTO user (gender, age, bloodType) values (#{gender}, #{age}, #{bloodType})")
    public void insert(String gender, String age, String bloodType);

    // 사용자 정보 검색
    @Select("SELECT * FROM user WHERE gender = #{gender}  AND age = #{age} AND bloodType = #{bloodType} ")
    public User select(String gender, String age, String bloodType);
}

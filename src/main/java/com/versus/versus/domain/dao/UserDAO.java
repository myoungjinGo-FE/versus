package com.versus.versus.domain.dao;

import com.versus.versus.domain.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDAO {
    // 사용자 정보 입력
    @Insert("INSERT INTO user (gender, age, bloodType) values (#{gender}, #{age}, #{bloodType})")
    public void insert(User user);
}

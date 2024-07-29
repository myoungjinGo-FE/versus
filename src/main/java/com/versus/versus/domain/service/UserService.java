package com.versus.versus.domain.service;

import com.versus.versus.domain.entity.User;

public interface UserService {
    // 사용자 정보 입력
    public User registerUser(String gender, String age, String bloodType);
}


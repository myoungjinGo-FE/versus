package com.versus.versus.domain.service.impl;

import com.versus.versus.domain.dao.UserDAO;
import com.versus.versus.domain.entity.User;
import com.versus.versus.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO dao;

    @Override
    public void registerUser(User user) {
        dao.insert(user);
    }
}

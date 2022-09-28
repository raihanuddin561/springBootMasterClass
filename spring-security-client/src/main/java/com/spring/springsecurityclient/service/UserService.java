package com.spring.springsecurityclient.service;

import com.spring.springsecurityclient.entity.User;
import com.spring.springsecurityclient.model.UserModel;

public interface UserService {
    User registerUser(UserModel userModel);
}

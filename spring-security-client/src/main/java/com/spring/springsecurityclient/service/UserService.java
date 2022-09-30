package com.spring.springsecurityclient.service;

import com.spring.springsecurityclient.entity.User;
import com.spring.springsecurityclient.model.UserModel;

public interface UserService {
    User registerUser(UserModel userModel);

    void saveVerificationToken(User user, String token);

    void verifyRegistration(String token);

    String validateVerificationToken(String token);
}

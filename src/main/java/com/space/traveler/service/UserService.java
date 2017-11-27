package com.space.traveler.service;

import com.space.traveler.model.User;

public interface UserService {

    User findByEmail(String email);
    void saveUser(User user);

}

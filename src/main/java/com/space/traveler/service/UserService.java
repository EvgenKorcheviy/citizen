package com.space.traveler.service;

import com.space.traveler.entity.SecUser;

public interface UserService {

    void save(SecUser user);

    SecUser findByUsername(String username);

}

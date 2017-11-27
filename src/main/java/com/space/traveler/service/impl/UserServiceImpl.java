package com.space.traveler.service.impl;

import com.space.traveler.dao.SecRoleDao;
import com.space.traveler.dao.SecUserDao;
import com.space.traveler.entity.SecUser;
import com.space.traveler.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SecUserDao userDao;

    @Autowired
    private SecRoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(SecUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleDao.findAll()));
        userDao.create(user);
    }

    @Override
    public SecUser findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}

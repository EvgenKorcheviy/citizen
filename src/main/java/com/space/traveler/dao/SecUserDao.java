package com.space.traveler.dao;

import com.space.traveler.entity.SecUser;

public interface SecUserDao extends BaseDao<SecUser> {

    SecUser findByUsername(String username);

}

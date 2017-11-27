package com.space.traveler.dao.impl;

import com.space.traveler.dao.BaseDaoImpl;
import com.space.traveler.dao.SecUserDao;
import com.space.traveler.entity.SecUser;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;

@Repository
public class SecUserDaoImpl extends BaseDaoImpl<SecUser> implements SecUserDao {
    @Override
    public SecUser findByUsername(String username) {
        TypedQuery<SecUser> query = entityManager
                .createNamedQuery(SecUser.FIND_BY_USERNAME, SecUser.class).setParameter("username", username);
        return query.getSingleResult();
    }
}

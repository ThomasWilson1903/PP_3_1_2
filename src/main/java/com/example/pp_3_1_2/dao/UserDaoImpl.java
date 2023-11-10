package com.example.pp_3_1_2.dao;

import com.example.pp_3_1_2.model.User;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    private EntityManager entityManagers;
    @Autowired
    public UserDaoImpl(EntityManager entityManagers) {
        this.entityManagers = entityManagers;
    }

    @Override
    public List<User> getAllUsers() {
        Session session = entityManagers.unwrap(Session.class);
        return session.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User getUser(int id) {
        Session session = entityManagers.unwrap(Session.class);
        return session.find(User.class, id);
    }

    @Override
    public void saveUser(User user) {
        Session session = entityManagers.unwrap(Session.class);
        session.merge(user);
        session.flush();
    }

    @Override
    public void deleteUser(int id) {
        Session session = entityManagers.unwrap(Session.class);
        session.remove(entityManagers.find(User.class, id));
    }
}

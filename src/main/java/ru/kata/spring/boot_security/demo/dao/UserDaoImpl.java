package ru.kata.spring.boot_security.demo.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<User> getUsers() {
        TypedQuery<User> query = em.createQuery("FROM User", User.class);
        return query.getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getLimitedUsers(int count) {
        TypedQuery<User> query = em.createQuery("FROM User", User.class).setMaxResults(count);
        return query.getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(int id) {
        return em.find(User.class, id);
    }

    @Override
    @Transactional
    public void addUser(User user) {
        em.persist(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        final var user1 = em.find(User.class, user.getId());
        user1.setName(user.getName());
        user1.setAge(user.getAge());
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        em.remove(em.find(User.class, id));
    }
}

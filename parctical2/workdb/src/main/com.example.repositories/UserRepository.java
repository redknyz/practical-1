package com.example.repositories;

import com.example.models.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserRepository {
    private EntityManager entityManager;

    public UserRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<User> getAllUsers() {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }
}
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public UserRepository() {
        entityManagerFactory = Persistence.createEntityManagerFactory("your-persistence-unit-name");
        entityManager = entityManagerFactory.createEntityManager();
    }

    // Позже в классе добавьте методы для закрытия EntityManager и EntityManagerFactory:
    public void closeEntityManager() {
        entityManager.close();
        entityManagerFactory.close();
    }
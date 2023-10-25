package com.mypackage.UserRepository;

import com.mypackage.User.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserRepository {
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public UserRepository() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public List<User> getAllUsers() {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }

    public void closeEntityManager() {
        if (this.entityManager != null) {
            this.entityManager.close();
        }

        if (this.entityManagerFactory != null) {
            this.entityManagerFactory.close();
        }
    }
}

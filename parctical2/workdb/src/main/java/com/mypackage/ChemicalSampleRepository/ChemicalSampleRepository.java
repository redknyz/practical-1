package com.mypackage.ChemicalSampleRepository;

import com.mypackage.ChemicalSample.ChemicalSample;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class ChemicalSampleRepository {
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public ChemicalSampleRepository() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public List<ChemicalSample> getAllSamples() {
        TypedQuery<ChemicalSample> query = entityManager.createQuery("SELECT s FROM ChemicalSample s", ChemicalSample.class);
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

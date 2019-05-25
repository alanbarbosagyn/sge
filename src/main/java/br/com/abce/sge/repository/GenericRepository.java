package br.com.abce.sge.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GenericRepository {

    private static EntityManagerFactory entityManagerFactory;

    public GenericRepository() {

        if (entityManagerFactory == null)
            entityManagerFactory = Persistence.createEntityManagerFactory("sge");
    }

    protected EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}

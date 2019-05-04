package com.MedicalCenter.DBUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class EntityManagerInstance {

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("MedicalCenter");
    @PersistenceContext
    private static volatile EntityManager manager;

    private EntityManagerInstance() {
    }

    public static EntityManager getEntityManager() {
        if (manager == null) {
            synchronized (EntityManagerInstance.class) {
                if (manager == null) {
                    manager = factory.createEntityManager();
                }
            }
        }
        return manager;
    }
}

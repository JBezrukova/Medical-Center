package com.MedicalCenter.DAO;

import com.MedicalCenter.DBUtils.EntityManagerInstance;
import com.MedicalCenter.entities.Administrator;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

public class AdministratorDAO {
    private static EntityManager entityManager;
    private static AdministratorDAO administrator;

    private static final String adminByLogin =
            "from Administrator where login = ?1";

    private AdministratorDAO() {
    }

    public static AdministratorDAO getDAO() {
        if (administrator == null) {
            synchronized (AdministratorDAO.class) {
                if (administrator == null) {
                    administrator = new AdministratorDAO();
                    entityManager = EntityManagerInstance.getEntityManager();
                }
            }
        }
        return administrator;
    }

    public Administrator getAdminByLogin(String login) {
        try {
            Administrator administrator = (Administrator) entityManager
                    .createQuery(adminByLogin)
                    .setParameter(1, login)
                    .getSingleResult();
            return administrator;
        } catch (NoResultException e) {
            return null;
        }
    }
}


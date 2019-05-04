package com.MedicalCenter.DAO;

import com.MedicalCenter.DBUtils.EntityManagerInstance;
import com.MedicalCenter.entities.User;

import javax.persistence.EntityManager;

public class UserDAO {

    private static final String getIdByLogin =
            "Select user_id from User where login = ?1";
     private static final String getUserByLogin =
             "from User where login = ?1";

    private static EntityManager entityManager;
    private static UserDAO userDAO;

    private UserDAO() {
    }

    public static UserDAO getDAO() {
        if (userDAO == null) {
            synchronized (UserDAO.class) {
                if (userDAO == null) {
                    userDAO = new UserDAO();
                    entityManager = EntityManagerInstance.getEntityManager();
                }
            }
        }
        return userDAO;
    }

    public int getIdByLogin(String login) {
        int userId = (int) entityManager.createQuery(getIdByLogin)
                .setParameter(1, login)
                .getSingleResult();
        return userId;
    }

    public User getUserByLOgin(String login){
        User user = (User) entityManager.createQuery(getUserByLogin)
                .setParameter(1, login)
                .getSingleResult();
        return user;
    }
}

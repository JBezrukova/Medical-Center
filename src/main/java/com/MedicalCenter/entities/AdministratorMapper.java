package com.MedicalCenter.entities;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class AdministratorMapper {

    private static org.hibernate.SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public static Session getOpenSession() {
        return sessionFactory.openSession();
    }

    public AdministratorM getAdminByLogin(String login) {
        Session session = getOpenSession();
        session.beginTransaction();
        Query query = session.createQuery("from Administrator where login = :login");
        query.setParameter("login", login);
        List<AdministratorM> administratorList = query.list();
        session.close();
        return administratorList.get(0);
    }
}

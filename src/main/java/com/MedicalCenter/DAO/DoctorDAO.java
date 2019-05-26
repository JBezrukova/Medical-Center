package com.MedicalCenter.DAO;

import com.MedicalCenter.DBUtils.EntityManagerInstance;
import com.MedicalCenter.entities.Doctor;
import com.MedicalCenter.entities.DoctorCategory;
import com.MedicalCenter.entities.Record;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.print.Doc;
import java.util.List;

public class DoctorDAO {

    private static EntityManager entityManager;
    private static DoctorDAO doctorDAO;

    private static final String doctorsForCategory =
            "from Doctor where specialization = ?1";
    private static final String getDoctorIDByName =
            "select doctor_id from Doctor where name = ?1";
    private static final String getDoctorsForCategoryPower =
            "from Doctor where category = ?1";

    private static final String getDoctorByLogin =
            "from Doctor where login = ?1";


    private DoctorDAO() {
    }

    public static DoctorDAO getDAO() {
        if (doctorDAO == null) {
            synchronized (DoctorDAO.class) {
                if (doctorDAO == null) {
                    doctorDAO = new DoctorDAO();
                    entityManager = EntityManagerInstance.getEntityManager();
                }
            }
        }
        return doctorDAO;
    }

    public List<Doctor> find(String spec) {
        DoctorCategory category = CategoriesDAO.getDAO().getIDFromName(spec);
        List<Doctor> doctors = entityManager
                .createQuery(doctorsForCategory)
                .setParameter(1, category)
                .getResultList();
        return doctors;
    }

    public int getIDByName(String name) {
        int id = (int) entityManager
                .createQuery(getDoctorIDByName)
                .setParameter(1, name)
                .getSingleResult();
        return id;
    }

    public Doctor getDoctorByID(int id) {
        Doctor doctor = entityManager.find(Doctor.class, id);
        return doctor;
    }

    public List<Doctor> getBestDoctors(){
        List<Doctor> doctors = entityManager
                .createQuery(getDoctorsForCategoryPower)
                .setParameter(1, "высшая")
                .getResultList();
        return doctors;
    }

    public Doctor getDocByLogin(String login) {
        try {
            Doctor doctor = (Doctor) entityManager
                    .createQuery(getDoctorByLogin)
                    .setParameter(1, login)
                    .getSingleResult();
            return doctor;
        } catch (NoResultException e) {
            return null;
        }
    }

}

package com.MedicalCenter.DAO;

import com.MedicalCenter.DBUtils.EntityManagerInstance;
import com.MedicalCenter.entities.Doctor;
import com.MedicalCenter.entities.Request;
import com.MedicalCenter.entities.User;

import javax.persistence.EntityManager;
import java.util.List;

public class RequestDAO {

    private static EntityManager entityManager;
    private static RequestDAO requestDAO;

    private static final String getRequestsForUser =
            "from Request where user = ?1";

    private static final String getRequestsForDoctor =
            "from Request where doctor = ?1 and reason = ?2";

    private static final String getRequestsByID =
            "from Request where id = ?1";

    private static final String getRequests =
            "from Request";

    private RequestDAO() {
    }

    public static RequestDAO getDAO() {
        if (requestDAO == null) {
            synchronized (DoctorDAO.class) {
                if (requestDAO == null) {
                    requestDAO = new RequestDAO();
                    entityManager = EntityManagerInstance.getEntityManager();
                }
            }
        }
        return requestDAO;
    }

    public void createRequest(User user, Doctor doctor, String date, String time, String reason) {
        entityManager.getTransaction().begin();
        Request request = new Request();
        request.setUser(user);
        request.setDoctor(doctor);
        request.setDate(date);
        request.setTime(time);
        request.setReason(reason);
        entityManager.persist(request);
        entityManager.getTransaction().commit();
    }

    public List<Request> getRequestsForUser(int id) {
        User user = UserDAO.getDAO().getUserByID(id);
        List<Request> requests = entityManager
                .createQuery(getRequestsForUser)
                .setParameter(1, user)
                .getResultList();
        return requests;
    }

    public List<Request> getRequestsForDoctor(Doctor doctor) {
        List<Request> requests = entityManager
                .createQuery(getRequestsForDoctor)
                .setParameter(1, doctor)
                .setParameter(2, "create")
                .getResultList();
        return requests;
    }

    public List<Request> getRequests() {
        List<Request> requests = entityManager
                .createQuery(getRequests)
                .getResultList();
        return requests;
    }

    public Request getRequestById(int id) {
        Request request = (Request) entityManager
                .createQuery(getRequestsByID)
                .setParameter(1, id)
                .getSingleResult();
        return request;
    }

    public void removeRequest(Request request) {
        entityManager.getTransaction().begin();
        entityManager.remove(request);
        entityManager.getTransaction().commit();

    }
}

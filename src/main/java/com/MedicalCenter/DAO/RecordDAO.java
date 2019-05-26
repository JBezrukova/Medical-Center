package com.MedicalCenter.DAO;

import com.MedicalCenter.DBUtils.EntityManagerInstance;
import com.MedicalCenter.entities.Doctor;
import com.MedicalCenter.entities.Record;
import com.MedicalCenter.entities.Request;
import com.MedicalCenter.entities.User;

import javax.persistence.EntityManager;
import javax.print.Doc;
import java.util.List;

public class RecordDAO {

    private static EntityManager entityManager;
    private static RecordDAO recordDAO;

    private static final String recordsForDoctor =
            "from Record where doctor = ?1 and date = ?2";

    private static final String recordsByRequest =
            "from Record where doctor = ?1 and date = ?2 and user = ?3 and time = ?4";

    private static final String recordsByID =
            "from Record where id = ?1";
    private static final String recordsForUser =
            "from Record where user = ?1";
    private static final String allRecordsForDoctor =
            "from Record where doctor = ?1";


    private RecordDAO() {
    }

    public static RecordDAO getDAO() {
        if (recordDAO == null) {
            synchronized (DoctorDAO.class) {
                if (recordDAO == null) {
                    recordDAO = new RecordDAO();
                    entityManager = EntityManagerInstance.getEntityManager();
                }
            }
        }
        return recordDAO;
    }

    public List<Record> recordsForDoctor(Doctor doctor, String date) {
        List<Record> records = entityManager
                .createQuery(recordsForDoctor)
                .setParameter(1, doctor)
                .setParameter(2, date)
                .getResultList();
        return records;
    }

    public List<Record> recordsForUser(User user) {
        List<Record> records = entityManager
                .createQuery(recordsForUser)
                .setParameter(1, user)
                .getResultList();
        return records;
    }

    public List<Record> recordsForDoctor(Doctor doctor) {
        List<Record> records = entityManager
                .createQuery(allRecordsForDoctor)
                .setParameter(1, doctor)
                .getResultList();
        return records;
    }


    public Record getRecordByID(int id) {
        Record record = (Record) entityManager
                .createQuery(recordsByID)
                .setParameter(1, id)
                .getSingleResult();
        return record;
    }

    public void removeRecord(Request request) {
        Record record = (Record) entityManager
                .createQuery(recordsByRequest)
                .setParameter(1, request.getDoctor())
                .setParameter(2, request.getDate())
                .setParameter(3, request.getUser())
                .setParameter(4, request.getTime())
                .getSingleResult();
        entityManager.getTransaction().begin();
        entityManager.remove(record);
        entityManager.getTransaction().commit();
    }

    public void createRecord(Request request) {
        Record record = new Record();
        record.setDate(request.getDate());
        record.setDoctor(request.getDoctor());
        record.setTime(request.getTime());
        record.setUser(record.getUser());
        entityManager.getTransaction().begin();
        entityManager.persist(record);
        entityManager.getTransaction().commit();
    }
}

package com.MedicalCenter.DAO;

import com.MedicalCenter.DBUtils.EntityManagerInstance;
import com.MedicalCenter.entities.CardNote;
import com.MedicalCenter.entities.Record;

import javax.persistence.EntityManager;

public class CardNoteDAO {

    private static EntityManager entityManager;
    private static CardNoteDAO cardNoteDAO;

    private CardNoteDAO() {
    }

    public static CardNoteDAO getDAO() {
        if (cardNoteDAO == null) {
            synchronized (CardNoteDAO.class) {
                if (cardNoteDAO == null) {
                    cardNoteDAO = new CardNoteDAO();
                    entityManager = EntityManagerInstance.getEntityManager();
                }
            }
        }
        return cardNoteDAO;
    }

    public void saveNote(Record record, String test, String compl, String med){
        entityManager.getTransaction().begin();
        CardNote cardNote = new CardNote();
        cardNote.setDoctor(record.getDoctor());
        cardNote.setComplaints(compl);
        cardNote.setDate(record.getDate());
        cardNote.setTest(test);
        cardNote.setTreatment(med);
        cardNote.setUserCard(record.getUser().getUserCard());
        entityManager.persist(cardNote);
        entityManager.getTransaction().commit();
    }
}

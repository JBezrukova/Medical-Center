package com.MedicalCenter.entities;

import com.MedicalCenter.DAO.RecordRepository;
import com.MedicalCenter.DAO.UserRepository;

import javax.persistence.*;

@Entity
@Table(name = "record")
public class Record {

        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_id")
    private Integer id;

        @Column(name = "date")
    private String date;

        @Column(name = "time")
    private String time;

   @ManyToOne
   @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    public static boolean createRecordFromRequest(Request request) {
        if (request.getReason().equals("create")) {
            if (request.isApprovedByAdmin() && request.isApprovedByDoctor()) {
                createRecord(request);
                return true;
            }
        } else {
            if (request.isApprovedByAdmin()) {
                removeRequest(request);
                return true;
            }
        }
        return false;
    }

    private static void createRecord(Request request) {
        Record record = extractRecordFromRequest(request);
        RecordRepository.getInstance().add(record);
    }

    private static Record extractRecordFromRequest(Request request) {
        Record record = new Record();
        record.setUser(request.getUser());
        record.setTime(request.getTime());
        record.setDate(request.getDate());
        record.setDoctor(request.getDoctor());
        return record;
    }

    private static void removeRequest(Request request) {
        Record record = RecordRepository.getInstance().find(request);
        RecordRepository.getInstance().remove(record);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}

package com.MedicalCenter.entities;

import javax.persistence.*;

//@Entity
//@Table(name = "request")
public class Request {

    //    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "request_id")
    private Integer id;

    //    @Column(name = "date")
    private String date;

    //    @Column(name = "time")
    private String time;

    //    @OneToOne
//    @JoinColumn(name = "user_id")
    private User user;

    //    @OneToOne
//    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    //    @OneToOne
//    @JoinColumn(name = "category_id")
    private DoctorCategory category;

    //    @Column(name = "reason")
    private String reason;

    private boolean approvedByAdmin;

    private boolean isApprovedByDoctor;

    public boolean isApprovedByAdmin() {
        return approvedByAdmin;
    }

    public void setApprovedByAdmin(boolean approvedByAdmin) {
        this.approvedByAdmin = approvedByAdmin;
    }

    public boolean isApprovedByDoctor() {
        return isApprovedByDoctor;
    }

    public void setApprovedByDoctor(boolean approvedByDoctor) {
        isApprovedByDoctor = approvedByDoctor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public DoctorCategory getCategory() {
        return category;
    }

    public void setCategory(DoctorCategory category) {
        this.category = category;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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
}

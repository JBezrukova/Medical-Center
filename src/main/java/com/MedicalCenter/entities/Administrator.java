package com.MedicalCenter.entities;

import com.MedicalCenter.DAO.RecordDAO;
import com.MedicalCenter.DAO.RequestDAO;

import javax.persistence.*;

@Entity
@Table(name = "admin")
public class Administrator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    public void approveRequest(Request request) {
        request.setApprovedByAdmin(true);
        if (request.getReason().equals("delete")) {
            RequestDAO.getDAO().removeRequest(request);
            RecordDAO.getDAO().removeRecord(request);
        } else {
            if (request.isApprovedByDoctor()) {
                RequestDAO.getDAO().removeRequest(request);
                RecordDAO.getDAO().createRecord(request);
            }
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package com.MedicalCenter.entities;

import com.MedicalCenter.DAO.RequestDAO;
import com.MedicalCenter.entities.enums.RequestReason;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = {"login"}))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer user_id;

    @Column(name = "login", length = 45)
    private String login;

    @Column(name = "password", length = 45)
    private String password;

    @Column(name = "userName", length = 35)
    private String userName;

    @Column(name = "adres", length = 70)
    private String adres;

    @Column(name = "birthDay", length = 10)
    private String birthDay;

    @Column(name = "phone", length = 15)
    private String phone;

    @Column(name = "sex", length = 10)
    private String sex;

    @Column(name = "role", length = 10)
    private String role;

    @OneToOne
    @JoinColumn(name = "user_card_id")
    private UserCard userCard;

    @OneToMany(mappedBy = "user")
    private Set<Request> requests = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Record> records = new HashSet<>();

    public Request createRequest(Doctor doctor, String date, String time, RequestReason requestReason) {
        if (requestReason.equals(RequestReason.CREATE)) {
            if (doctor.checkIfTimeIsEmpty(date, time)) {
                return RequestDAO.getDAO().createRequest(this, doctor, date, time, "create");
            }
        } else {
            return RequestDAO.getDAO().createRequest(this, doctor, date, time, "delete");
        }
        return null;
    }

    public Set<Request> getRequests() {
        return requests;
    }

    public void setRequests(Set<Request> requests) {
        this.requests = requests;
    }

    public Set<Record> getRecords() {
        return records;
    }

    public void setRecords(Set<Record> records) {
        this.records = records;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public UserCard getUserCard() {
        return userCard;
    }

    public void setUserCard(UserCard userCard) {
        this.userCard = userCard;
    }

}

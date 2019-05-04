package com.MedicalCenter.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//@Entity
//
//@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = {"login"}))
public class User {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "user_id")
    private Integer user_id;

//    @Column(name = "login", length = 45)

    private String login;

//    @Column(name = "password", length = 45)
    private String password;

//    @Column(name = "user_name", length = 35)
    private String userName;

//    @Column(name = "adres", length = 70)
    private String adres;

//    @Column(name = "birth_day", length = 10)
    private String birthDay;

//    @Column(name = "phone_number", length = 15)
    private String phone;

//    @Column(name = "sex", length = 10)
    private String sex;

//    @Column(name = "role", length = 10)
    private String role;

//    @OneToOne
//    @JoinColumn(name = "user_card_id")
    private UserCard userCard;

//    @OneToMany
//    @JoinColumn(name = "record_id")
    private Set<Record> records = new HashSet<>();

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

    public Set<Record> getRecords() {
        return records;
    }

    public void setRecords(Set<Record> records) {
        this.records = records;
    }
}

package com.MedicalCenter;

import com.MedicalCenter.DAO.DoctorRepository;
import com.MedicalCenter.DAO.UserRepository;
import com.MedicalCenter.Frames.LogInForm;
import com.MedicalCenter.entities.Doctor;
import com.MedicalCenter.entities.Record;
import com.MedicalCenter.entities.Request;
import com.MedicalCenter.entities.User;
import com.MedicalCenter.entities.enums.RequestReason;
import com.MedicalCenter.logic.CreateRequest;

public class Main {

    public static void main(String[] args) {

        //new LogInForm().setVisible(true);
        User user = new User();
        UserRepository.getInstance().add(user);
        Doctor doctor = new Doctor();
        DoctorRepository.getInstance().add(doctor);
        Request request = CreateRequest.createRequest(user, doctor, "07-05-2019", "10:40", RequestReason.CREATE);
        request.setApprovedByAdmin(true);
        request.setApprovedByDoctor(true);
        Record record = CreateRequest.createRecord(request);
        System.out.println(record == null);
        System.out.println(doctor.getRecords().equals(user.getRecords()));

    }
}
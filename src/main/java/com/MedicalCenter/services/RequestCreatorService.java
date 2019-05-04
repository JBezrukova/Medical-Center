package com.MedicalCenter.services;

import com.MedicalCenter.entities.Doctor;
import com.MedicalCenter.entities.Request;
import com.MedicalCenter.entities.User;
import com.MedicalCenter.entities.enums.RequestReason;

public class RequestCreatorService {

    public static Request createRequest(User user, Doctor doctor, String date, String time, RequestReason requestReason) {
        Request request = new Request();
        request.setUser(user);
        request.setDoctor(doctor);
        request.setTime(time);
        request.setDate(date);
        if (requestReason.equals(RequestReason.CREATE)) {
            request.setReason("create");
        } else {
            request.setReason("delete");
        }
        return request;
    }
}

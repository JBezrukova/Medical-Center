package com.MedicalCenter.logic;

import com.MedicalCenter.DAO.RequestRepository;
import com.MedicalCenter.entities.Doctor;
import com.MedicalCenter.entities.Request;
import com.MedicalCenter.entities.User;
import com.MedicalCenter.entities.enums.RequestReason;
import com.MedicalCenter.services.ApproveCheckService;
import com.MedicalCenter.services.RequestCreatorService;
import org.springframework.beans.factory.annotation.Autowired;

public class CreateRequestInteractor {


    private static RequestRepository requestRepository = RequestRepository.getInstance();

    public void createRequest(User user, Doctor doctor, String date, String time, RequestReason requestReason) {
        Request request = RequestCreatorService.createRequest(user, doctor, date, time, requestReason);
        requestRepository.add(request);
    }

    public void createRecord(Request request) {
        if (ApproveCheckService.checkBothApprove(request)) {

        }
    }


}

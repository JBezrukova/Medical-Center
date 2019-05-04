package com.MedicalCenter.logic;

import com.MedicalCenter.DAO.DoctorRepository;
import com.MedicalCenter.DAO.RecordRepository;
import com.MedicalCenter.DAO.RequestRepository;
import com.MedicalCenter.DAO.UserRepository;
import com.MedicalCenter.entities.Doctor;
import com.MedicalCenter.entities.Record;
import com.MedicalCenter.entities.Request;
import com.MedicalCenter.entities.User;
import com.MedicalCenter.entities.enums.RequestReason;
import com.MedicalCenter.services.ApproveCheckService;
import com.MedicalCenter.services.RecordCreatorService;
import com.MedicalCenter.services.RequestCreatorService;

public class CreateRequest {

    private static RequestRepository requestRepository = RequestRepository.getInstance();
    private static RecordRepository recordRepository = RecordRepository.getInstance();
    private static UserRepository userRepository = UserRepository.getInstance();
    private static DoctorRepository doctorRepository = DoctorRepository.getInstance();

    public static Request createRequest(User user, Doctor doctor, String date, String time, RequestReason requestReason) {
        Request request = RequestCreatorService.createRequest(user, doctor, date, time, requestReason);
        requestRepository.add(request);
        return request;
    }

    public static Record createRecord(Request request) {
        Record record = null;
        if (ApproveCheckService.checkBothApprove(request)) {
            record = RecordCreatorService.createRecord(request);
            recordRepository.add(record);
            userRepository.addRecord(record, record.getUser());
            doctorRepository.addRecord(record, record.getDoctor());
        }
        return record;
    }
}

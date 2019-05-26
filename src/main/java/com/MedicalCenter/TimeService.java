package com.MedicalCenter;

import com.MedicalCenter.DAO.DoctorDAO;
import com.MedicalCenter.DAO.DoctorRepository;
import com.MedicalCenter.DAO.RecordDAO;
import com.MedicalCenter.entities.Doctor;
import com.MedicalCenter.entities.Record;

import java.util.ArrayList;
import java.util.List;

public class TimeService {

    private static List<String> generateTime() {
        List<String> time = new ArrayList<>();
        for (int i = 8; i < 17; i++) {
            time.add(i + ":00");
        }
        return time;
    }

    public static List<String> createScheduleForDoctor(Doctor doctor, String date) {
        List<String> time = generateTime();
        if (doctor.getRecords().size() == 0) {
            return time;
        } else {
            List<Record> records = RecordDAO.getDAO().recordsForDoctor(doctor, date);
            List<String> doctorTimes = new ArrayList<>();
            for (Record record : records) {
                doctorTimes.add(record.getTime());
            }
            time.removeAll(doctorTimes);
            return time;
        }
    }
}

package com.MedicalCenter.DAO;

import com.MedicalCenter.entities.Doctor;
import com.MedicalCenter.entities.DoctorCategory;
import com.MedicalCenter.entities.Record;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class DoctorRepository {

    private static DoctorRepository doctorRepository;
    private ArrayList<Doctor> doctors = new ArrayList<>();
    private static AtomicInteger ID_COUNTER = new AtomicInteger(0);

    private DoctorRepository() {
    }

    public static DoctorRepository getInstance() {
        if (doctorRepository == null) {
            doctorRepository = new DoctorRepository();
        }
        return doctorRepository;
    }

    public Doctor find(int id) {
        return doctors.stream()
                .filter(doctor -> doctor.getID() == id)
                .findFirst().orElse(null);
    }

    public Doctor find(String name) {
        return doctors.stream()
                .filter(doctor -> doctor.getName() == name)
                .findFirst().orElse(null);
    }

    public void add(Doctor doctor) {
        if (doctor.getID() == null) {
            doctor.setID(ID_COUNTER.getAndIncrement());
        }
        for (Doctor doctor1 : doctors) {
            if (doctor1.getID() == doctor.getID()) {
                doctors.remove(doctor1);
            }
        }
        doctors.add(doctor);
    }

    public void addRecord(Record record, Doctor doctor) {
        if (!doctors.contains(doctor)) {
            add(doctor);
        }
        doctor.getRecords().add(record);
    }

}

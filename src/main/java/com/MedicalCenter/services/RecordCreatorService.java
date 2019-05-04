package com.MedicalCenter.services;

import com.MedicalCenter.entities.Record;
import com.MedicalCenter.entities.Request;

public class RecordCreatorService {

    public static Record createRecord(Request request) {
        Record record = new Record();
        record.setDoctor(request.getDoctor());
        record.setUser(request.getUser());
        record.setDate(request.getDate());
        record.setTime(request.getTime());
        return record;
    }
}

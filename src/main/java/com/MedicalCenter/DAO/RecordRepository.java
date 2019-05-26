package com.MedicalCenter.DAO;

import com.MedicalCenter.entities.Record;
import com.MedicalCenter.entities.Request;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class RecordRepository {

    private static RecordRepository recordRepository;
    public ArrayList<Record> records = new ArrayList<>();
    private static AtomicInteger ID_COUNTER = new AtomicInteger(0);

    private RecordRepository() {
    }

    public static RecordRepository getInstance() {
        if (recordRepository == null) {
            recordRepository = new RecordRepository();
        }
        return recordRepository;
    }

    public void remove(Record record) {
        records.remove(record);
        record.getUser().getRecords().remove(record);
        record.getDoctor().getRecords().remove(record);
    }

    public Record find(Request request) {
        return records.stream()
                .filter(record -> record.getUser().equals(request.getUser()))
                .filter(record -> record.getDoctor().equals(request.getDoctor()))
                .filter(record -> record.getDate().equals(request.getDate()))
                .filter(record -> record.getTime().equals(request.getTime()))
                .findFirst().orElse(null);
    }

    public void add(Record record) {
        if (record.getId() == null) {
            record.setId(ID_COUNTER.getAndIncrement());
        }
        for (Record record1 : records) {
            if (record1.getId() == record.getId()) {
                records.remove(record1);
            }
        }
        records.add(record);
        record.getUser().getRecords().add(record);
        record.getDoctor().getRecords().add(record);
    }
}

package com.MedicalCenter.DAO;

import com.MedicalCenter.entities.Record;

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
    }
}

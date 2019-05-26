package com.MedicalCenter.DAO;

import com.MedicalCenter.entities.Doctor;
import com.MedicalCenter.entities.Request;
import com.MedicalCenter.entities.User;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class RequestRepository {

    private static RequestRepository requestRepository;
    private static AtomicInteger ID_COUNTER = new AtomicInteger(0);
    private ArrayList<Request> requests = new ArrayList<>();

    private RequestRepository() {
    }

    public static RequestRepository getInstance() {
        if (requestRepository == null) {
            requestRepository = new RequestRepository();
        }
        return requestRepository;
    }

    public boolean contains(User user, Doctor doctor, String date, String time) {
        if (requests.stream()
                .filter(request -> request.getUser().getUser_id() == user.getUser_id())
                .filter(request -> request.getDoctor().getID() == doctor.getID())
                .filter(request -> request.getDate().equals(date))
                .filter(request -> request.getTime().equals(time))
                .findFirst().orElse(null) != null) {
            return true;
        }
        return false;
    }

    public void add(Request request) {
        if (request.getId() == null) {
            request.setId(ID_COUNTER.getAndIncrement());
        }
        for (Request request1 : requests) {
            if (request1.getId().equals(request.getId())) {
                requests.remove(request1);
            }
        }
        requests.add(request);
        request.getDoctor().getRequests().add(request);
        request.getUser().getRequests().add(request);
    }

    public void remove(Request request) {
        requests.remove(request);
    }
}

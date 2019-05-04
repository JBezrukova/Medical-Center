package com.MedicalCenter.services;

import com.MedicalCenter.entities.Request;

public class ApproveCheckService {

    public static boolean checkAdministratorApprove(Request request) {
        return request.isApprovedByAdmin();
    }

    public static boolean checkDoctorApprove(Request request) {
        return request.isApprovedByDoctor();
    }

    public static boolean checkBothApprove(Request request) {
        return request.isApprovedByDoctor() && request.isApprovedByAdmin();
    }
}

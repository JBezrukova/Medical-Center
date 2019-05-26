package com.MedicalCenter;

import com.MedicalCenter.DAO.DoctorDAO;
import com.MedicalCenter.entities.Doctor;
import com.fasterxml.jackson.databind.util.JSONPObject;
import netscape.javascript.JSObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import static spark.Spark.*;

public class RestAPI {

    public RestAPI() {
        List<Doctor> doctors = DoctorDAO.getDAO().getBestDoctors();
        StringBuilder stringBuilder = new StringBuilder();
        JSONArray array = new JSONArray();
        for (Doctor doctor : doctors) {

            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("id", doctor.getID());
                jsonObject.put("name", doctor.getName());
                jsonObject.put("spec", doctor.getSpecialization().getName());
                array.put(jsonObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        //http://localhost:4567/bestDoctors
        get("/bestDoctors", (req, res) -> array.toString());
    }
}

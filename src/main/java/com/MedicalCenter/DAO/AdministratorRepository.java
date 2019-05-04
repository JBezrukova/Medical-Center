package com.MedicalCenter.DAO;

import com.MedicalCenter.entities.Administrator;

public class AdministratorRepository {

    private static AdministratorRepository administratorRepository;

    private static Administrator administrator;

    private AdministratorRepository() {
    }

    public static Administrator get() {
        if (administrator == null) {
            administrator = new Administrator();
            administrator.setId(0);
            administrator.setName("Администратор");
            administrator.setLogin("admin");
            administrator.setPassword("admin");
            administrator.setPhone("894563254154");
        }
        return administrator;
    }
}

package com.MedicalCenter.DAO;

import com.MedicalCenter.DBUtils.EntityManagerInstance;
import com.MedicalCenter.entities.DoctorCategory;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoriesDAO {

    private static EntityManager entityManager;
    private static CategoriesDAO categoriesDAO;

    private static final String getAllCategories =
            "from DoctorCategory";

    private static final String finrIdByName =
            "select category_id from DoctorCategory where name = ?1";

    private static final String findCategoryByName =
            "from DoctorCategory where name = ?1";

    private CategoriesDAO() {
    }

    public static CategoriesDAO getDAO() {
        if (categoriesDAO == null) {
            synchronized (CategoriesDAO.class) {
                if (categoriesDAO == null) {
                    categoriesDAO = new CategoriesDAO();
                    entityManager = EntityManagerInstance.getEntityManager();
                }
            }
        }
        return categoriesDAO;
    }

    public List<DoctorCategory> getAllCategories() {
        List<DoctorCategory> categories =
                entityManager
                        .createQuery(getAllCategories)
                        .getResultList();
        return categories;
    }

    public DoctorCategory getIDFromName(String name) {
        int id = (int) entityManager
                .createQuery(finrIdByName)
                .setParameter(1, name)
                .getSingleResult();

        DoctorCategory doctorCategory = entityManager.find(DoctorCategory.class, id);
        return doctorCategory;
    }

    public DoctorCategory getCategoryByName(String name) {
        DoctorCategory category = (DoctorCategory) entityManager
                .createQuery(findCategoryByName)
                .setParameter(1, name)
                .getSingleResult();

        return category;
    }
}

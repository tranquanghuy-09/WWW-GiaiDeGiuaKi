package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.entities.Experience;

public class ExperienceRepository {
    private EntityManager em;
    private EntityTransaction tran;

    public ExperienceRepository() {
        em = Persistence.createEntityManagerFactory("20092731_TranQuangHuy").createEntityManager();
        tran = em.getTransaction();
    }

    public boolean insertExperience(Experience experience){
        try {
            tran.begin();
            em.persist(experience);
            tran.commit();
            return true;
        }catch (Exception e){
            tran.rollback();
            e.printStackTrace();
        }
        return false;
    }
}

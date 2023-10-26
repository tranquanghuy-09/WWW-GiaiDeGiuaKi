package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.entities.Candidate;
import vn.edu.iuh.fit.enums.Roles;
import vn.edu.iuh.fit.services.CandidateService;

import java.util.ArrayList;
import java.util.List;

public class CandidateRepository {
    private EntityManager em;
    private EntityTransaction tran;

    public CandidateRepository() {
        em = Persistence.createEntityManagerFactory("20092731_TranQuangHuy").createEntityManager();
        tran = em.getTransaction();
    }

    public boolean insertCandidate(Candidate candidate){
        try {
            tran.begin();
            em.persist(candidate);
            tran.commit();
            return true;
        }catch(Exception e){
            tran.rollback();
            e.printStackTrace();
        }
        return false;
    }

    public List<Candidate> getCandidateList(){
        try{
            return em.createNamedQuery("Candidate.getListCandidate", Candidate.class).getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
    public Candidate getCandidateById(long id){
        try {
            return em.createNamedQuery("Candidate.getCandidateById", Candidate.class)
                    .setParameter("idFind", id).getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public List<Candidate> getCandidatesByRole(Roles role){
        try{
            return em.createNamedQuery("Candidate.getCandidatesByRole", Candidate.class)
                    .setParameter("role", role).getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
    public List<Candidate> getCandidatesUseGmail(){
        try{
            return em.createNamedQuery("Candidate.FilterCandidateUseGmail", Candidate.class).getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}

package vn.edu.iuh.fit.repositories;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.entities.LoaiXe;
import vn.edu.iuh.fit.entities.Xe;

import java.security.KeyStore;
import java.util.ArrayList;
import java.util.List;

public class LoaiXeRepository {
    private EntityManager em;
    private EntityTransaction tran;

    public LoaiXeRepository() {
        em = Persistence.createEntityManagerFactory("20092731_TranQuangHuy").createEntityManager();
        tran = em.getTransaction();
    }

    public boolean insert(LoaiXe loaiXe){
        try{
            tran.begin();
            em.persist(loaiXe);
            tran.commit();
            return true;
        }catch (Exception e){
            tran.rollback();
            e.printStackTrace();
        }
        return false;
    }
    public List<LoaiXe> getListLoaiXe(){
        try {
            return em.createNamedQuery("LoaiXe.getListLoaiXe", LoaiXe.class).getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
    public LoaiXe getLoaiXeByMaLoai(long maLoaiXe){
        try{
            return em.createNamedQuery("LoaiXe.getLoaiXeByMaLoai", LoaiXe.class)
                    .setParameter("loaixe", maLoaiXe).getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.entities.LoaiXe;
import vn.edu.iuh.fit.entities.Xe;

import java.util.ArrayList;
import java.util.List;

public class XeRepository {
    private EntityManager em;
    private EntityTransaction tran;

    public XeRepository() {
        em = Persistence.createEntityManagerFactory("20092731_TranQuangHuy").createEntityManager();
        tran = em.getTransaction();
    }

    public boolean insert(Xe xe){
        try{
            tran.begin();
            em.persist(xe);
            tran.commit();
            return true;
        }catch (Exception e){
            tran.rollback();
            e.printStackTrace();
        }
        return false;
    }
    public List<Xe> getListXe(){
        try {
            return em.createNamedQuery("Xe.GetListXe", Xe.class).getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
    public List<Xe> getListXeByLoaiXe(long loaiXe){
        try {
            return em.createNamedQuery("Xe.getListXeByLoaiXe", Xe.class).setParameter("loaiXe", loaiXe).getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}

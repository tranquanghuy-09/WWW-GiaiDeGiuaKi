package vn.edu.iuh.fit.db;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Connection {
    private static Connection instance;
    private EntityManagerFactory emf;
    public Connection(){
        emf = Persistence.createEntityManagerFactory("20092731_TranQuangHuy");
    }
    public static Connection getInstance(){
        if(instance == null)
            instance = new Connection();
        return instance;
    }
    public EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

    public static void main(String[] args) {
        EntityManager em = Connection.getInstance().getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try{
            tran.begin();

            tran.commit();
        }catch (Exception e){
            tran.rollback();
            e.printStackTrace();
        }
    }
}

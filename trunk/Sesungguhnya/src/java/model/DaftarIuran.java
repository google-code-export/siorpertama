/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Iuran;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.exceptions.NonexistentEntityException;


/**
 *
 * @author 1015
 */
public class DaftarIuran {
     private int jumlahiuran = -1;
    
    public DaftarIuran() {
        emf = Persistence.createEntityManagerFactory("SiORpertama");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * @return the jumlahPesan
     */
    public List<Iuran> getIuran() {
    
        List<Iuran> iuran = new ArrayList<Iuran>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT a FROM Iuran AS a");
            iuran = q.getResultList();

        } finally {
            em.close();
        }
        return iuran;
    
    }

    public List<Iuran> seluruhDaftarIuran () {
        List<Iuran> iuran = null;
        EntityManager em = null;
        try {
            em = getEntityManager();
            Query q = em.createQuery("SELECT object(o) FROM rumah as o ORDER BY o.id DESC");
            q.setMaxResults(10);
            iuran = q.getResultList();

        } catch (javax.persistence.EntityNotFoundException e) {
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return iuran;
    }
    
    public Iuran findIuran(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Iuran.class, id);
        } finally {
            em.close();
        }
    }
    
    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Iuran iuran;
            try {
                iuran = em.getReference(Iuran.class, id);
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("Iuran belum dipilih.", enfe);
            }
            em.remove(iuran);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
     public void tambahIuran(Iuran iuran) {

        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            iuran.getBulaniuran();

            iuran.setKodeiuran(null);
            em.persist(iuran);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }
}

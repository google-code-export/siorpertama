/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Warga;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;


import model.exceptions.NonexistentEntityException;
import javax.persistence.Persistence;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;
import model.exceptions.RollbackFailureException;

/**
 *
 * @author ntonk
 */
/**
 *
 * @author ntonk
 */
public class DaftarWarga implements Serializable {


    public DaftarWarga() {
      emf = Persistence.createEntityManagerFactory("SesungguhnyaPU");
    }
   
    private EntityManagerFactory emf = null;

    //private UserTransaction utx = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
  
    
     
    public List<Warga> getWarga() {
        List<Warga> warga = new ArrayList<Warga>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT a FROM warga AS a");
            warga = q.getResultList();

        } finally {
            em.close();
        }
        return warga;
    }
    
    public Warga findWarga(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Warga.class, id);
        } finally {
            em.close();
        }
    }

    public void tambahWarga(Warga warga) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(warga);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

   public void editWarga(Warga warga) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            warga = em.merge(warga);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
   
     public void hapusWarga(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Warga warga;
            try {
                warga = em.getReference(Warga.class, id);
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("Keluarga belum dipilih.", enfe);
            }
            em.remove(warga);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Warga> findWargaEntities() {
        return findWargaEntities(true, -1, -1);
    }

    public List<Warga> findWargaEntities(int maxResults, int firstResult) {
        return findWargaEntities(false, maxResults, firstResult);
    }

    private List<Warga> findWargaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Warga.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public int getWargaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Warga> rt = cq.from(Warga.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

     public boolean isKodeExist(String kode) {
        DaftarWarga daftarWarga = new DaftarWarga();
        List<Warga> listWarga = daftarWarga.getWarga();
        Iterator<Warga> iterator = listWarga.iterator();
        Warga tes = new Warga();

        while (iterator.hasNext()) {
            tes = iterator.next();
            if (kode.equalsIgnoreCase(tes.getKotaktp())) {
                return true;
            }
        } return false;
    }
    
}

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
    private UserTransaction utx = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public List<Warga> getIdWarga() {
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


   public void editWarga(Warga warga) throws RollbackFailureException, NonexistentEntityException{
    EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            warga = em.merge(warga);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = warga.getIdWarga();
                if (findWarga(id) == null) {
                    throw new NonexistentEntityException("Warga dengan user id" + " "+ id +" " + " tidak terdaftar .");
                }
            }
            try {
                throw ex;
            } catch (Exception ex1) {
                Logger.getLogger(DaftarAkun.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            if (em != null) {
                em.close();
            }
         }
    }

    public void destroy(Integer id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Warga warga;
            try {
                warga = em.getReference(Warga.class, id);
                int noktp = warga.getNoktp();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The warga with id " + id + " no longer exists.", enfe);
            }
            em.remove(warga);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
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

   
    
}

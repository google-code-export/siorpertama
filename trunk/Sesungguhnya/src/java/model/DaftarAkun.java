/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Akun;
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
public class DaftarAkun implements Serializable {

    public DaftarAkun() {
       emf = Persistence.createEntityManagerFactory("SesungguhnyaPU");
       
    }
    private EntityManagerFactory emf = null;
    private UserTransaction utx = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public List<Akun> getUsername() {
        List<Akun> akun = new ArrayList<Akun>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT a FROM warga AS a");
            akun = q.getResultList();

        } finally {
            em.close();
        }
        return akun;
    }
    
    public Akun findAkun(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Akun.class, id);
        } finally {
            em.close();
        }
    }
    public void tambahAkun(Akun akun) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(akun);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void editAkun(Akun akun) throws RollbackFailureException, NonexistentEntityException{
    EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            akun = em.merge(akun);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = akun.getIdAkun();
                if (findAkun(id) == null) {
                    throw new NonexistentEntityException("Warga dengan user id" + " "+ id +" " + " no longer exists.");
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

    public void destroy(String id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Akun akun;
            try {
                akun = em.getReference(Akun.class, id);
                akun.getIdAkun();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The akun with id " + id + " no longer exists.", enfe);
            }
            em.remove(akun);
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

    public List<Akun> findAkunEntities() {
        return findAkunEntities(true, -1, -1);
    }

    public List<Akun> findAkunEntities(int maxResults, int firstResult) {
        return findAkunEntities(false, maxResults, firstResult);
    }

    private List<Akun> findAkunEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Akun.class));
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

    public Akun findAkun(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Akun.class, id);
        } finally {
            em.close();
        }
    }

    public int getAkunCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Akun> rt = cq.from(Akun.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    
    
}

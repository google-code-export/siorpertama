/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Hunian;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;
import model.exceptions.NonexistentEntityException;
import model.exceptions.PreexistingEntityException;
import model.exceptions.RollbackFailureException;

/**
 *
 * @author ntonk
 */
public class DaftarHunian implements Serializable {

    public DaftarHunian() {
        emf = Persistence.createEntityManagerFactory("SesungguhnyaPU");
    }
    private EntityManagerFactory emf = null;
    private UserTransaction utx = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    public List<Hunian> getHunian() {
        List<Hunian> hunian = new ArrayList<Hunian>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT a FROM Hunian AS a");
            hunian = q.getResultList();

        } finally {
            em.close();
        }
        return hunian;
    }

    public Hunian findHunian(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Hunian.class, id);
        } finally {
            em.close();
        }
    }

    public void tambahHunian (Hunian hunian) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(hunian);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    public void editHunian(Hunian hunian) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            hunian = em.merge(hunian);
            em.getTransaction().commit();
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
            Hunian hunian;
            try {
                hunian = em.getReference(Hunian.class, id);
                hunian.getKodehunian();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The hunian with id " + id + " no longer exists.", enfe);
            }
            em.remove(hunian);
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

    public List<Hunian> findHunianEntities() {
        return findHunianEntities(true, -1, -1);
    }

    public List<Hunian> findHunianEntities(int maxResults, int firstResult) {
        return findHunianEntities(false, maxResults, firstResult);
    }

    private List<Hunian> findHunianEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Hunian.class));
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

    public Hunian findHunian(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Hunian.class, id);
        } finally {
            em.close();
        }
    }

    public int getHunianCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Hunian> rt = cq.from(Hunian.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public boolean isKodeExist(String kode) {
        DaftarHunian daftarHunian = new DaftarHunian();
        List<Hunian> listHunian = daftarHunian.getHunian();
        Iterator<Hunian> iterator = listHunian.iterator();
        Hunian tes = new Hunian();

        while (iterator.hasNext()) {
            tes = iterator.next();
            if (kode.equalsIgnoreCase(tes.getKodehunian())) {
                return true;
            }
        } return false;
    }

}

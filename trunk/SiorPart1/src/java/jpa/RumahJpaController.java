/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import entity.Rumah;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa.exceptions.NonexistentEntityException;

/**
 *
 * @author TYA
 */
public class RumahJpaController {
    
    public RumahJpaController() {
        emf = Persistence.createEntityManagerFactory("SiorPart1PU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Rumah rumah) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(rumah);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Rumah rumah) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            rumah = em.merge(rumah);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String koderumah = rumah.getKoderumah();
                if (findRumah(koderumah) == null) {
                    throw new NonexistentEntityException("Informasi Rumah dengan kode" + koderumah + "Tidak Tersedia");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String koderumah) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Rumah rumah;
            try {
                rumah = em.getReference(Rumah.class, koderumah);
                rumah.getKoderumah();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("Informasi Rumah dengan kode" + koderumah + "Tidak Tersedia", enfe);
            }
            em.remove(rumah);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Rumah> findPesanEntities() {
        return findPesanEntities(true, -1, -1);
    }

    public List<Rumah> findPesanEntities(int maxResults, int firstResult) {
        return findPesanEntities(false, maxResults, firstResult);
    }

    private List<Rumah> findPesanEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Rumah.class));
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

    public Rumah findRumah(String koderumah) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Rumah.class, koderumah);
        } finally {
            em.close();
        }
    }

    public int getRumahCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Rumah> rt = cq.from(Rumah.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

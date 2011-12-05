/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import entity.Akun;
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
 * @author Lia
 */
public class AkunJpaController {
    
    public AkunJpaController() {
        emf = Persistence.createEntityManagerFactory("SiorPart1PU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Akun akun) {
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

    public void edit(Akun akun) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            akun = em.merge(akun);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String username = akun.getUsername();
                if (findAkun(username) == null) {
                    throw new NonexistentEntityException("Informasi " + username + "Tidak Tersedia");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String username) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Akun akun;
            try {
                akun = em.getReference(Akun.class, username);
                akun.getUsername();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("Informasi " + username + "Tidak Tersedia", enfe);
            }
            em.remove(akun);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Akun> findAkunEntities() {
        return findAkunEntities(true, -1, -1);
    }

    public List<Akun> findWargaEntities(int maxResults, int firstResult) {
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

    public Akun findAkun(String username) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Akun.class, username);
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

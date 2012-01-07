/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import entity.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author ACER
 */
public class DaftarKeluarga implements Serializable {

    public DaftarKeluarga() {
       emf = Persistence.createEntityManagerFactory("persistence");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

     public boolean check(Long id) {
        boolean result = false;
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT count(o) FROM Keluarga AS o WHERE o.id=:id");
            q.setParameter("id", id);
 
            int jumlahKeluarga = ((Long) q.getSingleResult()).intValue();
            if (jumlahKeluarga > 0) {
                result = true;
            }
        } finally {
            em.close();
        }
        return result;
    }

    public Keluarga getKeluarga(Long id) {
        Keluarga keluarga = null;
        EntityManager em = getEntityManager();
        try {
            boolean hasilCheck = this.check(id);
            if (hasilCheck) {
                Query q = em.createQuery("SELECT object(o) FROM Keluarga AS o WHERE o.id=:id");
                q.setParameter("id", id);
 
                keluarga = (Keluarga) q.getSingleResult();
            }
        } finally {
            em.close();
        }
        return keluarga;
    }

    public List<Keluarga> getKeluargas(Long idPengguna) {
        List<Keluarga> keluargas = new ArrayList<Keluarga>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM Keluarga AS o WHERE o.idPengguna=:idPengguna");
            q.setParameter("idPengguna", idPengguna);
            keluargas = q.getResultList();

        } finally {
            em.close();
        }
        return keluargas;
    }
    
     public List<Keluarga> getKluarga() {//
        List<Keluarga> proposals = new ArrayList<Keluarga>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM Keluarga AS o");
            proposals = q.getResultList();

        } finally {
            em.close();
        }
        return proposals;
    }
    
    public List<Keluarga> getKel(Long idPengguna,String kodekeluarga) {
        List<Keluarga> keluargas = new ArrayList<Keluarga>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM Keluarga AS o WHERE o.idPengguna=:idPengguna and o.kodekeluarga LIKE :kodekeluarga ORDER BY o.kodekeluarga desc");
            q.setParameter("idPengguna", idPengguna);
            q.setParameter("kodekeluarga", kodekeluarga+'%');
            keluargas = q.getResultList();

        } finally {
            em.close();
        }
        return keluargas;
    }

    public void editKeluarga(Keluarga keluarga) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            em.merge(keluarga);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void addKeluarga(Keluarga keluarga) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(keluarga);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void deleteKeluarga(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Keluarga keluarga;
            try {
                keluarga = em.getReference(Keluarga.class, id);
                keluarga.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The transaksi with id " + id + " no longer exists.", enfe);
            }
            em.remove(keluarga);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }

    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
}

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
public class DaftarWarga implements Serializable {

    public DaftarWarga() {
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
            Query q = em.createQuery("SELECT count(o) FROM Warga AS o WHERE o.id=:id");
            q.setParameter("id", id);
 
            int jumlahWarga = ((Long) q.getSingleResult()).intValue();
            if (jumlahWarga > 0) {
                result = true;
            }
        } finally {
            em.close();
        }
        return result;
    }

    public Warga getWarga(Long id) {
        Warga warga = null;
        EntityManager em = getEntityManager();
        try {
            boolean hasilCheck = this.check(id);
            if (hasilCheck) {
                Query q = em.createQuery("SELECT object(o) FROM Warga AS o WHERE o.id=:id");
                q.setParameter("id", id);
 
                warga = (Warga) q.getSingleResult();
            }
        } finally {
            em.close();
        }
        return warga;
    }

    public List<Warga> getWargas(Long idPengguna) {
        List<Warga> wargas = new ArrayList<Warga>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM Warga AS o WHERE o.idPengguna=:idPengguna");
            q.setParameter("idPengguna", idPengguna);
            wargas = q.getResultList();

        } finally {
            em.close();
        }
        return wargas;
    }
    
     public List<Warga> getWrg(Long idPengguna,String noKtp) {
        List<Warga> wargas = new ArrayList<Warga>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM Warga AS o WHERE o.idPengguna=:idPengguna and o.noKtp LIKE :noKtp ORDER BY o.noKtp desc");
            q.setParameter("idPengguna", idPengguna);
            q.setParameter("kodekeluarga", noKtp+'%');
            wargas = q.getResultList();

        } finally {
            em.close();
        }
        return wargas;
    }
    
    
    public void editWarga(Warga warga) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            em.merge(warga);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void addWarga(Warga warga) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(warga);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void deleteWarga(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Warga warga;
            try {
                warga = em.getReference(Warga.class, id);
                warga.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The transaksi with id " + id + " no longer exists.", enfe);
            }
            em.remove(warga);
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

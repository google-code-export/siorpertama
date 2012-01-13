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
import javax.persistence.Id;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author ACER
 */
public class DaftarHunian implements Serializable {

    public DaftarHunian() {
       emf = Persistence.createEntityManagerFactory("persistence");
    }
    
    @Id
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

     public boolean check(Long id) {
        boolean result = false;
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT count(o) FROM Hunian AS o WHERE o.id=:id");
            q.setParameter("id", id);
 
            int jumlahHunian = ((Long) q.getSingleResult()).intValue();
            if (jumlahHunian > 0) {
                result = true;
            }
        } finally {
            em.close();
        }
        return result;
    }

    public Hunian getHunian(Long id) {
        Hunian hunian = null;
        EntityManager em = getEntityManager();
        try {
            boolean hasilCheck = this.check(id);
            if (hasilCheck) {
                Query q = em.createQuery("SELECT object(o) FROM Keluarga AS o WHERE o.id=:id");
                q.setParameter("id", id);
 
                hunian = (Hunian) q.getSingleResult();
            }
        } finally {
            em.close();
        }
        return hunian;
    }

    public List<Hunian> getHunians(Long Id) {
        List<Hunian> hunians = new ArrayList<Hunian>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM Hunian AS o WHERE o.Id=:Id");
            q.setParameter("Id", Id);
            hunians = q.getResultList();

        } finally {
            em.close();
        }
        return hunians;
    }
    
     public List<Hunian> getHnian() {//
        List<Hunian> proposals = new ArrayList<Hunian>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM Hunian AS o");
            proposals = q.getResultList();

        } finally {
            em.close();
        }
        return proposals;
    }
    
    public List<Hunian> getHun(Long Id,String Koderumah) {
        List<Hunian> hunians = new ArrayList<Hunian>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM Hunian AS o WHERE o.id=:id and o.koderumah LIKE :koderumah ORDER BY o.koderumah desc");
            q.setParameter("id", Id);
            q.setParameter("koderumah", Koderumah+'%');
            hunians = q.getResultList();

        } finally {
            em.close();
        }
        return hunians;
    }

    public void editHunian(Hunian hunian) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            em.merge(hunian);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void addHunian(Hunian hunian) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(hunian);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void deleteHunian(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Hunian hunian;
            try {
                hunian = em.getReference(Hunian.class, id);
                hunian.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The transaksi with id " + id + " no longer exists.", enfe);
            }
            em.remove(hunian);
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
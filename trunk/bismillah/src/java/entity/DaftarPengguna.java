/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import entity.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Query;
/**
 *
 * @author ACER
 */
@Entity
public class DaftarPengguna implements Serializable {

    public DaftarPengguna() {
        emf = Persistence.createEntityManagerFactory("persistence");
    }
    
    @Id
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public boolean check(String email, String password) {
        boolean result = false;
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT count(o) FROM Pengguna AS o WHERE o.email=:email AND o.password=:password");
            q.setParameter("email", email);
            q.setParameter("password", password);
            int jumlahPengguna = ((Long) q.getSingleResult()).intValue();
            if (jumlahPengguna > 0) {
                result = true;
            }
        } finally {
            em.close();
        }
        return result;
    }

    public boolean checkId(Long id) {
        boolean result = false;
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT count(o) FROM Pengguna AS o WHERE o.id=:id");
            q.setParameter("id", id);
            int jumlahPengguna = ((Long) q.getSingleResult()).intValue();
            if (jumlahPengguna > 0) {
                result = true;
            }
        } finally {
            em.close();
        }
        return result;
    }

    public boolean checkEmail(String email) {
        boolean result = false;
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT count(o) FROM Pengguna AS o WHERE o.email=:email");
            q.setParameter("email", email);
            int jumlahPengguna = ((Long) q.getSingleResult()).intValue();
            if (jumlahPengguna > 0) {
                result = true;
            }
        } finally {
            em.close();
        }
        return result;
    }

    public Pengguna getPengguna(String email, String password) {
        Pengguna pengguna = null;
        EntityManager em = getEntityManager();
        try {
            boolean hasilCheck = this.check(email, password);
            if (hasilCheck) {
                Query q = em.createQuery("SELECT object(o) FROM Pengguna AS o WHERE o.email=:email AND o.password=:password");
                q.setParameter("email", email);
                q.setParameter("password", password);
                pengguna = (Pengguna) q.getSingleResult();
            }
        } finally {
            em.close();
        }
        return pengguna;
    }

    public Pengguna findPengguna(Long id) {
        Pengguna pengguna = null;
        EntityManager em = getEntityManager();
        try {
            boolean hasilCheck = this.checkId(id);
            if (hasilCheck) {
                Query q = em.createQuery("SELECT object(o) FROM Pengguna AS o WHERE o.id=:id");
                q.setParameter("id", id);
                pengguna = (Pengguna) q.getSingleResult();
            }
        } finally {
            em.close();
        }
        return pengguna;
    }

    public List<Pengguna> getPenggunas(Long id) {//edit tanggal 21 nop 2011
        List<Pengguna> penggunas = new ArrayList<Pengguna>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM Pengguna AS o where o.id=:id");
            q.setParameter("id", id);
            penggunas = q.getResultList();

        } finally {
            em.close();
        }
        return penggunas;
    }

    public List<Pengguna> getPenggunas() {// untuk mengetes add Masjid
        List<Pengguna> penggunas = new ArrayList<Pengguna>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM Pengguna AS o");
            penggunas = q.getResultList();

        } finally {
            em.close();
        }
        return penggunas;
    }
    
    public void editPengguna(Pengguna pengguna) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            em.merge(pengguna);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void addPengguna(Pengguna pengguna) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(pengguna);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void deletePengguna(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pengguna pengguna;
            try {
                pengguna = em.getReference(Pengguna.class, id);
                pengguna.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The user with id " + id + " no longer exists.", enfe);
            }
            em.remove(pengguna);
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

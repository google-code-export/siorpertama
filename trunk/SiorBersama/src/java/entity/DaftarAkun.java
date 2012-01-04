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
import javax.persistence.EntityNotFoundException;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Lia
 */
public class DaftarAkun implements Serializable {

    public DaftarAkun() {
        emf = Persistence.createEntityManagerFactory("SiorBersamaPU");
    }
    @Id
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public boolean check(String username, String password) {
        boolean result = false;
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT count(o) FROM Akun AS o WHERE o.username=:usr AND o.password=:pswd");
            q.setParameter("usr", username);
            q.setParameter("pswd", password);
            int jumlahAkun = ((Long) q.getSingleResult()).intValue();
            if (jumlahAkun > 0) {
                result = true;
            }
        } finally {
            em.close();
        }
        return result;
    }

    public boolean checkAkun(String username) {
        boolean result = false;
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT count(o) FROM Akun AS o WHERE o.username=:usr");
            q.setParameter("usr", username);
            int jumlahAkun = ((Long) q.getSingleResult()).intValue();
            if (jumlahAkun > 0) {
                result = true;
            }
        } finally {
            em.close();
        }
        return result;
    }

    public Akun getAkun(String username, String password) {
        Akun akun = null;
        EntityManager em = getEntityManager();
        try {
            boolean hasilCheck = this.check(username, password);
            if (hasilCheck) {
                Query q = em.createQuery("SELECT object(o) FROM Akun AS o WHERE o.username=:usr AND o.password=:pswd");
                q.setParameter("usr", username);
                q.setParameter("pswd", password);
                akun = (Akun) q.getSingleResult();
            }
        } finally {
            em.close();
        }
        return akun;
    }
    
    public Akun getAkunFromName(String username) {
        Akun akun = null;
        EntityManager em = getEntityManager();
        try {
            boolean hasilCheck = this.checkAkun(username);
            if (hasilCheck) {
                Query q = em.createQuery("SELECT object(o) FROM Akun AS o WHERE o.username=:usr");
                q.setParameter("usr", username);
                akun = (Akun) q.getSingleResult();
            }
        } finally {
            em.close();
        }
        return akun;
    }
    
    public Akun getAkunFromId(Long id) {
        Akun akun = null;
        EntityManager em = getEntityManager();
        try {

                Query q = em.createQuery("SELECT object(o) FROM Akun AS o WHERE o.id=:id");
                q.setParameter("id", id);
                akun = (Akun) q.getSingleResult();

        } finally {
            em.close();
        }
        return akun;
    }
    
    public void editAkun(Akun akun) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try { //jik tdk ada error
            em.merge(akun);
            em.getTransaction().commit();
        } catch (Exception e){//jk eerror
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
    }

    public void addAkun(Akun akun) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(akun);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public List<Akun> getAkun() {
        List<Akun> users = new ArrayList<Akun>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM Akun AS o");
            users = q.getResultList();

        } finally {
            em.close();
        }
        return users;
    }
    
    public List<Akun> getUsername(String username) {
        List<Akun> akun = new ArrayList<Akun>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM Akun AS o WHERE o.username=:usr");
            q.setParameter("usr", username);
            akun = q.getResultList();

        } finally {
            em.close();
        }
        return akun;
    }
    
    public void deleteAkun(Long id) throws NonexistentEntityException {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            Akun akun;
            try {
               akun = em.find(Akun.class, id);
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The akun with id " + id + " no longer exists.", enfe);
            }
            em.remove(akun);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

}

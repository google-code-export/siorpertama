

package model;

import entity.Akun;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import model.exceptions.NonexistentEntityException;


@Entity
public class DaftarAkun implements Serializable {

    public DaftarAkun() {
        emf = Persistence.createEntityManagerFactory("SesungguhnyaPU");
    }
    
    @Id
    private EntityManagerFactory emf = null;
   // private UserTransaction utx = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public boolean check(String email, String password) {
        boolean result = false;
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT count(o) FROM Akun AS o WHERE o.email=:email AND o.password=:password");
            q.setParameter("email", email);
            q.setParameter("password", password);
            int jumlahAkun = ((Long) q.getSingleResult()).intValue();
            if (jumlahAkun > 0) {
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
            Query q = em.createQuery("SELECT count(o) FROM Akun AS o WHERE o.id=:id");
            q.setParameter("id", id);
            int jumlahAkun = ((Long) q.getSingleResult()).intValue();
            if (jumlahAkun > 0) {
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
            Query q = em.createQuery("SELECT count(o) FROM Akun AS o WHERE o.email=:email");
            q.setParameter("email", email);
            int jumlahAkun = ((Long) q.getSingleResult()).intValue();
            if (jumlahAkun > 0) {
                result = true;
            }
        } finally {
            em.close();
        }
        return result;
    }

    public boolean checkUsername(String username) {
        boolean result = false;
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT count(o) FROM Akun AS o WHERE o.username=:username");
            q.setParameter("username", username);
            int jumlahAkun = ((Long) q.getSingleResult()).intValue();
            if (jumlahAkun > 0) {
                result = true;
            }
        } finally {
            em.close();
        }
        return result;
    }
    
    public Akun getAkun(String email, String password) {
        Akun akun = null;
        EntityManager em = getEntityManager();
        try {
            boolean hasilCheck = this.check(email, password);
            if (hasilCheck) {
                Query q = em.createQuery("SELECT object(o) FROM Akun AS o WHERE o.email=:email AND o.password=:password");
                q.setParameter("email", email);
                q.setParameter("password", password);
                akun = (Akun) q.getSingleResult();
            }
        } finally {
            em.close();
        }
        return akun;
    }

    public Akun findAkun(Long id) {
        Akun akun = null;
        EntityManager em = getEntityManager();
        try {
            boolean hasilCheck = this.checkId(id);
            if (hasilCheck) {
                Query q = em.createQuery("SELECT object(o) FROM Akun AS o WHERE o.id=:id");
                q.setParameter("id", id);
                akun = (Akun) q.getSingleResult();
            }
        } finally {
            em.close();
        }
        return akun;
    }

    public List<Akun> getAkuns(Long id) {
        List<Akun> akuns = new ArrayList<Akun>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM Akun AS o where o.id=:id");
            q.setParameter("id", id);
            akuns = q.getResultList();

        } finally {
            em.close();
        }
        return akuns;
    }

    public List<Akun> getAkuns() {
        List<Akun> akuns = new ArrayList<Akun>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM Akun AS o");
            akuns = q.getResultList();

        } finally {
            em.close();
        }
        return akuns;
    }

    public void editAkun(Akun akun) {
        EntityManager em = null;
        em.getTransaction().begin();
        try {
            em.merge(akun);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void addAkun(Akun akun) {
        EntityManager em = null;
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

    public void deleteAkun(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Akun akun;
            try {
                akun = em.getReference(Akun.class, id);
                akun.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The user with id " + id + " no longer exists.", enfe);
            }
            em.remove(akun);
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


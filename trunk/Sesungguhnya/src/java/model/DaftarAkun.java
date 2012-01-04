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
        emf = Persistence.createEntityManagerFactory("SesungguhnyaPU"); //SesungguhnyaPU >> dilihat i persistence.xml
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<Akun> getAkun() {
        List<Akun> akun = new ArrayList<Akun>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT a FROM Keluargaindo AS a");
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
    
    public void tambahKeluarga(Akun akun) {
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

    public void edit(Akun akun) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            akun = em.merge(akun);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Akun akun;
            try {
                akun = em.getReference(Akun.class, id);
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("Keluarga belum dipilih.", enfe);
            }
            em.remove(akun);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public boolean isKodeExist(String kode) {
        DaftarAkun daftarAkun = new DaftarAkun();
        List<Akun> listAkun = daftarAkun.getAkun();
        Iterator<Akun> iterator = listAkun.iterator();
        Akun tes = new Akun();

        while (iterator.hasNext()) {
            tes = iterator.next();
            if (kode.equalsIgnoreCase(tes.getIdAkun())) {
                return true;
            }
        } return false;
    }
    
    public boolean isNamaExist(String nama) {
        DaftarAkun daftarAkun = new DaftarAkun();
        List<Akun> listAkun = daftarAkun.getAkun();
        Iterator<Akun> iterator = listAkun.iterator();
        Akun tes = new Akun();
        
        while (iterator.hasNext()) {
            tes = iterator.next();
            if (nama.equalsIgnoreCase(tes.getUsername())) {
                return true;
            }
        } return false;
    }

    

    
    
}

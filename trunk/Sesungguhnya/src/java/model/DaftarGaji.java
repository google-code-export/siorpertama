/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Gaji;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import model.exceptions.NonexistentEntityException;
import javax.persistence.Persistence;

/**
 *
 * @author Lia
 */
public class DaftarGaji implements Serializable {
   
    public DaftarGaji() {
       emf = Persistence.createEntityManagerFactory("SesungguhnyaPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

  public List<Gaji> getGaji() {
        List<Gaji> gaji = new ArrayList<Gaji>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT a FROM gaji AS a");
            gaji = q.getResultList();

        } finally {
            em.close();
        }
        return gaji;
    }

    public Gaji findGaji(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Gaji.class, id);
        } finally {
            em.close();
        }
    }
    
    public void tambahGaji(Gaji gaji) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(gaji);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Gaji gaji) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            gaji = em.merge(gaji);
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
            Gaji gaji;
            try {
                gaji = em.getReference(Gaji.class, id);
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("Pembayaran Gaji belum dipilih.", enfe);
            }
            em.remove(gaji);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    

    public boolean isKodeExist(String kode) {
        DaftarGaji daftarGaji = new DaftarGaji();
        List<Gaji> listGaji = daftarGaji.getGaji();
        Iterator<Gaji> iterator = listGaji.iterator();
        Gaji tes = new Gaji();

        while (iterator.hasNext()) {
            tes = iterator.next();
            if (kode.equalsIgnoreCase(tes.getKodebayar())) {
                return true;
            }
        } return false;
    }
    
}

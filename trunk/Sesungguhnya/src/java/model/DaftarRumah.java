/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Rumah;
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
public class DaftarRumah implements Serializable {

    public DaftarRumah() {
       emf = Persistence.createEntityManagerFactory("SesungguhnyaPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

  public List<Rumah> getRumah() {
        List<Rumah> rumah = new ArrayList<Rumah>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT a FROM rumah AS a");
            rumah = q.getResultList();

        } finally {
            em.close();
        }
        return rumah;
    }

    public Rumah findRumah(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Rumah.class, id);
        } finally {
            em.close();
        }
    }
    
    public void tambahRumah(Rumah rumah) {
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

    public void edit(Rumah rumah) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            rumah = em.merge(rumah);
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
            Rumah rumah;
            try {
                rumah = em.getReference(Rumah.class, id);
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("Rumah belum dipilih.", enfe);
            }
            em.remove(rumah);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    

    public boolean isKodeExist(String kode) {
        DaftarRumah daftarRumah = new DaftarRumah();
        List<Rumah> listRumah = daftarRumah.getRumah();
        Iterator<Rumah> iterator = listRumah.iterator();
        Rumah tes = new Rumah();

        while (iterator.hasNext()) {
            tes = iterator.next();
            if (kode.equalsIgnoreCase(tes.getKodeRumah())) {
                return true;
            }
        } return false;
    }
    
}

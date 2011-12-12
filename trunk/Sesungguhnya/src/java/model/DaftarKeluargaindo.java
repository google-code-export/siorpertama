/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Keluargaindo;
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
public class DaftarKeluargaindo implements Serializable {

    public DaftarKeluargaindo() {
        emf = Persistence.createEntityManagerFactory("SesungguhnyaPU"); //SesungguhnyaPU >> dilihat i persistence.xml
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<Keluargaindo> getKeluarga() {
        List<Keluargaindo> keluargaindo = new ArrayList<Keluargaindo>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT a FROM Keluargaindo AS a");
            keluargaindo = q.getResultList();

        } finally {
            em.close();
        }
        return keluargaindo;
    }

    public Keluargaindo findBankPos(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Keluargaindo.class, id);
        } finally {
            em.close();
        }
    }
    
    public void tambahKeluarga(Keluargaindo keluargaindo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(keluargaindo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Keluargaindo keluargaindo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            keluargaindo = em.merge(keluargaindo);
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
            Keluargaindo keluargaindo;
            try {
                keluargaindo = em.getReference(Keluargaindo.class, id);
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("Keluarga belum dipilih.", enfe);
            }
            em.remove(keluargaindo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public boolean isKodeExist(String kode) {
        DaftarKeluargaindo daftarKeluargaindo = new DaftarKeluargaindo();
        List<Keluargaindo> listKeluarga = daftarKeluargaindo.getKeluarga();
        Iterator<Keluargaindo> iterator = listKeluarga.iterator();
        Keluargaindo tes = new Keluargaindo();

        while (iterator.hasNext()) {
            tes = iterator.next();
            if (kode.equalsIgnoreCase(tes.getKodekel())) {
                return true;
            }
        } return false;
    }
    
    public boolean isNamaExist(String nama) {
        DaftarKeluargaindo daftarKeluargaindo = new DaftarKeluargaindo();
        List<Keluargaindo> listKeluarga = daftarKeluargaindo.getKeluarga();
        Iterator<Keluargaindo> iterator = listKeluarga.iterator();
        Keluargaindo tes = new Keluargaindo();
        
        while (iterator.hasNext()) {
            tes = iterator.next();
            if (nama.equalsIgnoreCase(tes.getKeplakel())) {
                return true;
            }
        } return false;
    }

    
    
}

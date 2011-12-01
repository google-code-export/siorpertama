/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author 1015
 */
public class DaftarKeluarga {
    private int jumlahrumah = -1;
    
    public DaftarKeluarga() {
        emf = Persistence.createEntityManagerFactory("SiORpertama");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * @return the jumlahPesan
     */
    public int getJumlahKeluarga() {

        if (jumlahrumah == -1) {
            EntityManager em = null;
            try {
                em = getEntityManager();
                Query q = em.createQuery("SELECT count(o) FROM rumah as o");
                Number jumlah = (Number) q.getSingleResult();
                jumlahrumah = jumlah.intValue();

            } catch (javax.persistence.EntityNotFoundException e) {
            } finally {
                if (em != null) {
                    em.close();
                }
            }
        }

        return jumlahrumah;
    }

    public List<Rumah> seluruhDaftarKeluarga () {
        List<Rumah> rumah = null;
        EntityManager em = null;
        try {
            em = getEntityManager();
            Query q = em.createQuery("SELECT object(o) FROM rumah as o ORDER BY o.id DESC");
            q.setMaxResults(10);
            rumah = q.getResultList();

        } catch (javax.persistence.EntityNotFoundException e) {
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return rumah;
    }
    
     public void tambahKeluarga(Keluarga keluarga) {

        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            keluarga.setAnggotakeluarga(jumlahrumah);
            keluarga.setKepalakeluarga(null);
            keluarga.setKodekeluarga(null);
            em.persist(keluarga);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }
}

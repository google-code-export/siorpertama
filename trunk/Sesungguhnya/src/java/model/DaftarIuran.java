/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Iuran;
import entity.Rumah;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


/**
 *
 * @author 1015
 */
public class DaftarIuran {
     private int jumlahiuran = -1;
    
    public DaftarIuran() {
        emf = Persistence.createEntityManagerFactory("SiORpertama");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * @return the jumlahPesan
     */
    public int getIuran() {

        if (jumlahiuran == -1) {
            EntityManager em = null;
            try {
                em = getEntityManager();
                Query q = em.createQuery("SELECT count(o) FROM rumah as o");
                Number jumlah = (Number) q.getSingleResult();
                jumlahiuran = jumlah.intValue();
              
            } catch (javax.persistence.EntityNotFoundException e) {
            } finally {
                if (em != null) {
                    em.close();
                }
            }
        }

        return jumlahiuran;
    }

    public List<Rumah> seluruhDaftarIuran () {
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
    
     public void tambahIuran(Iuran iuran) {

        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            iuran.getBulaniuran();

            iuran.setKodeiuran(null);
            em.persist(iuran);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }
}

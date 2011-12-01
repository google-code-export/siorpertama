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
 * @author Lia
 */
public class DaftarHunian {
 
    private int jumlahhunian = -1;
    
    public DaftarHunian() {
        emf = Persistence.createEntityManagerFactory("SiorPart1PU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * @return the jumlahhunian
     */
    
    public int getJumlahHunian() {

        if (jumlahhunian == -1) {
            EntityManager em = null;
            try {
                em = getEntityManager();
                Query q = em.createQuery("SELECT count(o) FROM hunian as o");
                Number jumlah = (Number) q.getSingleResult();
                jumlahhunian = jumlah.intValue();

            } catch (javax.persistence.EntityNotFoundException e) {
            } finally {
                if (em != null) {
                    em.close();
                }
            }
        }

        return jumlahhunian;
    }

    public List<Hunian> seluruhDaftarHunian () {
        List<Hunian> warga = null;
        EntityManager em = null;
        try {
            em = getEntityManager();
            Query q = em.createQuery("SELECT object(o) FROM hunian as o ORDER BY o.kodehunian DESC");
            q.setMaxResults(10);
            warga = q.getResultList();

        } catch (javax.persistence.EntityNotFoundException e) {
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return warga;
    }
    
     public void tambahWarga(Hunian hunian) {

        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            hunian.setKodehunian(null);
            hunian.setKoderumah(null);
            hunian.setNoktp(null);
            hunian.setNamalengkap(null);
            hunian.setTanggalmasukhari(jumlahhunian);
            hunian.setTanggalmasukbulan(null);
            hunian.setTanggalmasuktahun(jumlahhunian);
            hunian.setTanggalkeluar(null);
            em.persist(hunian);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }
    
}

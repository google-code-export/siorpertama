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
 * 
 */
public class DaftarAkun {
    
    private int jumlahakun = -1;
    
    public DaftarAkun() {
        emf = Persistence.createEntityManagerFactory("SiorPart1PU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * @return the jumlahakun
     */
    
    public int getJumlahAkun() {

        if (jumlahakun == -1) {
            EntityManager em = null;
            try {
                em = getEntityManager();
                Query q = em.createQuery("SELECT count(o) FROM akun as o");
                Number jumlah = (Number) q.getSingleResult();
                jumlahakun = jumlah.intValue();

            } catch (javax.persistence.EntityNotFoundException e) {
            } finally {
                if (em != null) {
                    em.close();
                }
            }
        }

        return jumlahakun;
    }

    public List<Akun> seluruhDaftarAkun () {
        List<Akun> akun = null;
        EntityManager em = null;
        try {
            em = getEntityManager();
            Query q = em.createQuery("SELECT object(o) FROM akun as o ORDER BY o.username DESC");
            q.setMaxResults(10);
            akun = q.getResultList();

        } catch (javax.persistence.EntityNotFoundException e) {
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return akun;
    }
    
    public void tambahAkun(Akun akun) {

        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            akun.setUsername(null);
            akun.setEmail(null);
            akun.setPassword(null);
            akun.setNamaakun(null);
            akun.setJumlahrumah(Integer.valueOf(null));
            akun.setRtakun(Integer.valueOf(null));
            akun.setRwakun(Integer.valueOf(null));
            akun.setKecamatanakun(null);
            akun.setKelurahanakun(null);
            akun.setKotaakun(null);
            em.persist(akun);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }
}

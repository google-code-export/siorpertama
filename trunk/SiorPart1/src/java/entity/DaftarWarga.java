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
public class DaftarWarga {

    private int jumlahwarga = -1;
    
    public DaftarWarga() {
        emf = Persistence.createEntityManagerFactory("SiorPart1PU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * @return the jumlahPesan
     */
    public int getJumlahWarga() {

        if (jumlahwarga == -1) {
            EntityManager em = null;
            try {
                em = getEntityManager();
                Query q = em.createQuery("SELECT count(o) FROM warga as o");
                Number jumlah = (Number) q.getSingleResult();
                jumlahwarga = jumlah.intValue();

            } catch (javax.persistence.EntityNotFoundException e) {
            } finally {
                if (em != null) {
                    em.close();
                }
            }
        }

        return jumlahwarga;
    }

    public List<Warga> seluruhDaftarWarga () {
        List<Warga> warga = null;
        EntityManager em = null;
        try {
            em = getEntityManager();
            Query q = em.createQuery("SELECT object(o) FROM rumah as o ORDER BY o.id DESC");
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
    
     public void tambahWarga(Warga warga) {

        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            warga.setNoktp(null);
            warga.setKodekeluarga(null);
            warga.setNamalengkap(null);
            warga.setTempatlahir(null);
            warga.setTanggallahir(null);
            warga.setKewarganegaraan(null);
            warga.setAlamatktp(null);
            warga.setRtktp(0);
            warga.setRwktp(0);
            warga.setKelurahanktp(null);
            warga.setKecamatanktp(null);
            warga.setKotaktp(null);
            em.persist(warga);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }
    
}

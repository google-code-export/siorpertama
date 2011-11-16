/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

/**
 *
 * @author Lia
 */
import entity.Warga;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class demowarga {
    
    public static void main(String args[]){
	Warga wg = new Warga();  //nama entitas
	wg.setIdKTP(10111925);
	wg.setNamaLengkap("Mirna Rizki");
	wg.setTempatLahir("Surabaya");
        wg.setTanggalLahir("01 Januari 1988");
        wg.setAlamatKTP("Dumen II / 12");

	
        demowarga demo = new demowarga(); //nama class
	demo.persist(wg);
    }

    public void persist(Object object) {
	EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("simple-jpaPU");
	EntityManager em = emf.createEntityManager();
	em.getTransaction().begin();
	try {
            em.persist(object);
            em.getTransaction().commit();
	} catch (Exception e) {
            em.getTransaction().rollback();
	} finally {
            em.close();
        }
    }

   }

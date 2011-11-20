/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

/**
 *
 * @author Lia
 */
import entity.Keluarga;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class demokeluarga {
    
    public static void main(String args[]){
	Keluarga k = new Keluarga();  //nama entitas
	k.setKodekeluarga("wm101");
	k.setAnggotakeluarga(4);
	k.setKepalakeluarga("Budi Rahmawan");
    
	
        demokeluarga demo = new demokeluarga(); //nama class
	demo.persist(k);
    }

        
    public void persist(Keluarga k) {
	EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("simple-jpaPU");
	EntityManager em = emf.createEntityManager();
	em.getTransaction().begin();
	try {
            em.persist(k);
            em.getTransaction().commit();
	} catch (Exception e) {
            em.getTransaction().rollback();
	} finally {
            em.close();
        }
    }

   }

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package comparator;

import entity.Keluargaindo;
import java.util.Comparator;

/**
 *
 * @author Lia
 */
public class KeluargaindoComparator implements Comparator<Keluargaindo> {

    @Override
    public int compare(Keluargaindo o1, Keluargaindo o2) {
        int kode = o1.getKodekel().compareTo(o2.getKodekel());
        return kode;
    }
    
}

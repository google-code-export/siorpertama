/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package comparator;

import entity.Rumah;
import java.util.Comparator;

/**
 *
 * @author Putri A.
 */
public class RumahComparator implements Comparator<Rumah> {

    @Override
    public int compare(Rumah o1, Rumah o2) {
        int kode = o1.getKoderum().compareTo(o2.getKoderum());
        return kode;
    }
    
}

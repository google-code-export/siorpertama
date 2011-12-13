/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package comparator;

import entity.Gaji;
import java.util.Comparator;

/**
 *
 * @author Putri A
 */
public class GajiComparator implements Comparator<Gaji> {

    @Override
    public int compare(Gaji o1, Gaji o2) {
        int kode = o1.getKodebayar().compareTo(o2.getKodebayar());
        return kode;
    }
    
}

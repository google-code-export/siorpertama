/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package comparator;

import entity.Iuran;
import java.util.Comparator;

/**
 *
 * @author 1015
 */
public class IuranComparator implements Comparator<Iuran> {
    @Override
     public int compare(Iuran o1, Iuran o2) {
        int kode = o1.getKodeiuran().compareTo(o2.getKodeiuran());
        return kode;
    }
    
}

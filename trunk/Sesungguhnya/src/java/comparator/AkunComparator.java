/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package comparator;

import entity.Akun;
import java.util.Comparator;

/**
 *
 * @author ntonk
 */
public class AkunComparator implements Comparator<Akun> {

    @Override
    public int compare(Akun o1, Akun o2) {
        int kode = o1.getUsername().compareTo(o2.getUsername());
        return kode;
    
    //<editor-fold defaultstate="collapsed" desc="comment">
    }
    }


    //</editor-fold>

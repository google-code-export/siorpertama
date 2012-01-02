/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package comparator;

import entity.Warga;
import java.util.Comparator;

/**
 *
 * @author ntonk
 */
public class WargaComparator implements Comparator<Warga> {

    @Override
    public int compare(Warga o1, Warga o2) {
        int id = o1.getNamalengkap().compareTo(o2.getNamalengkap());
        return id;
    
    //<editor-fold defaultstate="collapsed" desc="comment">
    }
    }


    //</editor-fold>
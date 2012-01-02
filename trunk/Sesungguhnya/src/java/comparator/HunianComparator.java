/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package comparator;

import entity.Hunian;
import java.util.Comparator;

/**
 *
 * @author ntonk
 */
public class HunianComparator implements Comparator<Hunian> {

    @Override
    public int compare(Hunian o1, Hunian o2) {
        int kode = o1.getIdHunian().compareTo(o2.getIdHunian());
        return kode;
     //<editor-fold defaultstate="collapsed" desc="comment">
    }
    }


    //</editor-fold>
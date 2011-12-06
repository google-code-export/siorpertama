/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import entity.DaftarHunian;
import entity.Hunian;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TYA
 */
public class HalamanDaftarHunian extends Boundary {
    
    public HalamanDaftarHunian() {
        super();
        setTemplate("/WEB-INF/jsp/gui_;ihathunian.jsp");
    }
    
    @Override
    protected void process() {
        setMessage("");
        DaftarHunian dHunian = new DaftarHunian();
        if(validate_jumlah_hunian()){
            List<Hunian> seluruhDaftarHunian = dHunian.seluruhDaftarHunian();
            getRequest().setAttribute("daftar_pesan", seluruhDaftarHunian.iterator());
        }else{
            try {
                getResponse().sendRedirect("daftar_pesan_kosong");
            } catch (IOException ex) {
                Logger.getLogger(HalamanDaftarHunian.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private boolean validate_jumlah_hunian(){
        DaftarHunian dHunian = new DaftarHunian();
        int jumlahhunian = dHunian.getJumlahHunian();
        
        if( jumlahhunian == 0){
            return false;
        }

        return true;
    }

    
}

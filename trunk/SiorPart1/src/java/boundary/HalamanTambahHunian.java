/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import entity.DaftarHunian;
import entity.Hunian;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * 
 */
public class HalamanTambahHunian extends Boundary {

    @Override
    protected void process() {
         setMessage("");

         if (getRequest().getParameter("act") != null && getRequest().getParameter("act").equals("add")) {
            try {
                if (validate_kodehunian()) {
                    if (validate_koderumah()) {
                        if (validate_noktp()) {                            
                                            DaftarHunian dhunian = new DaftarHunian();
                                            Hunian hunian = new Hunian();
                                            String kodeHunianHtml = getRequest().getParameter("kodehunian");
                                            String kodeRumahHtl = getRequest().getParameter("koderumah");
                                            String noKtpHtml = getRequest().getParameter("noktp");
                                            String namaLengkaprHtml = getRequest().getParameter("namalengkap");
                                            String tanggalMasukHariHtml = getRequest().getParameter("tanggalmasukhari");
                                            String tanggalMasukBulanHtml = getRequest().getParameter("tanggalmasukbulan");
                                            String tanggalMasukTahunHtml = getRequest().getParameter("tanggalmasuktahun");
                                            String tanggalKeluarHtml = getRequest().getParameter("tanggallahir");
                                            hunian.setKodehunian(kodeHunianHtml);
                                            hunian.setKoderumah(kodeRumahHtl);
                                            hunian.setNoktp(noKtpHtml);
                                            hunian.setNamalengkap(namaLengkaprHtml);
                                            hunian.setTanggalmasukhari(Integer.valueOf(tanggalMasukHariHtml));
                                            hunian.setTanggalmasukbulan(tanggalMasukBulanHtml);
                                            hunian.setTanggalmasuktahun(Integer.valueOf(tanggalMasukTahunHtml));
                                            hunian.setTanggalkeluar(null);
                                           dhunian.tambahHunian(hunian);
                        }
                    }
                }
                getResponse().sendRedirect("daftar_warga");
            } catch (IOException ex) {
                Logger.getLogger(HalamanTambahHunian.class.getName()).log(Level.SEVERE, null, ex); //belum dibuat tambahrumahnya
            }
        }
        
    }
 
    public boolean validate_kodehunian() {
        
        String kodehunian = getRequest().getParameter("kodehunian");
        if(kodehunian == null){
            return false;
        }
        if(kodehunian.trim().equals("")){
            return false;
        }

        return true;
    }
    
    public boolean validate_koderumah() {
        
        String validate_koderumah = getRequest().getParameter("validate_koderumah");
        if(validate_koderumah == null){
            return false;
        }
        if(validate_koderumah.trim().equals("")){
            return false;
        }

        return true;
    }
    
    public boolean validate_noktp() {
        
        String validate_koderumah = getRequest().getParameter("validate_koderumah");
        if(validate_koderumah == null){
            return false;
        }
        if(validate_koderumah.trim().equals("")){
            return false;
        }

        return true;
    }
    

    
}

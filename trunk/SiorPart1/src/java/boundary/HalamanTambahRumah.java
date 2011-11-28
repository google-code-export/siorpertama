/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import entity.DaftarRumah;
import entity.Rumah;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TYA
 */
public class HalamanTambahRumah extends Boundary {

    @Override
    protected void process() {
        
        setMessage("");

         if (getRequest().getParameter("act") != null && getRequest().getParameter("act").equals("add")) {
            try {
                if (validate_koderumah()) {
                    if (validate_alamatrumah()) {
                        if (validate_kelurahanrumah()) {
                            if(validate_kecamatanrumah()) {
                                if(validate_kotarumah()) {
                                    DaftarRumah dr = new DaftarRumah();
                                    Rumah rumah = new Rumah();
                                    String rumahHtml = getRequest().getParameter("rumah");
                                    String kodeRumahHtml = getRequest().getParameter("koderumah");
                                    String alamatRumahHtml = getRequest().getParameter("alamatrumah");
                                    String kelurahanRumahHtml = getRequest().getParameter("kelurahanrumah");
                                    String kecamatanRumahHtml = getRequest().getParameter("kecamatanrumah");
                                    String kotaRumahHtml = getRequest().getParameter("kotarumah");
                                    rumah.setKoderumah(kodeRumahHtml);
                                    rumah.setAlamatrumah(alamatRumahHtml);
                                    rumah.setKelurahanrumah(kelurahanRumahHtml);
                                    rumah.setKecamatanrumah(kecamatanRumahHtml);
                                    rumah.setKotarumah(kotaRumahHtml);
                                    dr.tambahRumH(rumah);
                                }
                            }
                        }
                    }
                }
                getResponse().sendRedirect("daftar_pesan");
            } catch (IOException ex) {
                Logger.getLogger(HalamanTambahRumah.class.getName()).log(Level.SEVERE, null, ex); //belum dibuat tambahrumahnya
            }
        }
    }

    boolean validate_koderumah() {
        
        String koderumah = getRequest().getParameter("koderumah");
        if(koderumah == null){
            return false;
        }
        if(koderumah.trim().equals("")){
            return false;
        }

        return true;
    }

    public boolean validate_alamatrumah() {

        String alamatrumah = getRequest().getParameter("alamatrumah");

        if(alamatrumah == null){
            return false;
        }

        if(alamatrumah.trim().equals("")){
            return false;
        }

        return true;
    }
    
    public boolean validate_kelurahanrumah() {

        String kelurahanrumah = getRequest().getParameter("kelurahanrumah");

        if(kelurahanrumah == null){
            return false;
        }

        if(kelurahanrumah.trim().equals("")){
            return false;
        }

        return true;
    }
    public boolean validate_kecamatanrumah() {

        String kecamatanrumah = getRequest().getParameter("kecamatanrumah");

        if(kecamatanrumah == null){
            return false;
        }

        if(kecamatanrumah.trim().equals("")){
            return false;
        }

        return true;
    }
    
    public boolean validate_kotarumah() {

        String kotarumah = getRequest().getParameter("kotarumah");

        if(kotarumah == null){
            return false;
        }

        if(kotarumah.trim().equals("")){
            return false;
        }

        return true;
    }
    
       
    
}

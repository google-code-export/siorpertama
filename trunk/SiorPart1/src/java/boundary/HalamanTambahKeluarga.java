/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import entity.DaftarKeluarga;
import entity.Keluarga;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author 1015
 */


public class HalamanTambahKeluarga extends Boundary {
    @Override
protected void process() {
        
        setMessage("");

         if (getRequest().getParameter("act") != null && getRequest().getParameter("act").equals("add")) {
            try {
                if (validate_kodekeluarga()) {
                    if (validate_anggotakeluarga()) {
                      if(validate_kepalakeluarga()) {
                                    DaftarKeluarga dr = new DaftarKeluarga();
                                    Keluarga keluarga = new Keluarga();
                                    String keluargaHtml = getRequest().getParameter("keluarga");
                                    String kodeRumahHtml = getRequest().getParameter("koderumah");
                                    String alamatRumahHtml = getRequest().getParameter("alamatrumah");
                                    String kelurahanRumahHtml = getRequest().getParameter("kelurahanrumah");
                                    String kecamatanRumahHtml = getRequest().getParameter("kecamatanrumah");
                                    String kotaRumahHtml = getRequest().getParameter("kotarumah");
                                    keluarga.setAnggotakeluarga(4);
                                    keluarga.setKepalakeluarga(keluargaHtml);
                                    keluarga.setKodekeluarga(keluargaHtml);
                                    dr.tambahKeluarga(keluarga);
                        }
                    }
                }
                getResponse().sendRedirect("daftar_pesan");
            } catch (IOException ex) {
                Logger.getLogger(HalamanTambahRumah.class.getName()).log(Level.SEVERE, null, ex); //belum dibuat tambahrumahnya
            }
        }
    }

    boolean validate_kodekeluarga() {
        
        String kodekeluarga = getRequest().getParameter("kodekeluarga");
        if(kodekeluarga == null){
            return false;
        }
        if(kodekeluarga.trim().equals("")){
            return false;
        }

        return true;
    }

    public boolean validate_anggotakeluarga() {

        String alamatrumah = getRequest().getParameter("alamatrumah");

        if(alamatrumah == null){
            return false;
        }

        if(alamatrumah.trim().equals("")){
            return false;
        }

        return true;
    }
    
    public boolean validate_kepalakeluarga() {

        String kepalakeluarga = getRequest().getParameter("kepalakeluarga");

        if(kepalakeluarga == null){
            return false;
        }

        if(kepalakeluarga.trim().equals("")){
            return false;
        }
        return true;
    }
        
       
}

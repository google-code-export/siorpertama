/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import entity.DaftarWarga;
import entity.Warga;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lia
 */
public class HalamanTambahWarga extends Boundary {

    @Override
    protected void process() {
                    
        setMessage("");

         if (getRequest().getParameter("act") != null && getRequest().getParameter("act").equals("add")) {
            try {
                if (validate_noktp()) {
                    if (validate_kodekeluarga()) {
                        if (validate_namalengkap()) {
                            if(validate_tempatlahir()) {
                                if(validate_tanggallahir()) {
                                    if(validate_alamatktp()) {
                                       if(validate_kotaktp()) {                                                }
                                            DaftarWarga dwarga = new DaftarWarga();
                                            Warga warga = new Warga();
                                            String noktpHtml = getRequest().getParameter("koderumah");
                                            String kodekeluargaHtml = getRequest().getParameter("alamatrumah");
                                            String namalengkapHtml = getRequest().getParameter("kelurahanrumah");
                                            String tempatlahirHtml = getRequest().getParameter("kecamatanrumah");
                                            String tanggallahirHtml = getRequest().getParameter("tanggallahir");
                                            String alamatktpHtml = getRequest().getParameter("alamatktp");
                                            String kotaktpHtml = getRequest().getParameter("kotaktp");
                                            String rtktpHtml = getRequest().getParameter("rtktp");
                                            String rwktpHtml = getRequest().getParameter("rwktp");
                                            String kelurahanktpHtml = getRequest().getParameter("kelurahanktp");
                                            String kecamatanktpHtml = getRequest().getParameter("kecamatanktp");
                                            String kewarganegaraanHtml = getRequest().getParameter("kewarganegaraan");
                                            warga.setNoktp(noktpHtml);
                                            warga.setKodekeluarga(kodekeluargaHtml);
                                            warga.setNamalengkap(namalengkapHtml);
                                            warga.setTempatlahir(tempatlahirHtml);
                                            warga.setTanggallahir(null);
                                            warga.setAlamatktp(alamatktpHtml);
                                            warga.setKotaktp(kotaktpHtml);
                                            warga.setRtktp(Integer.valueOf(rtktpHtml));
                                            warga.setRwktp(Integer.valueOf(rwktpHtml));
                                            warga.setKelurahanktp(kelurahanktpHtml);
                                            warga.setKecamatanktp(kecamatanktpHtml);
                                            warga.setKewarganegaraan(kewarganegaraanHtml);
                                           dwarga.tambahWarga(warga);
                                    }
                                }
                            }
                        }
                    }
                }
                getResponse().sendRedirect("daftar_warga");
            } catch (IOException ex) {
                Logger.getLogger(HalamanTambahWarga.class.getName()).log(Level.SEVERE, null, ex); //belum dibuat tambahrumahnya
            }
        }
        
    }
    
    public boolean validate_noktp() {
        
        String noktp = getRequest().getParameter("noktp");
        if(noktp == null){
            return false;
        }
        if(noktp.trim().equals("")){
            return false;
        }

        return true;
    }
   
     public boolean validate_kodekeluarga() {
        
        String kodekeluarga = getRequest().getParameter("kodekeluarga");
        if(kodekeluarga == null){
            return false;
        }
        if(kodekeluarga.trim().equals("")){
            return false;
        }

        return true;
    }
     
     public boolean validate_namalengkap() {
        
        String namalengkap = getRequest().getParameter("namalengkap");
        if(namalengkap == null){
            return false;
        }
        if(namalengkap.trim().equals("")){
            return false;
        }

        return true;
    } 
    
    public boolean validate_tempatlahir() {
        
        String tempatlahir = getRequest().getParameter("tempatlahir");
        if(tempatlahir == null){
            return false;
        }
        if(tempatlahir.trim().equals("")){
            return false;
        }

        return true;
    } 
    
    public boolean validate_tanggallahir() {
        
        String tanggallahir = getRequest().getParameter("tanggallahir");
        if(tanggallahir == null){
            return false;
        }
        if(tanggallahir.trim().equals("")){
            return false;
        }

        return true;
    } 
    
    public boolean validate_kewarganegaraan() {
        
        String kewarganegaraan = getRequest().getParameter("kewarganegaraan");
        if(kewarganegaraan == null){
            return false;
        }
        if(kewarganegaraan.trim().equals("")){
            return false;
        }

        return true;
    } 
     
    public boolean validate_alamatktp() {
        
        String alamatktp = getRequest().getParameter("alamatktp");
        if(alamatktp == null){
            return false;
        }
        if(alamatktp.trim().equals("")){
            return false;
        }

        return true;
    } 
        
    public boolean validate_rtktp() {
        
        String rtktp = getRequest().getParameter("rtktp");
        if(rtktp == null){
            return false;
        }
        if(rtktp.trim().equals("")){
            return false;
        }

        return true;
    } 
            
    public boolean validate_rwktp() {
        
        String rwktp = getRequest().getParameter("rwktp");
        if(rwktp == null){
            return false;
        }
        if(rwktp.trim().equals("")){
            return false;
        }

        return true;
    }
    
    public boolean validate_kelurahanktp() {
        
        String kelurahanktp = getRequest().getParameter("kelurahanktp");
        if(kelurahanktp == null){
            return false;
        }
        if(kelurahanktp.trim().equals("")){
            return false;
        }

        return true;
    }
         
    public boolean validate_kecamatanktp() {
        
        String kecamatanktp = getRequest().getParameter("kecamatanktp");
        if(kecamatanktp == null){
            return false;
        }
        if(kecamatanktp.trim().equals("")){
            return false;
        }

        return true;
    }
         
    public boolean validate_kotaktp() {
        
        String kotaktp = getRequest().getParameter("kotaktp");
        if(kotaktp == null){
            return false;
        }
        if(kotaktp.trim().equals("")){
            return false;
        }

        return true;
    }
    
    
    
}

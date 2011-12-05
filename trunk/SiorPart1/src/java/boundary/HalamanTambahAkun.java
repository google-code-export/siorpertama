/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import entity.DaftarAkun;
import entity.Akun;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Lia
 */
public class HalamanTambahAkun extends Boundary {

    @Override
    protected void process() {
         setMessage("");

         if (getRequest().getParameter("act") != null && getRequest().getParameter("act").equals("add")) {
            try {
                if (validate_username()) {
                    if (validate_email()) {
                        if (validate_password()) {     
                            if (validate_namaakun()) {                            
                                            DaftarAkun dakun = new DaftarAkun();
                                            Akun akun = new Akun();
                                            String usernameHtml = getRequest().getParameter("kodehunian");
                                            String emailHtml = getRequest().getParameter("koderumah");
                                            String passwordHtml = getRequest().getParameter("noktp");
                                            String namaAkunHtml = getRequest().getParameter("namalengkap");
                                            String jumlahRumahHtml = getRequest().getParameter("jumlahrumah");
                                            String rtAkunHtml = getRequest().getParameter("rtakun");
                                            String rwAkunHtml = getRequest().getParameter("rwakun");
                                            String kelurahanAkunHtml = getRequest().getParameter("kelurahanakun");
                                            String kecamatanAkunHtml = getRequest().getParameter("kecamatanakun");
                                            String kotaAkunHtml = getRequest().getParameter("kotaakun");
                                            akun.setUsername(usernameHtml);
                                            akun.setEmail(emailHtml);
                                            akun.setPassword(passwordHtml);
                                            akun.setNamaakun(namaAkunHtml);
                                            akun.setJumlahrumah(Integer.valueOf(jumlahRumahHtml));
                                            akun.setRtakun(Integer.valueOf(rtAkunHtml));
                                            akun.setRwakun(Integer.valueOf(rwAkunHtml));
                                            akun.setKelurahanakun(kelurahanAkunHtml);
                                            akun.setKecamatanakun(kecamatanAkunHtml);
                                            akun.setKotaakun(kotaAkunHtml);
                                          dakun.tambahAkun(akun);
                            }
                        }
                    }
                }
                getResponse().sendRedirect("daftar_warga");
            } catch (IOException ex) {
                Logger.getLogger(HalamanTambahHunian.class.getName()).log(Level.SEVERE, null, ex); //belum dibuat tambahrumahnya
            }
        }
        
    }

        public boolean validate_username() {
        
        String username = getRequest().getParameter("username");
        if(username == null){
            return false;
        }
        if(username.trim().equals("")){
            return false;
        }

        return true;
    }
    
    public boolean validate_email() {
        
        String email = getRequest().getParameter("email");
        if(email == null){
            return false;
        }
        if(email.trim().equals("")){
            return false;
        }

        return true;
    }
    
    public boolean validate_password() {
        
        String password = getRequest().getParameter("password");
        if(password == null){
            return false;
        }
        if(password.trim().equals("")){
            return false;
        }

        return true;
    }
    
    public boolean validate_namaakun() {
        
        String namaakun = getRequest().getParameter("namaakun");
        if(namaakun == null){
            return false;
        }
        if(namaakun.trim().equals("")){
            return false;
        }

        return true;
    }
}

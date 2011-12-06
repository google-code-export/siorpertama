/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

/**
 *
 * @author TYA
 */
public class HalamanDaftarHunianKosong extends HalamanDaftarHunian {
    
     @Override
    protected void process() {
       setTemplate("/WEB-INF/jsp/gui_daftarhunian_kosong.jsp");
    }
    
}

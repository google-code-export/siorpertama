/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entity.Keluargaindo;
import model.DaftarKeluargaindo;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Lia
 */
@WebServlet(name = "EditKeluargaindo", urlPatterns = {"/edit_keluarga"})
public class EditKeluargaindo {

    HttpServletRequest request;
    public EditKeluargaindo(HttpServletRequest request) {
        this.request = request;
    }
   public String Edit() {
        Keluargaindo keluarga = new Keluargaindo();
        DaftarKeluargaindo ou = new DaftarKeluargaindo();
        HttpSession session = request.getSession();

        if (session.getAttribute("username") != null) {
            Long idKeluarga = Long.parseLong(request.getParameter("idKeluargaindo"));
            keluarga = ou.getKeluarga(idKeluarga);
            session.setAttribute("keluarga", keluarga);
            return "edit_keluargas.jsp";
        } else {
            return "keluargaindos.jsp";
        }
    }
}

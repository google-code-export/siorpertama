/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import comparator.AkunComparator;
import entity.Akun;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DaftarAkun;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import model.exceptions.NonexistentEntityException;
import model.exceptions.RollbackFailureException;

/**
 *
 * @author ntonk
 */
@WebServlet(name = "ProsesEditAkun", urlPatterns = {"/ProsesEditAkun"})
public class ProsesEditAkun extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, RollbackFailureException, NonexistentEntityException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProsesEditAkun</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProsesEditAkun at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
       DaftarAkun daftarakun = new DaftarAkun();
            String jsp = "";           

            String userid = request.getParameter("user_id");
            String username = request.getParameter("username");
                       
            
            String idusr = request.getParameter("id_edit_akun");
            Akun user = daftarakun.findAkun(userid);

            if (userid.equals("")) {
                JOptionPane.showMessageDialog(null, "User id harus diisi !",
                        "Error!",JOptionPane.WARNING_MESSAGE);
                request.setAttribute("akun_edit", user);
                jsp = "halaman/edit_akun.jsp";
            } else if (username.equals("")) {
                JOptionPane.showMessageDialog(null, "username harus diisi !",
                        "Error!",JOptionPane.WARNING_MESSAGE);
                request.setAttribute("akun_edit", user);
                jsp = "halaman/edit_akun.jsp";
            } //validate length field
            else if (username.equalsIgnoreCase("000000")) {
                JOptionPane.showMessageDialog(null, "username tidak boleh bernilai nol !",
                        "Error!",JOptionPane.WARNING_MESSAGE);
                request.setAttribute("akun_edit", user);
                jsp = "halaman/edit_akun.jsp";  
            } //validate record on database
           //else if (daftarakun.isKodeExist && !username.isKodeNoChange(kdkeluarga)) {
             // JOptionPane.showMessageDialog(null, "Kode Keluarga sudah ada dalam database !",
               //      "Kesalahan!",JOptionPane.WARNING_MESSAGE);
              //request.setAttribute("keluarga_edit", keluarga);
               //jsp = "halaman/edit_keluarga.jsp";

           //validate nmbankpos on database
          //validate nmbankpos on database

             else {
                user.setIdAkun(userid);
                user.setUsername(username);
                
                daftarakun.editAkun(user);
                List<Akun> listuser = daftarakun.getUsername();
                listuser = daftarakun.getUsername();
                Collections.sort(listuser, new AkunComparator());
                request.setAttribute("list_user_account", listuser);
                jsp = "halaman/Daftar_User.jsp";
            }
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(jsp);
            requestDispatcher.forward(request, response);
            
        } finally {            
            out.close();
        }
}

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (RollbackFailureException ex) {
            Logger.getLogger(ProsesEditAkun.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ProsesEditAkun.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (RollbackFailureException ex) {
            Logger.getLogger(ProsesEditAkun.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ProsesEditAkun.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}

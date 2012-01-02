/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import comparator.WargaComparator;
import entity.Warga;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DaftarWarga;
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
@WebServlet(name = "ProsesEditWarga", urlPatterns = {"/ProsesEditWarga"})
public class ProsesEditWarga extends HttpServlet {

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
            out.println("<title>Servlet ProsesEditWarga</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProsesEditWarga at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
            DaftarWarga daftarwarga = new DaftarWarga();
            String jsp = "";           

            String namalengkap = request.getParameter("nama_lengkap");
            String noktp1 = request.getParameter("no_ktp");
            int noktp = Integer.parseInt(noktp1);
            String idwarga1 = request.getParameter("id_warga");
            int idwarga = Integer.parseInt(idwarga1);
                       
            
            String idwrg = request.getParameter("id_edit_warga");
            Integer idWr = Integer.parseInt(idwrg);
            Warga warga = daftarwarga.findWarga(idWr);

            if (idwarga1.equals("")) {
                JOptionPane.showMessageDialog(null, "id warga harus diisi !",
                        "Error!",JOptionPane.WARNING_MESSAGE);
                request.setAttribute("warga_edit", warga);
                jsp = "halaman/edit_warga.jsp";
            } else if (namalengkap.equals("")) {
                JOptionPane.showMessageDialog(null, "nama lengkap harus diisi !",
                        "Error!",JOptionPane.WARNING_MESSAGE);
                request.setAttribute("warga_edit", warga);
                jsp = "halaman/edit_warga.jsp";
            } //validate length field
            else if (noktp1.equalsIgnoreCase("000000")) {
                JOptionPane.showMessageDialog(null, "nomor ktp tidak boleh bernilai nol !",
                        "Error!",JOptionPane.WARNING_MESSAGE);
                request.setAttribute("warga_edit", warga);
                jsp = "halaman/edit_warga.jsp";  
            } //validate record on database
           // else if (daftarakun.isKodeExist && !username.isKodeNoChange(kdkeluarga)) {
               // JOptionPane.showMessageDialog(null, "Kode Keluarga sudah ada dalam database !",
               //         "Kesalahan!",JOptionPane.WARNING_MESSAGE);
               // request.setAttribute("keluarga_edit", keluarga);
               // jsp = "halaman/edit_keluarga.jsp";
           // } //validate nmbankpos on database
              else {
               warga.setIdWarga(idwarga);
               warga.setNoktp(noktp);
               warga.setNamalengkap(namalengkap);
              
                
                daftarwarga.editWarga(warga);
                List<Warga> listwarga = daftarwarga.getIdWarga();
                listwarga = daftarwarga.getIdWarga();
                Collections.sort(listwarga, new WargaComparator());
                request.setAttribute("list_warga", listwarga);
                jsp = "halaman/Daftar_warga.jsp";
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


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import comparator.IuranComparator;
import entity.Iuran;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DaftarIuran;
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
@WebServlet(name = "ProsesEditIuran", urlPatterns = {"/ProsesEditIuran"})
public class ProsesEditIuran extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProsesEditIuran</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProsesEditIuran at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
            DaftarIuran daftariuran = new DaftarIuran();
            String jsp = "";           

            String kodeiuran = request.getParameter("kode_iuran");
            String kodekeluarga = request.getParameter("kode_keluarga");
            
                       
            
            String kdiu = request.getParameter("id_edit_iuran");
            Integer kdIu = Integer.parseInt(kdiu);
            Iuran iuran = daftariuran.findIuran(kdIu);
            
            if (kodeiuran.equals("")) {
                JOptionPane.showMessageDialog(null, "kode iuran harus diisi !",
                        "Error!",JOptionPane.WARNING_MESSAGE);
                request.setAttribute("iuran_edit", iuran);
                jsp = "halaman/edit_iuran.jsp";
            } else if (kodekeluarga.equals("")) {
                JOptionPane.showMessageDialog(null, "kode keluarga harus diisi !",
                        "Error!",JOptionPane.WARNING_MESSAGE);
                request.setAttribute("iuran_edit", iuran);
                jsp = "halaman/edit_iuran.jsp";
            } //validate length field
            else if (kodeiuran.equalsIgnoreCase("000000")) {
                JOptionPane.showMessageDialog(null, "kode iuran tidak boleh bernilai nol !",
                        "Error!",JOptionPane.WARNING_MESSAGE);
                request.setAttribute("iuran_edit", iuran);
                jsp = "halaman/edit_iuran.jsp";  
            } //validate record on database
           // else if (daftarakun.isKodeExist && !username.isKodeNoChange(kdkeluarga)) {
               // JOptionPane.showMessageDialog(null, "Kode Keluarga sudah ada dalam database !",
               //         "Kesalahan!",JOptionPane.WARNING_MESSAGE);
               // request.setAttribute("keluarga_edit", keluarga);
               // jsp = "halaman/edit_keluarga.jsp";
           // } //validate nmbankpos on database
              else {
               iuran.setKodeiuran(kodeiuran);
               iuran.setKodekeluarga(kodekeluarga);
               
              
                
                daftariuran.editIuran(iuran);
                List<Iuran> listwarga = daftariuran.getIuran();
                listwarga = daftariuran.getIuran();
                Collections.sort(listwarga, new IuranComparator());
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
        processRequest(request, response);
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
        processRequest(request, response);
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

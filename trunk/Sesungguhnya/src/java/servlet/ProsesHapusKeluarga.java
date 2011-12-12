/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import comparator.KeluargaindoComparator;
import entity.Keluargaindo;
import model.DaftarKeluargaindo;
import model.exceptions.NonexistentEntityException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author Lia
 */
@WebServlet(name = "ProsesHapusKeluarga", urlPatterns = {"/hapus_keluarga"})
public class ProsesHapusKeluarga extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NonexistentEntityException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProsesHapusKeluarga</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProsesHapusKeluarga at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
            
            DaftarKeluargaindo daftarKeluarga = new DaftarKeluargaindo();
            List<Keluargaindo> listKeluarga = daftarKeluarga.getKeluarga();
            Collections.sort(listKeluarga, new KeluargaindoComparator());
            String cekKeluarga[] = request.getParameterValues("cek_keluarga");
            String jsp = "";

            if (cekKeluarga == null) {
                JOptionPane.showMessageDialog(null, "Keluarga tidak ada yang dipilih",
                        "Kesalahan!",JOptionPane.WARNING_MESSAGE);
                request.setAttribute("list_keluargaindo", listKeluarga);
                jsp = "halaman/keluarga_indos.jsp";
            } else {
                int j = JOptionPane.showConfirmDialog(null, "apakah anda yakin akan menghapus ?",
                        JOptionPane.MESSAGE_TYPE_PROPERTY, JOptionPane.YES_NO_OPTION);

                if (j == JOptionPane.YES_OPTION) {
                    for (int i = 0; i < cekKeluarga.length; i++) {
                        Integer idKel = Integer.parseInt(cekKeluarga[i]);
                        Keluargaindo keluarga = daftarKeluarga.findBankPos(idKel);
                        daftarKeluarga.destroy(idKel);
                    }
                }
                listKeluarga = daftarKeluarga.getKeluarga();
                Collections.sort(listKeluarga, new KeluargaindoComparator());
                request.setAttribute("list_keluargaindo", listKeluarga);
                jsp = "halaman/keluarga_indos.jsp";
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
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ProsesHapusKeluarga.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ProsesHapusKeluarga.class.getName()).log(Level.SEVERE, null, ex);
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

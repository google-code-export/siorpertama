/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import comparator.KeluargaindoComparator;
import entity.Keluargaindo;
import model.DaftarKeluargaindo;
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

/**
 *
 * @author Lia
 */
@WebServlet(name = "EditKeluargaindo", urlPatterns = {"/edit_keluarga"})
public class EditKeluargaindo extends HttpServlet {

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
            out.println("<title>Servlet EditKeluargaindo</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditKeluargaindo at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
            
            DaftarKeluargaindo daftarKeluarga = new DaftarKeluargaindo();
            List<Keluargaindo> listKeluarga = daftarKeluarga.getKeluarga();
            Collections.sort(listKeluarga, new KeluargaindoComparator());
            request.setAttribute("list_keluargaindo", listKeluarga);
            String jsp = "";
            String cekKeluarga[] = request.getParameterValues("cek_keluarga");

            if (cekKeluarga == null) {
                JOptionPane.showMessageDialog(null, "Keluarga tidak ada yang dipilih",
                        "Kesalahan!",JOptionPane.WARNING_MESSAGE);
                jsp = "halaman/keluarga_indos.jsp";
            } else if (cekKeluarga.length > 1) {
                JOptionPane.showMessageDialog(null, "Pilih salah satu Keluarga saja !",
                        "Kesalahan!",JOptionPane.WARNING_MESSAGE);
                jsp = "halaman/keluarga_indos.jsp";
            } else {
                Integer idKeluarga = Integer.parseInt(cekKeluarga[0]);
                Keluargaindo keluarga = daftarKeluarga.findBankPos(idKeluarga);
                request.setAttribute("keluarga_edit", keluarga);
                jsp = "/halaman/edit_keluargas.jsp";
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

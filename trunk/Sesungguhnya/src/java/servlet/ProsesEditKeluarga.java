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
@WebServlet(name = "ProsesEditKeluarga", urlPatterns = {"/proses_tambah_keluarga"})
public class ProsesEditKeluarga extends HttpServlet {

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
            out.println("<title>Servlet ProsesEditKeluarga</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProsesEditKeluarga at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
            
            DaftarKeluargaindo daftarKeluarga = new DaftarKeluargaindo();
            String jsp = "";           

            String kdkeluarga = request.getParameter("kode_keluarga");
            String kepalakel = request.getParameter("kepala_keluarga");
            String anggotakel1 = request.getParameter("anggota_keluarga");
            int anggotakel = Integer.parseInt(anggotakel1);
            
            
            String idKels = request.getParameter("id_edit_keluarga");
            Integer idKel = Integer.parseInt(idKels);
            Keluargaindo keluarga = daftarKeluarga.findBankPos(idKel);

            if (kdkeluarga.equals("")) {
                JOptionPane.showMessageDialog(null, "Kode Keluarga tidak boleh kosong !",
                        "Kesalahan!",JOptionPane.WARNING_MESSAGE);
                request.setAttribute("keluarga_edit", keluarga);
                jsp = "halaman/edit_keluargas.jsp";
            } else if (kepalakel.equals("")) {
                JOptionPane.showMessageDialog(null, "Kepala Keluarga tidak boleh kosong !",
                        "Kesalahan!",JOptionPane.WARNING_MESSAGE);
                request.setAttribute("keluarga_edit", keluarga);
                jsp = "halaman/edit_keluarga.jsp";
            } else if (anggotakel1.equals("")) {
                JOptionPane.showMessageDialog(null, "Anggota Keluarga tidak boleh kosong !",
                        "Kesalahan!",JOptionPane.WARNING_MESSAGE);
                request.setAttribute("keluarga_edit", keluarga);
                jsp = "halaman/edit_keluarga.jsp";      
            } //validate length field
            else if (kdkeluarga.equalsIgnoreCase("000000")) {
                JOptionPane.showMessageDialog(null, "Kode Keluarga tidak boleh bernilai nol !",
                        "Kesalahan!",JOptionPane.WARNING_MESSAGE);
                request.setAttribute("keluarga_edit", keluarga);
                jsp = "halaman/edit_keluarga.jsp";  
            } //validate record on database
            else if (daftarKeluarga.isKodeExist(kdkeluarga) && !keluarga.isKodeNoChange(kdkeluarga)) {
                JOptionPane.showMessageDialog(null, "Kode Keluarga sudah ada dalam database !",
                        "Kesalahan!",JOptionPane.WARNING_MESSAGE);
                request.setAttribute("keluarga_edit", keluarga);
                jsp = "halaman/edit_keluarga.jsp";
            } //validate nmbankpos on database
             else {
                keluarga.setKodekel(kdkeluarga);
                keluarga.setKeplakel(kepalakel);
                keluarga.setAnggotakel(anggotakel);
              
                daftarKeluarga.edit(keluarga);
                List<Keluargaindo> listKeluarga = daftarKeluarga.getKeluarga();
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

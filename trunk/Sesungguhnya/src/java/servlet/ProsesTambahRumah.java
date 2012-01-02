/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import comparator.RumahComparator;
import entity.Rumah;
import model.DaftarRumah;
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
 * @author Putri A.
 */
@WebServlet(name = "ProsesTambahGaji", urlPatterns = {"/proses_tambah_gaji"})
public class ProsesTambahRumah extends HttpServlet {

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
            out.println("<title>Servlet ProsesTambahKeluargaindo</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProsesTambahKeluargaindo at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
            
            Rumah rumah = new Rumah();
            DaftarRumah daftarRumah = new DaftarRumah();
            String jsp = "";

            String kdrumah = request.getParameter("kode_rumah");
            String almtrumah = request.getParameter("alamat_rumah");
            String rtrumah1 = request.getParameter("rt_rumah");
            String rwrumah1 = request.getParameter("rw_rumah");
            String kelrumah = request.getParameter("kelurahan_rumah");
            String kecrumah = request.getParameter("kecamatan_rumah");
            String ktrumah = request.getParameter("kota_rumah");
            String provrumah = request.getParameter("provinsi_rumah");
            
            int rtrumah = Integer.parseInt(rtrumah1);
            int rwrumah = Integer.parseInt(rwrumah1);
                    
            
            //validate blank field
            if (kdrumah.equals("") && almtrumah.equals("") && rtrumah1.equals("") 
                    && rwrumah1.equals("") && kelrumah.equals("") && kecrumah.equals("")
                    && ktrumah.equals("") && provrumah.equals("")) {
                out.println("Isilah Form Dengan Lengkap");
                jsp = "halaman/gui_tambah_rumah.jsp";   
            }          
             //validate zero value
            else if (kdrumah.equalsIgnoreCase("000000")) {
                out.println("Kode RUmah tidak boleh bernilai nol !");
                jsp = "halaman/gui_tambah_rumah.jsp";
            } //validate record on database
            else if (daftarRumah.isKodeExist(kdrumah)) {
                out.println("Kode Rumah sudah ada dalam database !");
                jsp = "pages/gui_tambah_rumah.jsp";
            } else {
                rumah.setKodeRumah(kdrumah);
                rumah.setAlamatRumah(almtrumah);
                rumah.setRT(rtrumah);
                rumah.setRW(rwrumah);
                rumah.setKelurahan(kelrumah);
                rumah.setKecamatan(kecrumah);
                rumah.setKota(ktrumah);
                rumah.setPovinsi(provrumah);
                daftarRumah.tambahRumah(rumah);
                jsp = "halaman/lihat_rumah.jsp";
            }

            List<Rumah> listRumah = daftarRumah.getRumah();
            Collections.sort(listRumah, new RumahComparator());
            request.setAttribute("list_rumah", listRumah);
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

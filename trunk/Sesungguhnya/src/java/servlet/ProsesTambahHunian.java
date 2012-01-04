/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import comparator.HunianComparator;
import entity.Hunian;
import model.DaftarHunian;
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

/**
 *
 * @author Lia
 */
@WebServlet(name = "ProsesTambahHunian", urlPatterns = {"/proses_tambah_hunian"})
public class ProsesTambahHunian extends HttpServlet {

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
            out.println("<title>Servlet ProsesTambahHunian</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProsesTambahHunian at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
            
            Hunian hunian = new Hunian();
            DaftarHunian daftarHunian = new DaftarHunian();
            String jsp = "";

            String kodehunian = request.getParameter("kode_hunian");
            String kodewarga = request.getParameter("kode_warga");
            String koderumah = request.getParameter("kode_rumah");
            String tanggalmasuk = request.getParameter("tanggal_masuk");
            String tanggalkeluar = request.getParameter("tanggal_keluar");
         
            int noktp = Integer.parseInt(kodewarga);
            
            if (kodehunian.isEmpty() || kodewarga.isEmpty() || koderumah.isEmpty()
                    || tanggalmasuk.isEmpty() || tanggalkeluar.isEmpty()) {//validasi isian masukan (kosong/tidak)
            request.setAttribute("errorhunian", "Mohon isi form dengan lengkap !");
            RequestDispatcher rdp = request.getRequestDispatcher("tambah_hunian");
            rdp.forward(request, response);

        } else if (kodehunian.equalsIgnoreCase("000000")) { 
            request.setAttribute("errorhunian", "Kode Hunian Tidak Boleh Bernilai 00000 !");
            RequestDispatcher rdp = request.getRequestDispatcher("tambah_hunian");
            rdp.forward(request, response);
        } else if (kodewarga.equalsIgnoreCase("000000")) { 
            request.setAttribute("errorhunian", "Kode Warga Tidak Boleh Bernilai 00000 !");
            RequestDispatcher rdp = request.getRequestDispatcher("tambah_hunian");
            rdp.forward(request, response);
        } else if (koderumah.equalsIgnoreCase("000000")) { 
            request.setAttribute("errorhunian", "Kode Rumah Tidak Boleh Bernilai 00000 !");
            RequestDispatcher rdp = request.getRequestDispatcher("tambah_hunian");
            rdp.forward(request, response);
        } else if (daftarHunian.isKodeExist(kodehunian)) {
            request.setAttribute("errorhunian", "Kode hunian telah terpakai !");
            RequestDispatcher rdp = request.getRequestDispatcher("tambah_hunian");
            rdp.forward(request, response);
        }else {
                hunian.setKodehunian(kodehunian);
                hunian.setKoderumah(koderumah);
                hunian.setNoktp(noktp);
                hunian.setTanggalmasuk(null);
                hunian.setTanggalkeluar(null);
                daftarHunian.tambahHunian(hunian);
                
                jsp = "halaman/hunian.jsp";
            }

            List<Hunian> listHunian = daftarHunian.getHunian();
            Collections.sort(listHunian, new HunianComparator());
            request.setAttribute("list_hunian", listHunian);
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

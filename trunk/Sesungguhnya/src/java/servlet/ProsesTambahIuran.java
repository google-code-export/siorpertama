/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entity.Iuran;
import model.DaftarIuran;
import comparator.IuranComparator;
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
@WebServlet(name = "ProsesTambahIuran", urlPatterns = {"/proses_tambah_iuran"})
public class ProsesTambahIuran extends HttpServlet {

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
            out.println("<title>Servlet ProsesTambahIuran</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProsesTambahIuran at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
            
            Iuran iuran = new Iuran();
            DaftarIuran daftarIuran = new DaftarIuran();
            String jsp = "";
          
            String kodeiuran = request.getParameter("kode_iuran");
            String kodekeluarga = request.getParameter("kode_keluarga");
            String jenisiuran = request.getParameter("jenis_iuran");
            String bulaniuran = request.getParameter("bulan_iuran");
            String jumlahiuran = request.getParameter("jumlah_iuran");
            String pembayar = request.getParameter("pembayar");
            String tanggalbayar = request.getParameter("tanggal_bayar");
            
            int jumlahbayar = Integer.parseInt(jumlahiuran);
          
            if (kodeiuran.isEmpty() || kodekeluarga.isEmpty() || jenisiuran.isEmpty()
                    || bulaniuran.isEmpty() || jumlahiuran.isEmpty() || pembayar.isEmpty()
                    || tanggalbayar.isEmpty()) {//validasi isian masukan (kosong/tidak)
            request.setAttribute("erroriuran", "Mohon isi form dengan lengkap !");
            RequestDispatcher rdp = request.getRequestDispatcher("tambah_iuran");
            rdp.forward(request, response);

        } else if (kodeiuran.equalsIgnoreCase("000000")) { 
            request.setAttribute("erroriuran", "Kode Iuran Tidak Boleh Bernilai 00000 !");
            RequestDispatcher rdp = request.getRequestDispatcher("tambah_iuran");
            rdp.forward(request, response);
        } else if (daftarIuran.isKodeExist(kodeiuran)) {
            request.setAttribute("erroriuran", "Kode keluarga telah terpakai !");
            RequestDispatcher rdp = request.getRequestDispatcher("tambah_iuran");
            rdp.forward(request, response);
        }else {
                iuran.setKodeiuran(kodeiuran);
                iuran.setKodekeluarga(kodekeluarga);
                iuran.setJenisiuran(jenisiuran);
                iuran.setJumlahbayar(jumlahbayar);
                iuran.setBulaniuran(bulaniuran);
                iuran.setTanggalbayar(null);
                daftarIuran.tambahIuran(iuran);
                jsp = "halaman/iuran.jsp";
            }

            List<Iuran> listIuran = daftarIuran.getIuran();
            Collections.sort(listIuran, new IuranComparator());
            request.setAttribute("list_iuran", listIuran);
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

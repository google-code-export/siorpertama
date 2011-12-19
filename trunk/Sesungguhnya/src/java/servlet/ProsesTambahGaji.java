/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import comparator.GajiComparator;
import entity.Gaji;
import model.DaftarGaji;
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
public class ProsesTambahGaji extends HttpServlet {

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
            
            Gaji gaji = new Gaji();
            DaftarGaji daftarGaji = new DaftarGaji();
            String jsp = "";

            String kdbayar = request.getParameter("kode_bayar");
            String jnsgaji = request.getParameter("jenis_gaji");
            String pnrimagaji = request.getParameter("penerima_gaji");
            String blngaji = request.getParameter("bulan_gaji");
            String jmhgaji1 = request.getParameter("jumlah_gaji");
            String thngaji1 = request.getParameter("tahun_gaji");
   
            int jmhgaji = Integer.parseInt(jmhgaji1);
            int thngaji = Integer.parseInt(thngaji1);
                    
            
            //validate blank field
            if (kdbayar.equals("") && jnsgaji.equals("") && pnrimagaji.equals("") 
                    && blngaji.equals("") && jmhgaji1.equals("") && thngaji1.equals("")) {
                out.println("Isilah Form Dengan Lengkap");
                jsp = "halaman/tambah_gajis.jsp";   
            }          
             //validate zero value
            else if (kdbayar.equalsIgnoreCase("000000")) {
                out.println("Kode Pembayaran tidak boleh bernilai nol !");
                jsp = "halaman/tambah_gajis.jsp";
            } //validate record on database
            else if (daftarGaji.isKodeExist(kdbayar)) {
                out.println("Kode Bayar sudah ada dalam database !");
                jsp = "pages/tambah_gajis.jsp";
            } else {
                gaji.setKodebayar(kdbayar);
                gaji.setJenisgaji(jnsgaji);
                gaji.setPenerimagaji(pnrimagaji);
                gaji.setBulangaji(blngaji);
                gaji.setJumlahgaji(jmhgaji);
                gaji.setTahungaji(thngaji);
                daftarGaji.tambahGaji(gaji);
                jsp = "halaman/lihat_gajis.jsp";
            }

            List<Gaji> listGaji = daftarGaji.getGaji();
            Collections.sort(listGaji, new GajiComparator());
            request.setAttribute("list_gaji", listGaji);
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

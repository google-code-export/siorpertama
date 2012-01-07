/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entity.DaftarKeluarga;
import entity.Keluarga;
import entity.Pengguna;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ACER
 */
@WebServlet(name = "ProsesTambahKeluarga", urlPatterns = {"/ProsesTambahKeluarga"})
public class ProsesTambahKeluarga extends HttpServlet {

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

        HttpSession session = request.getSession();
        Pengguna pengguna = (Pengguna) session.getAttribute("loged");
        String idPengguna1 = request.getParameter("idPengguna");
        
        Long idPenggunai = Long.parseLong(idPengguna1);
        Long idPengguna = pengguna.getId();

        String kodeKeluarga = request.getParameter("kode");
        String kepalaKeluarga = request.getParameter("kepala");
        String anggotaKeluarga1 = request.getParameter("anggota");
        
        int anggotaKeluarga = Integer.parseInt(anggotaKeluarga1);
        
         DaftarKeluarga daf = new DaftarKeluarga();
         Keluarga keluarga = new Keluarga();

        //validasi masukan
        if (kodeKeluarga.isEmpty() || kepalaKeluarga.isEmpty() || anggotaKeluarga1.isEmpty()) {//validasi isian masukan (kosong/tidak)
            request.setAttribute("errorkeluarga", "Maaf, data keluarga gagal disimpan. Semua kolom harus diisi. ");
            RequestDispatcher rdp = request.getRequestDispatcher("pages/tambahkeluarga.jsp");
            rdp.forward(request, response);

        } else if (!anggotaKeluarga1.matches("[0-9]*")) { //validasi input telepon harus angka
            request.setAttribute("errorkeluarga", "Maaf, data keluarga gagal disimpan. Anggota keluarga harus berupa angka.");
            RequestDispatcher rdp = request.getRequestDispatcher("pages/tambahkeluarga.jsp");
            rdp.forward(request, response);

        } else {
            //request.setAttribute("pesanberhasil", "Alhamdulillah ya, data pengurus berhasil disimpan.");
           

            keluarga.setIdPengguna(idPengguna);
            keluarga.setKodeKeluarga(kodeKeluarga);
            keluarga.setKepalaKeluarga(kepalaKeluarga);
            keluarga.setAnggotaKeluarga(anggotaKeluarga);
            daf.addKeluarga(keluarga);
            response.sendRedirect("HalamanKeluarga");
        }
        
        /*try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProsesTambahKeluarga</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProsesTambahKeluarga at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             
        } finally {            
            out.close();
        }*/
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

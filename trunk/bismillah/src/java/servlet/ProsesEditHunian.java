/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entity.DaftarHunian;
import entity.Hunian;
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
@WebServlet(name = "ProsesEditHunian", urlPatterns = {"/ProsesEditHunian"})
public class ProsesEditHunian extends HttpServlet {

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
        
        HttpSession sessionedit=request.getSession();
        
        Pengguna pengguna = (Pengguna) sessionedit.getAttribute("loged");
        Long idPengguna=pengguna.getId();
        
                
        String koderumah = request.getParameter("kode");
        String namalengkap = request.getParameter("nama");
        
               
        Long id = Long.parseLong(request.getParameter("idHun"));
        
        DaftarHunian daftar = new DaftarHunian();
        Hunian hunian = (Hunian)sessionedit.getAttribute("hunian");

        //validasi masukan
        if (koderumah.isEmpty() || namalengkap.isEmpty()) {//validasi isian masukan (kosong/tidak)
            request.setAttribute("error", "Maaf, data hunian gagal disimpan. Semua kolom harus diisi. ");
            RequestDispatcher rdp = request.getRequestDispatcher("pages/edithunian.jsp");
            rdp.forward(request, response);

                } else {
            //request.setAttribute("pesanberhasil", "Alhamdulillah ya, data hunian berhasil disimpan.");
            hunian.setKoderumah(koderumah);
            hunian.setNamalengkap(namalengkap);
            daftar.editHunian(hunian);
            response.sendRedirect("HalamanHunian");
        }
        
        /*
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

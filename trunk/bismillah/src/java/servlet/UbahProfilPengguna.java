/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entity.DaftarPengguna;
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
@WebServlet(name = "UbahProfilPengguna", urlPatterns = {"/UbahProfilPengguna"})
public class UbahProfilPengguna extends HttpServlet {

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
        Long id=pengguna.getId();
        
        DaftarPengguna dafPengguna = new DaftarPengguna();
        
        //String email = request.getParameter("email");
        String password = request.getParameter("password");
        String nmPengguna = request.getParameter("nmpengguna");
        String rtPengguna1 = request.getParameter("rtpengguna");
        String rwPengguna1 = request.getParameter("rwpengguna");
        String kelurahanPengguna = request.getParameter("kelpengguna");
        String kecamatanPengguna = request.getParameter("kecpengguna");
        String kotaPengguna = request.getParameter("kotapengguna");
        String jumlahRumah1 = request.getParameter("jmhrumah");

        int rtPengguna = Integer.parseInt(rtPengguna1);
        int rwPengguna = Integer.parseInt(rwPengguna1);
        int jumlahRumah = Integer.parseInt(jumlahRumah1);
        
        //Long id = Long.parseLong(request.getParameter("id"));
       
        //Pengguna pengguna = dafPenggguna.findPengguna(id);

        request.setAttribute("ubahpengguna", pengguna);
        
        //validasi 
        if (password.isEmpty() || nmPengguna.isEmpty() || rtPengguna1.isEmpty() || rwPengguna1.isEmpty() || kelurahanPengguna.isEmpty() || kecamatanPengguna.isEmpty() || kotaPengguna.isEmpty() || jumlahRumah1.isEmpty()) {//validasi isian masukan (kosong/tidak)
            request.setAttribute("errorprofil", "Maaf, gagal mengganti profil. Isilah kolom dengan lengkap !");
            RequestDispatcher rdp = request.getRequestDispatcher("pages/profil.jsp");
            rdp.forward(request, response);

        } else if (password.length() < 6) { //validasi panjang password
            request.setAttribute("errorprofil", "Maaf, password minimal 6 karakter");
            RequestDispatcher rdp = request.getRequestDispatcher("pages/profil.jsp");
            rdp.forward(request, response);
            
        } else if(!rtPengguna1.matches("[0-9]*")){ //validasi input telepon harus angka
            request.setAttribute("errorprofil", "Maaf, No. RT harus berupa angka. Proses ubah profil gagal.");
            RequestDispatcher rdp = request.getRequestDispatcher("pages/profil.jsp");
            rdp.forward(request, response);

        } else if(!rwPengguna1.matches("[0-9]*")){ //validasi input telepon harus angka
            request.setAttribute("errorprofil", "Maaf, No. RW harus berupa angka. Proses ubah profil gagal.");
            RequestDispatcher rdp = request.getRequestDispatcher("pages/profil.jsp");
            rdp.forward(request, response);

        } else if(!jumlahRumah1.matches("[0-9]*")){ //validasi input telepon harus angka
            request.setAttribute("errorprofil", "Maaf, Jumlah Rumah harus berupa angka. Proses ubah profil gagal.");
            RequestDispatcher rdp = request.getRequestDispatcher("pages/profil.jsp");
            rdp.forward(request, response);

        } else {         
            pengguna.setPassword(password);
            pengguna.setNmPengguna(nmPengguna);
            pengguna.setRtPengguna(rtPengguna);
            pengguna.setRwPengguna(rwPengguna);
            pengguna.setKelurahanPengguna(kelurahanPengguna);
            pengguna.setKecamatanPengguna(kecamatanPengguna);
            pengguna.setKotaPengguna(kotaPengguna);
            pengguna.setJumlahrumah(jumlahRumah);
            dafPengguna.editPengguna(pengguna); //mengubah record pada tabel pengguna
            session.setAttribute("nmPengguna",pengguna.getEmail()+'/'+pengguna.getNmPengguna());
            response.sendRedirect("Profil");
        }

        /*
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UbahProfilPengguna</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UbahProfilPengguna at " + request.getContextPath () + "</h1>");
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

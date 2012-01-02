/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entity.Akun;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DaftarAkun;

@WebServlet(name = "ProsesRegister", urlPatterns = {"/proses_register"})
public class ProsesRegister extends HttpServlet {

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
            
        DaftarAkun daftar = new DaftarAkun();
        Akun akun = new Akun();
        String jsp ="";
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String ulangPassword = request.getParameter("ulangpassword");
	String username = request.getParameter("username");
	String rtakun = request.getParameter("rt_akun");
	String rwakun = request.getParameter("rw_akun");
	String kelurahanakun = request.getParameter("kelurahan_akun");
        String kecamatanakun = request.getParameter("kecamatan_akun");
	String kotaakun = request.getParameter("kota_akun");
	String jumlahrumah = request.getParameter("jumlah_rumah");
	
       

        //validasi masukan
        if (email.isEmpty() || password.isEmpty() || ulangPassword.isEmpty()) {//validasi isian masukan (kosong/tidak)
            request.setAttribute("error", "Mohon isi form dengan lengkap !");
            RequestDispatcher rdp = request.getRequestDispatcher("register");
            rdp.forward(request, response);

        } else if (email.indexOf("@") == -1 || email.indexOf(".") == -1) {//validasi format email
            request.setAttribute("error", "Mohon isi form dengan lengkap !");
            RequestDispatcher rdp = request.getRequestDispatcher("register");
            rdp.forward(request, response);

        } else if (password.length() < 8) { //validasi panjang password
            request.setAttribute("error", "Panjang password minimal 8 karakter");
            RequestDispatcher rdp = request.getRequestDispatcher("register");
            rdp.forward(request, response);

        } else if (!password.equals(ulangPassword)) {//validasi password dan konfirm password (sama/tidak)
            request.setAttribute("error", "Password dan konfirmasi password yang dimasukkan tidak sama");
            RequestDispatcher rdp = request.getRequestDispatcher("register");
            rdp.forward(request, response);

        } /*else if (daftar.checkEmail(email) == true) { //validasi apakah email sudah perna terdaftar
            request.setAttribute("error", "Email anda sudah terdaftar, gunakan email lainyya");
            RequestDispatcher rdp = request.getRequestDispatcher("register");
            rdp.forward(request, response);

        } else if (daftar.checkUsername(username) == true) { //validasi apakah email sudah perna terdaftar
            request.setAttribute("error", "Username anda sudah terdaftar, gunakan username lainyya");
            RequestDispatcher rdp = request.getRequestDispatcher("register");
            rdp.forward(request, response);

        } */
            else { //jika tidak ada error, menambah record akun
                              
            akun.setEmail(email);
            akun.setPassword(password);
            akun.setUsername(username);
            akun.setRtakun(rtakun);
            akun.setRwakun(rwakun);
            akun.setKelurahanakun(kelurahanakun);
            akun.setKecamatanakun(kecamatanakun);
            akun.setJumlahrumah(jumlahrumah);
            daftar.addAkun(akun);

            HttpSession session = request.getSession(true);//setelah registrasi berhasil, langsung login
            session.setAttribute("idAkun", akun.getId());
            session.setAttribute("loged", akun);
            session.setAttribute("username", akun.getEmail() + '/' + akun.getUsername());        
            
            
            }
            response.sendRedirect("profil_akun");
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

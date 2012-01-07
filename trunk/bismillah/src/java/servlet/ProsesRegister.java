/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entity.Pengguna;
import entity.DaftarPengguna;
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
@WebServlet(name = "ProsesRegister", urlPatterns = {"/ProsesRegister"})
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
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String ulangiPassword = request.getParameter("ulangipassword");
        String nmPengguna ="";
        int rtPengguna = 0;
        int rwPengguna = 0;
        String kelurahanPengguna ="";
        String kecamatanPengguna ="";
        String kotaPengguna ="";
        int jumlahrumah =0;

        DaftarPengguna daftar = new DaftarPengguna();
        Pengguna pengguna = new Pengguna();

        //validasi
        if (email.isEmpty() || password.isEmpty() || ulangiPassword.isEmpty()) {//validasi isian masukan (kosong/tidak)
            request.setAttribute("error", "Maaf, Anda belum mengisi form dengan lengkap. Silahkan ulangi kembali.");
            RequestDispatcher rdp = request.getRequestDispatcher("pages/register.jsp");
            rdp.forward(request, response);

        } else if (email.indexOf("@") == -1 || email.indexOf(".") == -1) {//validasi format email
            request.setAttribute("error", "AMaaf, format email yang dimasukkan salah");
            RequestDispatcher rdp = request.getRequestDispatcher("pages/register.jsp");
            rdp.forward(request, response);

        } else if (password.length() < 6) { //validasi panjang password
            request.setAttribute("error", "Maaf, password minimal 6 karakter");
            RequestDispatcher rdp = request.getRequestDispatcher("pages/register.jsp");
            rdp.forward(request, response);

        } else if (!password.equals(ulangiPassword)) {//validasi password dan konfirm password (sama/tidak)
            request.setAttribute("error", "Maaf, password dan konfirmasi password yang dimasukkan salah");
            RequestDispatcher rdp = request.getRequestDispatcher("pages/register.jsp");
            rdp.forward(request, response);

        } else if (daftar.checkEmail(email) == true) { //validasi apakah email sudah perna terdaftar
            request.setAttribute("error", "Maaf, email yang Anda masukkan sudah terdaftar");
            RequestDispatcher rdp = request.getRequestDispatcher("pages/register.jsp");
            rdp.forward(request, response);

        } else { //jika tidak ada error, menambah record masjid
            pengguna.setEmail(email);
            pengguna.setPassword(password);
            pengguna.setNmPengguna(nmPengguna);
            pengguna.setRtPengguna(rtPengguna);
            pengguna.setRwPengguna(rwPengguna);
            pengguna.setKelurahanPengguna(kelurahanPengguna);
            pengguna.setKecamatanPengguna(kecamatanPengguna);
            pengguna.setKotaPengguna(kotaPengguna);
            pengguna.setJumlahrumah(jumlahrumah);
            daftar.addPengguna(pengguna);

            HttpSession session = request.getSession(true);//setelah registrasi berhasil, langsung login
            session.setAttribute("idPengguna", pengguna.getId());
            session.setAttribute("loged", pengguna);
            session.setAttribute("nmPengguna", pengguna.getEmail() + '/' + pengguna.getNmPengguna());
            response.sendRedirect("Profil");
        }
        
        /*try {
            response.sendRedirect("Profil");
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

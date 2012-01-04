/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entity.Akun;
import entity.DaftarAkun;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class Register extends HttpServlet {

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
                    
        RequestDispatcher dis = null;
        //String message = null;
        
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String rtakun = request.getParameter("rtakun");
        String rwakun = request.getParameter("rwakun");
        String kelurahanakun = request.getParameter("kelurahanakun");
        String kecamatanakun = request.getParameter("kecamatanakun");
        String kotaakun = request.getParameter("kotaakun");
        String jumlahrumah = request.getParameter("jumlahrumah");
        //int status = 0;

        Akun akun = new Akun();
        RequestDispatcher page = null;
        DaftarAkun daftar = new DaftarAkun();

         if (email.equals("") || username.equals("")|| password.equals("") || rtakun.equals("") || rwakun.equals("") || kelurahanakun.equals("") || kecamatanakun.equals("") || kotaakun.equals("") || jumlahrumah.equals("")) {
            request.setAttribute("error", "Mohon isi form dengan lengkap !");
            RequestDispatcher rdp = request.getRequestDispatcher("/sior/register.jsp");
            rdp.forward(request, response);

        }
        else{
                boolean hasilCheck = daftar.checkAkun(username);
                if (!hasilCheck) {
                    akun.setEmail(email);
                    akun.setUsername(username);
                    akun.setPassword(password);
                    akun.setRtkakun(rtakun);
                    akun.setRwakun(rwakun);
                    akun.setKelurahanakun(kelurahanakun);
                    akun.setKecamatanakun(kecamatanakun);
                    akun.setKotaakun(kotaakun);
                    akun.setJumlahrumah(jumlahrumah);
                    daftar.addAkun(akun);
                    response.sendRedirect("RegisterBerhasil");
                } else {
                   //out.println("Username telah terdaftar");
                    request.setAttribute("error", "Gagal melakukan register. Silahkan ulangi !");
                    RequestDispatcher rdp = request.getRequestDispatcher("/sior/register.jsp");
                    rdp.forward(request, response);
                }

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
        
        /* String destination = "/register.jsp";

        RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
        rd.forward(request, response);*/
        
        
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

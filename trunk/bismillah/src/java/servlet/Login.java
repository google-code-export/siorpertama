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
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

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

        DaftarPengguna dafPengguna = new DaftarPengguna();
        Pengguna pengguna = dafPengguna.getPengguna(email, password);

        if (email.isEmpty() || password.isEmpty()) {
            request.setAttribute("errorLogin", "Maaf Email atau Password Tidak Boleh Kosong");
            RequestDispatcher rdp = request.getRequestDispatcher("index.jsp");
            rdp.forward(request, response);
         //validasi format email   
        }else if (email.indexOf("@")==-1||email.indexOf(".")==-1){
            request.setAttribute("errorLogin","Maaf, format email salah");
            RequestDispatcher rdp = request.getRequestDispatcher("index.jsp");
            rdp.forward(request, response);
        } else if (dafPengguna.check(email, password) == false) {
            request.setAttribute("errorLogin", "Maaf, email atau password salah");
            RequestDispatcher rdp = request.getRequestDispatcher("index.jsp");
            rdp.forward(request, response);
        } else {

            HttpSession session = request.getSession(true);
            session.setAttribute("idPengguna", pengguna.getId());
            session.setAttribute("loged", pengguna);
            session.setAttribute("nmPengguna",pengguna.getEmail()+'('+pengguna.getNmPengguna()+')');

            RequestDispatcher rdp = request.getRequestDispatcher("pages/homeutama.jsp");
            rdp.forward(request, response);
        }
        
        /*
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Login</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Login at " + request.getContextPath () + "</h1>");
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

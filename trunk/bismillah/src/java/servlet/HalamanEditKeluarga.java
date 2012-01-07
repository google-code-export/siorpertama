/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entity.DaftarKeluarga;
import entity.DaftarPengguna;
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
@WebServlet(name = "HalamanEditKeluarga", urlPatterns = {"/HalamanEditKeluarga"})
public class HalamanEditKeluarga extends HttpServlet {

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
        Long idPengguna = pengguna.getId();
        
        DaftarPengguna dafPengguna = new DaftarPengguna();
        Pengguna pengguna2 = dafPengguna.findPengguna(idPengguna);
        
        request.setAttribute("pengguna", pengguna2);
        
        
        Long idKel=Long.parseLong(request.getParameter("idKel"));
        
        DaftarKeluarga daf=new DaftarKeluarga();
        Keluarga keluarga=daf.getKeluarga(idKel);
        
        HttpSession sessionedit=request.getSession();
        sessionedit.setAttribute("keluarga", keluarga);
        request.setAttribute("keluarga", keluarga);
        
        RequestDispatcher rdp = request.getRequestDispatcher("pages/editkeluarga.jsp");
            rdp.forward(request, response);
        
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HalamanEditKeluarga</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HalamanEditKeluarga at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
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

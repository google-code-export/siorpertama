/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import comparator.HunianComparator;
import entity.Hunian;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import model.DaftarHunian;

/**
 *
 * @author ntonk
 */
@WebServlet(name = "EditHunian", urlPatterns = {"/EditHunian"})
public class EditHunian extends HttpServlet {

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
            out.println("<title>Servlet EditHunian</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditHunian at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
            DaftarHunian daftarHunian = new DaftarHunian();
            List<Hunian> listHunian = daftarHunian.getHunianid();
            Collections.sort(listHunian, new HunianComparator());
            request.setAttribute("list_hunian", listHunian);
            String jsp = "";
            String cekHunian[] = request.getParameterValues("cek_hunian");
             
            if (cekHunian == null) {
                JOptionPane.showMessageDialog(null, "tidak ada hunian yang dipilih",
                        "Error!",JOptionPane.WARNING_MESSAGE);
                jsp = "halaman/Hunian.jsp";
            } else if (cekHunian.length > 1) {
                JOptionPane.showMessageDialog(null, "Pilih salah satu hunian saja !",
                        "Error!",JOptionPane.WARNING_MESSAGE);
                jsp = "halaman/Hunian.jsp";
            } else {
                String idHunian = (cekHunian[0]);
                Hunian hunian = daftarHunian.findHunian(idHunian);
                request.setAttribute("hunian_edit", hunian);
                jsp = "/halaman/edit_hunian.jsp";
            }
             
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

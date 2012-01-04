/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import comparator.IuranComparator;
import entity.Iuran;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import model.DaftarIuran;

/**
 *
 * @author ntonk
 */
@WebServlet(name = "EditIuran", urlPatterns = {"/EditIuran"})
public class EditIuran extends HttpServlet {

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
            out.println("<title>Servlet EditIuran</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditIuran at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
            DaftarIuran daftarIuran = new DaftarIuran();
            List<Iuran> listIuran = daftarIuran.getIuran();
            Collections.sort(listIuran, new IuranComparator());
            request.setAttribute("list_iuran", listIuran);
            String jsp = "";
            String cekIuran[] = request.getParameterValues("cek_iuran");

            if (cekIuran == null) {
                JOptionPane.showMessageDialog(null, "Iuran tidak ada",
                        "Error!",JOptionPane.WARNING_MESSAGE);
                jsp = "halaman/iuran.jsp";
            } else if (cekIuran.length > 1) {
                JOptionPane.showMessageDialog(null, "Pilih salah satu jenis iuran saja !",
                        "Error!",JOptionPane.WARNING_MESSAGE);
                jsp = "halaman/iuran.jsp";
            } else {
                String kodeiuran = (cekIuran[0]);
                Iuran keluarga = daftarIuran.findIuran(kodeiuran);
                request.setAttribute("Iuran_edit", keluarga);
                jsp = "/halaman/edit_iuran.jsp";
            }

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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import comparator.GajiComparator;
import entity.Gaji;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import model.DaftarGaji;

/**
 *
 * @author ntonk
 */
@WebServlet(name = "EditGaji", urlPatterns = {"/EditGaji"})
public class EditGaji extends HttpServlet {

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
            out.println("<title>Servlet EditGaji</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditGaji at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
            DaftarGaji daftarGaji = new DaftarGaji();
            List<Gaji> listGaji = daftarGaji.getGaji();
            Collections.sort(listGaji, new GajiComparator());
            request.setAttribute("list_gaji", listGaji);
            String jsp = "";
            String cekGaji[] = request.getParameterValues("cek_gaji");

            if (cekGaji == null) {
                JOptionPane.showMessageDialog(null, "Gaji tidak tersedia",
                        "Error!",JOptionPane.WARNING_MESSAGE);
                jsp = "halaman/lihat_gajis.jsp";
            } else if (cekGaji.length > 1) {
                JOptionPane.showMessageDialog(null, "Pilih salah satu gaji !",
                        "Error!",JOptionPane.WARNING_MESSAGE);
                jsp = "halaman/lihat_gajis.jsp";
            } else {
                Integer idGaji = Integer.parseInt(cekGaji[0]);
                Gaji gaji = daftarGaji.findGaji(idGaji);
                request.setAttribute("gaji_edit", gaji);
                jsp = "/halaman/edit_gaji.jsp";
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

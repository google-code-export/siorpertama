/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor
 */
package servlet;

import comparator.IuranComparator;
import entity.Iuran;
import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import model.DaftarIuran;
import model.exceptions.NonexistentEntityException;

/**
 *
 * @author mey
 */
@WebServlet(name = "HapusIuran", urlPatterns = {"/HapusIuran"})
public class HapusIuran extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NonexistentEntityException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HapusIuran</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HapusIuran at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
            DaftarIuran daftarIuran = new DaftarIuran();
            List<Iuran> listIuran = daftarIuran.getIuran();
            Collections.sort(listIuran, new IuranComparator());
            String cekIuran[] = request.getParameterValues("cek_Iuran");
            String jsp = "";

            if (cekIuran == null) {
                JOptionPane.showMessageDialog(null, "Iuran tidak ada yang dipilih",
                        "Kesalahan!",JOptionPane.WARNING_MESSAGE);
                request.setAttribute("list_listIuran", listIuran);
                jsp = "halaman/keluarga_indos.jsp";
            } else {
                int j = JOptionPane.showConfirmDialog(null, "apakah anda yakin akan menghapus ?",
                        JOptionPane.MESSAGE_TYPE_PROPERTY, JOptionPane.YES_NO_OPTION);

                if (j == JOptionPane.YES_OPTION) {
                    for (int i = 0; i < cekIuran.length; i++) {
                        Integer idIuran = Integer.parseInt(cekIuran[i]);
                        Iuran iuran = daftarIuran.findIuran(idIuran);
                        daftarIuran.destroy(idIuran);
                    }
                }
                listIuran = daftarIuran.getIuran();
                Collections.sort(listIuran, new IuranComparator());
                request.setAttribute("list_Iuran", listIuran);
                jsp = "halaman/keluarga_indos.jsp";
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

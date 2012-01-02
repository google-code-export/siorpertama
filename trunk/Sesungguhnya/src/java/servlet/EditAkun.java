/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import comparator.AkunComparator;
import entity.Akun;
import model.DaftarAkun;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author ntonk
 */
@WebServlet(name = "EditAkun", urlPatterns = {"/EditAkun"})
public class EditAkun extends HttpServlet {

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
            out.println("<title>Servlet EditAkun</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditAkun at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
            DaftarAkun daftarAkun = new DaftarAkun();
            List<Akun> listAkun = daftarAkun.getUsername();
            Collections.sort(listAkun, new AkunComparator());
            request.setAttribute("list_akun", listAkun);
            String jsp = "";
            String cekAkun[] = request.getParameterValues("cek_akun");
            
             if (cekAkun == null) {
                JOptionPane.showMessageDialog(null, "Akun tidak ada yang dipilih",
                        "Error!",JOptionPane.WARNING_MESSAGE);
                jsp = "halaman/keluarga_indos.jsp";
            } else if (cekAkun.length > 1) {
                JOptionPane.showMessageDialog(null, "Pilih salah satu akun !",
                        "Error!",JOptionPane.WARNING_MESSAGE);
                jsp = "halaman/keluarga_indos.jsp";
            } else {
                Integer idAkun = Integer.parseInt(cekAkun[0]);
                Akun akun = daftarAkun.findAkun(idAkun);
                request.setAttribute("akun_edit", akun);
                jsp = "/halaman/edit_akun.jsp";
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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import comparator.GajiComparator;
import entity.Gaji;
import java.io.IOException;
import java.util.List;
import java.io.PrintWriter;
import java.util.Collections;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
@WebServlet(name = "ProsesEditGaji", urlPatterns = {"/ProsesEditGaji"})
public class ProsesEditGaji extends HttpServlet {

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
            out.println("<title>Servlet ProsesEditGaji</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProsesEditGaji at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
            DaftarGaji daftarGaji = new DaftarGaji();
            String jsp = "";           

            String idgaji1 = request.getParameter("id_gaji");
            int idgaji = Integer.parseInt(idgaji1);
            
            
            String idGa = request.getParameter("id_edit_gaji");
            Integer idgji = Integer.parseInt(idGa);
            Gaji gaji = daftarGaji.findGaji(idgji);

            if (idgaji1.equals("")) {
                JOptionPane.showMessageDialog(null, "id gaji tidak boleh kosong !",
                        "Kesalahan!",JOptionPane.WARNING_MESSAGE);
                request.setAttribute("gaji_edit", gaji);
                jsp = "halaman/edit_gaji.jsp";
            } else if (idgaji1.equals("")) {
                JOptionPane.showMessageDialog(null, "id gaji tidak boleh kosong !",
                        "Kesalahan!",JOptionPane.WARNING_MESSAGE);
                request.setAttribute("gaji_edit", gaji);
                jsp = "halaman/edit_keluarga.jsp";
            } else if (idgaji1.equals("")) {
                JOptionPane.showMessageDialog(null, "id gaji tidak boleh kosong !",
                        "Kesalahan!",JOptionPane.WARNING_MESSAGE);
                request.setAttribute("gaji_edit", gaji);
                jsp = "halaman/edit_gaji.jsp";      
            } //validate length field
            else if (idgaji1.equalsIgnoreCase("000000")) {
                JOptionPane.showMessageDialog(null, "id gaji tidak boleh bernilai nol !",
                        "Kesalahan!",JOptionPane.WARNING_MESSAGE);
                request.setAttribute("gaji_edit", gaji);
                jsp = "halaman/edit_gaji.jsp";  
            } //validate record on database
            else if (daftarGaji.isKodeExist(idgaji1) && !gaji.isKodeNoChange(idgaji1)) {
                JOptionPane.showMessageDialog(null, "id gaji sudah ada dalam database !",
                        "Kesalahan!",JOptionPane.WARNING_MESSAGE);
                request.setAttribute("gaji_edit", gaji);
                jsp = "halaman/edit_gaji.jsp";
            } //validate nmbankpos on database
             else {
                gaji.setIdgaji(idgaji);
                
              
                daftarGaji.edit(gaji);
                List<Gaji> listGaji = daftarGaji.getGaji();
                listGaji = daftarGaji.getGaji();
                Collections.sort(listGaji, new GajiComparator());
                request.setAttribute("list_gaji", listGaji);
                jsp = "halaman/lihat_gajis.jsp";
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

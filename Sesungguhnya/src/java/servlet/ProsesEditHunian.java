/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import comparator.HunianComparator;
import entity.Hunian;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DaftarHunian;
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
import model.exceptions.NonexistentEntityException;
import model.exceptions.RollbackFailureException;

/**
 *
 * @author ntonk
 */
@WebServlet(name = "ProsesEditHunian", urlPatterns = {"/ProsesEditHunian"})
public class ProsesEditHunian extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NonexistentEntityException, RollbackFailureException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProsesEditHunian</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProsesEditHunian at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
            DaftarHunian daftarHunian = new DaftarHunian();
            String jsp = "";           

            String idhunian = request.getParameter("id_hunian");
            String kodehunian = request.getParameter("kode_hunian");
           
            
            
            String idhuni = request.getParameter("id_edit_hunian");
            Integer idHuni = Integer.parseInt(idhuni);
            Hunian hunian = daftarHunian.findHunian(idhuni);
            if (idhunian.equals("")) {
                JOptionPane.showMessageDialog(null, "id hunian harus diisi !",
                        "Error!",JOptionPane.WARNING_MESSAGE);
                request.setAttribute("hunian_edit", hunian);
                jsp = "halaman/edit_hunian.jsp";
            } else if (kodehunian.equals("")) {
                JOptionPane.showMessageDialog(null, "kode hunian harus diisi !",
                        "Error!",JOptionPane.WARNING_MESSAGE);
                request.setAttribute("hunian_edit", hunian);
                jsp = "halaman/edit_hunian.jsp";
            } //validate length field
            else if (idhunian.equalsIgnoreCase("000000")) {
                JOptionPane.showMessageDialog(null, "kode hunian tidak boleh bernilai nol !",
                        "Error!",JOptionPane.WARNING_MESSAGE);
                request.setAttribute("hunian_edit", hunian);
                jsp = "halaman/edit_hunian.jsp";  
            } //validate record on database
           // else if (daftarakun.isKodeExist && !username.isKodeNoChange(kdkeluarga)) {
               // JOptionPane.showMessageDialog(null, "Kode Keluarga sudah ada dalam database !",
               //         "Kesalahan!",JOptionPane.WARNING_MESSAGE);
               // request.setAttribute("keluarga_edit", keluarga);
               // jsp = "halaman/edit_keluarga.jsp";
           // } //validate nmbankpos on database
              else {
                hunian.setIdHunian(idhunian);
                hunian.setKodehunian(kodehunian);
                
                daftarHunian.editHunian(hunian);
                List<Hunian> listHunian = daftarHunian.getHunianid();
                listHunian = daftarHunian.getHunianid();
                Collections.sort(listHunian, new HunianComparator());
                request.setAttribute("list_hunian", listHunian);
                jsp = "halaman/daftarhunian.jsp";
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
        try {
            processRequest(request, response);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ProsesEditHunian.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RollbackFailureException ex) {
            Logger.getLogger(ProsesEditHunian.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ProsesEditHunian.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ProsesEditHunian.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RollbackFailureException ex) {
            Logger.getLogger(ProsesEditHunian.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ProsesEditHunian.class.getName()).log(Level.SEVERE, null, ex);
        }
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

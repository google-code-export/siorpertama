/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entity.DaftarGaji;
import entity.Gaji;
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
        
        HttpSession sessionedit=request.getSession();
        
        Pengguna pengguna = (Pengguna) sessionedit.getAttribute("loged");
        Long idPengguna = pengguna.getId();
        
                
        String idgaji = request.getParameter("kode");
        String namapenerima = request.getParameter("nama");
        String jumlahgaji1 = request.getParameter("jumlah");
        
        int jumlahgaji = Integer.parseInt(jumlahgaji1);
        
            
        DaftarGaji daftar = new DaftarGaji();
        Gaji gaji = (Gaji)sessionedit.getAttribute("gaji");

        //validasi masukan
        if (idgaji.isEmpty() || namapenerima.isEmpty() || jumlahgaji1.isEmpty()) {//validasi isian masukan (kosong/tidak)
            request.setAttribute("error", "Maaf, data gaji gagal disimpan. Semua kolom harus diisi. ");
            RequestDispatcher rdp = request.getRequestDispatcher("pages/editgaji.jsp");
            rdp.forward(request, response);

        } else if (!jumlahgaji1.matches("[0-9]*")) { //validasi input jumlah gaji harus angka
            request.setAttribute("error", "Maaf, data gaji gagal disimpan. Jumlah gaji harus berupa angka.");
            RequestDispatcher rdp = request.getRequestDispatcher("pages/editgaji.jsp");
            rdp.forward(request, response);

        } else {
            //request.setAttribute("pesanberhasil", "Alhamdulillah ya, data pengurus berhasil disimpan.");
            gaji.setIdgaji(idgaji);
            gaji.setNamapenerima(namapenerima);
            gaji.setJumlahgaji(jumlahgaji);
            daftar.editGaji(gaji);
            response.sendRedirect("HalamanGaji");
        }
        
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

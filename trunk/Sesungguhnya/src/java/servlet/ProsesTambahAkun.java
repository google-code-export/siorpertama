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
 * @author Lia
 */
@WebServlet(name = "ProsesTambahAkun", urlPatterns = {"/proses_tambah_akun"})
public class ProsesTambahAkun extends HttpServlet {

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
            out.println("<title>Servlet ProsesTambahKeluargaindo</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProsesTambahKeluargaindo at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
            
            Akun akun = new Akun();
            DaftarAkun daftarAkun = new DaftarAkun();
            String jsp = "";

String email = request.getParameter("email");
        String password = request.getParameter("password");
        String ulangPassword = request.getParameter("ulangpassword");
	String username = request.getParameter("username");
	String rtakun = request.getParameter("rt_akun");
	String rwakun = request.getParameter("rw_akun");
	String kelurahanakun = request.getParameter("kelurahan_akun");
        String kecamatanakun = request.getParameter("kecamatan_akun");
	String kotaakun = request.getParameter("kota_akun");
	String jumlahrumah = request.getParameter("jumlah_rumah");
        
            //validate blank field
            if (email.isEmpty() || password.isEmpty() || ulangPassword.isEmpty()) {//validasi isian masukan (kosong/tidak)
            request.setAttribute("error", "Mohon isi form dengan lengkap !");
            RequestDispatcher rdp = request.getRequestDispatcher("register");
            rdp.forward(request, response);

        } else if (email.indexOf("@") == -1 || email.indexOf(".") == -1) {//validasi format email
            request.setAttribute("error", "Mohon isi form dengan lengkap !");
            RequestDispatcher rdp = request.getRequestDispatcher("register");
            rdp.forward(request, response);

        } else if (password.length() < 8) { //validasi panjang password
            request.setAttribute("error", "Panjang password minimal 8 karakter");
            RequestDispatcher rdp = request.getRequestDispatcher("register");
            rdp.forward(request, response);

        } else if (!password.equals(ulangPassword)) {//validasi password dan konfirm password (sama/tidak)
            request.setAttribute("error", "Password dan konfirmasi password yang dimasukkan tidak sama");
            RequestDispatcher rdp = request.getRequestDispatcher("register");
            rdp.forward(request, response);

            } else {
                akun.setEmail(email);
                akun.setUsername(username);
                akun.setPassword(password);
                akun.setRtakun(rtakun);
                akun.setRwakun(rwakun);
                akun.setKelurahanakun(kelurahanakun);
                akun.setKecamatanakun(kecamatanakun);
                akun.setKotaakun(kotaakun);
                akun.setJumlahrumah(jumlahrumah);
                daftarAkun.addAkun(akun);               
                jsp = "registerberhasil.jsp";
            }

            //List<Keluargaindo> listKeluarga = daftarKeluarga.getKeluarga();
            //Collections.sort(listKeluarga, new KeluargaindoComparator());
            //request.setAttribute("list_keluargaindo", listKeluarga);
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

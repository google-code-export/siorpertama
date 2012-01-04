/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import comparator.WargaComparator;
import entity.Warga;
import model.DaftarWarga;
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


/**
 *
 * @author Lia
 */
@WebServlet(name = "ProsesTambahWarga", urlPatterns = {"/proses_tambah_warga"})
public class ProsesTambahWarga extends HttpServlet {

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
            out.println("<title>Servlet ProsesTambahWarga</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProsesTambahWarga at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
            
            Warga warga = new Warga();
            DaftarWarga daftarWarga = new DaftarWarga();
            String jsp = "";

            String kodewarga = request.getParameter("kode_warga");
            String namalengkap = request.getParameter("nama_lengkap");
            String alamatktp = request.getParameter("alamat_ktp");
            String tempatlahir = request.getParameter("tempat_lahir");
            String tanggallahir = request.getParameter("tanggal_lahir");
            String rtktp = request.getParameter("rt_ktp");
            String rwktp = request.getParameter("rw_ktp");
            String kelurahanktp = request.getParameter("kelurahan_ktp");
            String kecamatanktp = request.getParameter("kecamatan_ktp");
            String kotaktp = request.getParameter("kota_ktp");
            String kewarganegaraan = request.getParameter("kewarganegaraan");
                       
            int noktp = Integer.parseInt("kodewarga");
        
            //validate blank field
         if (kodewarga.isEmpty() || namalengkap.isEmpty() || alamatktp.isEmpty() 
                 || rtktp.isEmpty() || rwktp.isEmpty() || kelurahanktp.isEmpty() 
                 || kecamatanktp.isEmpty() || kotaktp.isEmpty() || tempatlahir.isEmpty()
                 || tanggallahir.isEmpty() || kewarganegaraan.isEmpty()) {//validasi isian masukan (kosong/tidak)
            request.setAttribute("error", "Mohon isi form dengan lengkap !");
            RequestDispatcher rdp = request.getRequestDispatcher("tambah_warga");
            rdp.forward(request, response);

        } else if (kodewarga.equalsIgnoreCase("000000")) { 
            request.setAttribute("error", "Kode Warga Tida Boleh Bernilai 00000 !");
            RequestDispatcher rdp = request.getRequestDispatcher("tambah_keluarga");
            rdp.forward(request, response);
        } else if (daftarWarga.isKodeExist(kodewarga)) {
            request.setAttribute("error", "Kode kodewarga telah terpakai !");
            RequestDispatcher rdp = request.getRequestDispatcher("tambah_keluarga");
            rdp.forward(request, response);
        } else {
                warga.setNoktp(noktp);
                warga.setNamalengkap(namalengkap);
                warga.setTempatlahir(tempatlahir);
                warga.setTanggallahir(tanggallahir);
                warga.setAlamat(alamatktp);
                warga.setRtktp(rtktp);
                warga.setRwktp(rwktp);
                warga.setKelurahanktp(kelurahanktp);
                warga.setKecamatanktp(kecamatanktp);
                warga.setKotaktp(kotaktp);
                warga.setKewarganegaraanktp(kewarganegaraan);
                daftarWarga.tambahWarga(warga);
                
                jsp = "halaman/daftar_warga.jsp";
            }

            List<Warga> listWarga = daftarWarga.getWarga();
            Collections.sort(listWarga, new WargaComparator());
            request.setAttribute("list_keluargaindo", listWarga);
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

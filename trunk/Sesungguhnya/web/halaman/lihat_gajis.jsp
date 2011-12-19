<%-- 
    Document   : bank_pos
    Created on : Nov 15, 2011, 9:08:49 AM
    Author     : AlfieSaHid
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="model.DaftarGaji"%>
<%@page import="entity.Gaji"%>

<% List<Gaji> listGaji = (List<Gaji>) request.getAttribute("list_gaji");%>
<% Gaji gaji;%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Keluarga</title>
        
    </head>

    <body>        
        <div class="container">
            <div class="sidebar1">
                <p><strong>RT</strong></p> 
                <ul class="nav">
                    <li><a href="warga">Warga</a></li>
                    <li><a href="keluarga_indo">Keluarga</a></li>
                    <li><a href="hunian">Hunian</a></li>
                </ul>
                <p><strong>Keuangan</strong></p>
                <ul class="nav">
                    <li><a href="iuran">Iuran</a></li>
					<li><a href="gaji">Gaji</a></li>
                </ul>
                <p></p>
                <p></p>
                <p></p>
                <!-- end .sidebar1 --></div>
            
			<div class="content">
                <center><p ><h3>Gaji</h3></p>
                <% Iterator<Gaji> iterator = listGaji.iterator();%>
                <center><form >
                    <p style="margin: 10px;"><BR>
                            <table id="rounded-corner">
                                <thead>
                                    <tr>
                                        <th scope="col" class="rounded-company">Kode Bayar</th>
                                        <th scope="col" class="rounded-q1">Pekerja</th>
                                        <th scope="col" class="rounded-q2">Jenis</th>
                                        <th scope="col" class="rounded-q3">Bulan Gaji</th>
					<th scope="col" class="rounded-q4">Tahun Gaji</th>
                                        <th scope="col" class="rounded-q5">Cek</th>                        
                                    </tr>
                                </thead>
                                <tbody>
                                    <% while (iterator.hasNext()) {
                            gaji = iterator.next();%>
                                    <tr>
                                        <td><%=gaji.getKodebayar()%></td>
                                        <td><%=gaji.getPenerimagaji()%></td>
                                        <td><%=gaji.getJenisgaji()%></td>
                                        <td><%=gaji.getBulangaji()%></td>										<td><%=keluargaindo.getAnggotakel()%></td>
                                        <td><%=gaji.getTahungaji()%></td>
                                        <td><input  type="checkbox"  name="cek_gaji" value="<%=gaji.getIdgaji()%>"></td>                                        
                                        <td><a href="edit_gaji"><input name="butto42" type="button" value="edit"/></a></td>
                                    </tr>
                                    <%}%>
                                </tbody>
                            </table>
                            <span style="margin: 10px;">
                            </span>
                            <p style="margin: 10px;"><BR>
                                    <a href="tambah_gaji"><input name="button1" type="button" value="tambah"/></a>
                                    <a href="edit_gaji"><input name="button2" type="button" value="edit"/></a>
                                    <a href="hapus_gaji"><input name="button3" type="button" value="hapus"/></a>
                                    </form></center>                                    
            <!-- end .content --></div>
        <!-- end .container --></div>
    </body>
</html>
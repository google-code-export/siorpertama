<%-- 
    Document   : bank_pos
    Created on : Nov 15, 2011, 9:08:49 AM
    Author     : AlfieSaHid
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="model.DaftarKeluargaindo"%>
<%@page import="entity.Keluargaindo"%>

<% List<Keluargaindo> listKeluarga = (List<Keluargaindo>) request.getAttribute("list_keluargaindo");%>
<% Keluargaindo keluargaindo;%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Keluarga</title>
        <![endif]-->
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
                <center><p ><h3>Keluargaindo</h3></p>
                <% Iterator<Keluargaindo> iterator = listKeluarga.iterator();%>
                <center><form >
                    <p style="margin: 10px;"><BR>
                            <table id="rounded-corner">
                                <thead>
                                    <tr>
                                        <th scope="col" class="rounded-company">Kode Keluarga</th>
                                        <th scope="col" class="rounded-q1">Kepala Keluarga</th>
										<th scope="col" class="rounded-q2">Anggota Keluarga</th>
                                        <th scope="col" class="rounded-q4">Cek</th>                        
                                    </tr>
                                </thead>
                                <tbody>
                                    <% while (iterator.hasNext()) {
                            keluargaindo = iterator.next();%>
                                    <tr>
                                        <td><%=keluargaindo.getKodekel()%></td>
                                        <td><%=keluargaindo.getKeplakel()%></td>
										<td><%=keluargaindo.getAnggotakel()%></td>
                                        <td><input  type="checkbox"  name="cek_keluarga" value="<%=keluargaindo.getIdkel()%>"></td>                                        
                                    </tr>
                                    <%}%>
                                </tbody>
                            </table>
                            <span style="margin: 10px;">
                            </span>
                            <p style="margin: 10px;"><BR>
                                    <a href="tambah_keluarga"><input name="button1" type="button" value="tambah"/></a>
                                    <a href="edit_keluargaindo"><input name="button2" type="button" value="edit"/></a>
                                    <a href="hapus_keluarga"><input name="button3" type="button" value="hapus"/></a>
                                    </form></center>                                    
            <!-- end .content --></div>
        <!-- end .container --></div>
    </body>
</html>
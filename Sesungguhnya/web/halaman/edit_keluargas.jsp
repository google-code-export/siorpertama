<%-- 
    Document   : edit_bank_pos
    Created on : Nov 26, 2011, 12:11:26 PM
    Author     : AlfieSaHid
--%>
<%@page import="model.DaftarKeluargaindo"%>
<%@page import="entity.Keluargaindo"%>
<%@page import="javax.swing.JOptionPane"%>

<% Keluargaindo keluarga = (Keluargaindo) request.getAttribute("keluarga_edit");%>

<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title> Edit Keluarga </title>
       
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
                <center><p><h3> Edit Keluarga</h3></p>
                    <form name="form_edit_keluarga" action="proses_edit_keluarga" method="post" >
                        <table width="400px">
                            <tr>
                                <td width="150px">Kode Keluarga</td><td>
				<input name="kode_keluarga" type="text" style="width: 50px" value="<%=keluarga.getKodekel()%>"></td>
                            </tr>
                            <tr>
                                <td>Kepala Keluarga</td>
				<td><input type="text" name="kepala_keluarga" style="width: 200px" value="<%=keluarga.getKeplakel()%>"></td>
                            </tr>
							<tr>
                                <td>Anggota Keluarga</td>
				<td><input type="text" name="anggota_keluarga" style="width: 200px" value="<%=keluarga.getAnggotakel()%>"></td>
                            </tr>
                        </table>
                        <p><input type="hidden" name="id_edit_keluarga" value="<%=keluarga.getIdkel()%>"></p>
                        <table width="400px"><tr>
                                <td align="center"><a href="javascript:document.form_edit_keluarga.reset()"><input type="button" name="button" value="Reset"></a>
				<input name="Submit" type="submit" value="Simpan"/> </td>
                            </tr>
                        </table>
                    </form>
                </center>
             <!-- end .content --></div>
         <!-- end .container --></div>
    </body>
</html>
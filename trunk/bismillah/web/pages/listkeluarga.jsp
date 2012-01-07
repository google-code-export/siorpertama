
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entity.DaftarPengguna"%>
<%@page import="entity.Pengguna"%>
<%@page import="entity.DaftarKeluarga"%>
<%@page import="entity.Keluarga"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<% Pengguna pengguna = (Pengguna) request.getAttribute("pengguna");%>
<!DOCTYPE html>
<%@include file='aplikasitemplate.html' %>
<% DaftarKeluarga daftar = new DaftarKeluarga();%>
<% List<Keluarga> keluarga = daftar.getKeluargas(idPengguna);%>
<% Iterator<Keluarga> iterator = keluarga.iterator();%>
<html>

</table>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="mcbg">         
    <tr> 
        <%-- JUDUL DI SINI--%> 
        <td width="700" height="32" class="contentheader"><div align="center"><b>DAFTAR KELUARGA</b></div></td>
    </tr>
    <tr> 
        <td><img src="images/main_content_header_under.gif" width="700" height="26"></td>
    </tr>
    <tr> 
        <td class="mctop"><table width="94%" border="0" cellpadding="0" cellspacing="0">
                <%-- ISI MULAI SINI---%>
                <tr>
                    <td width="10%">&nbsp;</td>
                    <th width="20%" align="left">Kode Keluarga</th>
                    <th>Kepala Keluarga</th>
                    <th>Anggota Keluarga</th>
                    <th align="left">Edit</th>
                    <th align="left">Hapus</th>
                    
                </tr>

                <% while (iterator.hasNext()) {%>
                <% Keluarga next = iterator.next();%>
                <tr>
                    <td>&nbsp;</td>
                    <td><%=next.getKodeKeluarga()%></td>
                    <td><%=next.getKepalaKeluarga()%></td>
                    <td><%=next.getAnggotaKeluarga()%></td>
                    <td bgcolor="#F4F4F4"><a href="HalamanEditKeluarga?idKel=<%=next.getId()%>" > <font color="brown">pilih</font></a></td>
                    <td bgcolor="#F4F4F4"><a href="ProsesHapusKeluarga?idKel=<%=next.getId()%>" > <font color="brown">hapus</font></a></td>
                    
                </tr>
                <%}%>     
                <tr><td>&nbsp;</td></tr>
                
                <%--ISI SAMPAI SINI--%>
            </table></td>
    </tr>
    <tr><td><div align="center"><b><a href="HalamanTambahKeluarga">TAMBAH</a></b></div></td></tr>
    <tr> 
        <td class="mctop"><img src="images/mc_box_bottom.gif" alt="-" width="700" height="23"></td>
    </tr>
</table>
<!-- COPYRIGHT - WWW.ZYMIC.COM - IF YOU REMOVE COPYRIGHT LEGAL ACTION WILL BE TAKEN -->
<!-- WE TRACK COPYRIGHT ON A DAILY BASIS, WE KNOW WHO YOU ARE!                      -->
<div align="center"><a href="http://www.zymic.com" target="_blank"><img src="images/copyright_DO_NOT_STEAL_ELSE_LEGAL_ACTION.gif" alt="Free Templates" width="422" height="15" border="0"></a></div></td>
</tr>
</table>
</body>
</html>


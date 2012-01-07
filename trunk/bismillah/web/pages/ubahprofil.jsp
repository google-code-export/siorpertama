
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entity.DaftarPengguna"%>
<%@page import="entity.Pengguna"%>
<% Pengguna pengguna = (Pengguna) request.getAttribute("pengguna");%>
<!DOCTYPE html>
<%@include file='aplikasitemplate.html' %>
<html>

</table>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="mcbg">         
    <tr> 
        <%-- JUDUL DI SINI--%> 
        <td width="700" height="32" class="contentheader"><div align="center"><b>PROFIL PENGGUNA</b></div></td>
    </tr>
    <tr> 
        <td><img src="images/main_content_header_under.gif" width="700" height="26"></td>
    </tr>
    <tr> 
        <td class="mctop"><table width="94%" border="0" cellpadding="0" cellspacing="0">
                <%-- ISI MULAI SINI---%>
                <form action="UbahProfilPengguna" method="post" >
                    <tr>
                        <td width="10%"><input type="hidden" name="id" value="<%=pengguna.getId()%>" style="width: 160px"></td>
                        <td>Email</td><td><input type="text" name="email" value="<%=pengguna.getEmail()%>" style="width: 160px"></td>
                    </tr>
                    <tr>
                        <td width="10%">&nbsp;</td>
                        <td>Password</td><td><input type="password" name="password" value="<%=pengguna.getPassword()%>" style="width: 120px"></td>
                    </tr>
                    <tr>
                        <td width="10%">&nbsp;</td>
                        <td>Nama Pengguna</td><td><input type="text" name="nmpengguna" value="<%=pengguna.getNmPengguna()%>"style="width: 120px"></td>
                    </tr>
                    <tr>
                        <td width="10%">&nbsp;</td>
                        <td>RT Pengguna</td><td><input type="text" name="rtpengguna" value="<%=pengguna.getRtPengguna()%>" style="width: 120px"></td>
                    </tr>
                    <tr>
                        <td width="10%">&nbsp;</td>
                        <td>RW Pengguna</td><td><input type="text" name="rwpengguna" value="<%=pengguna.getRwPengguna()%>" style="width: 120px"></td>
                    </tr>
                    <tr>
                        <td width="10%">&nbsp;</td>
                        <td>Kelurahan Pengguna</td><td><input type="text" name="kelpengguna" value="<%=pengguna.getKelurahanPengguna()%>" style="width: 120px"></td>
                    </tr>
                    <tr>
                        <td width="10%">&nbsp;</td>
                        <td>Kecamatan Pengguna</td><td><input type="text" name="kecpengguna" value="<%=pengguna.getKecamatanPengguna()%>" style="width: 120px"></td>
                    </tr>
                    <tr>
                        <td width="10%">&nbsp;</td>
                        <td>Kota Pengguna</td><td><input type="text" name="kotapengguna" value="<%=pengguna.getKotaPengguna()%>" style="width: 120px"></td>
                    </tr>
                    <tr>
                        <td width="10%">&nbsp;</td>
                        <td>Jumlah Rumah</td><td><input type="text" name="jmhrumah" value="<%=pengguna.getJumlahrumah()%>" style="width: 120px"></td>
                    </tr>
                    <tr>
                        <td >&nbsp;</td>
                    </tr>
                    <tr>
                        <td width="10%">&nbsp;</td>
                        <td></td><td><input type="submit" value="Simpan" ></td>
                    </tr>
                    <tr>
                        <td >&nbsp;</td>
                    </tr>
                    <tr><td colspan="3" align="center"><label align="center"><font color="red"><b>${errorprofil}</b></font></label></td></tr>
                </form>
                <%--ISI SAMPAI SINI--%>
            </table></td>
    </tr>
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


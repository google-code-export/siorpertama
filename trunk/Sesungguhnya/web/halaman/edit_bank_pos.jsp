<%-- 
    Document   : edit_bank_pos
    Created on : Nov 26, 2011, 12:11:26 PM
    Author     : AlfieSaHid
--%>
<%@page import="model.DaftarBankPosa"%>
<%@page import="entity.BankPos"%>
<%@page import="javax.swing.JOptionPane"%>

<% BankPos bankpos = (BankPos) request.getAttribute("bankpos_edit");%>

<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title> Edit Bank Pos</title>
    </head>

    <body>
        <div class="container">
            <div class="content">
                <center><p><h3> Edit Bank Pos</h3></p>
                    <form name="form_edit_bank_pos" action="proses_edit_bank_pos" method="post" >
                        <table width="400px">
                            <tr>
                                <td width="150px">Kode Bank Pos</td><td><input name="kode_bankpos" type="text" style="width: 30px" value="<%=bankpos.getKdbankpos()%>" size="3" maxlength="3"></td>
                            </tr>
                            <tr>
                                <td>Nama Bank Pos</td><td><input type="text" name="nama_bankpos" style="width: 200px" value="<%=bankpos.getNmbankpos()%>"></td>
                            </tr>
                        </table>
                        <p><input type="hidden" name="id_edit_bankpos" value="<%=bankpos.getId()%>"></p>
                        <table width="400px"><tr>
                                <td align="center"><a href="javascript:document.form_edit_bank_pos.reset()"><img src="images/reset.png" border=0 alt="Reset"></a><input name="Submit" src="images/simpan.png" type="image" value="Simpan" /></td>
                            </tr>
                        </table>
                    </form>
                </center>
             <!-- end .content --></div>
         <!-- end .container --></div>
    </body>
</html>
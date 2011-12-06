<%-- 
    Document   : gui_keuangan iuran1
    Created on : 06 Des 11, 7:03:16
    Author     : ntonk
--%>

<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Untitled Document</title>
<style type="text/css">
#apDiv1 {
	position:absolute;
	left:717px;
	top:40px;
	width:237px;
	height:182px;
	z-index:1;
}
#apDiv2 {
	position:absolute;
	left:716px;
	top:286px;
	width:238px;
	height:26px;
	z-index:2;
}
</style>
<style type="text/css">
#apDiv3 {
	position:absolute;
	left:714px;
	top:330px;
	width:241px;
	height:216px;
	z-index:3;
}
</style>
<style type="text/css">
#apDiv4 {
	position:absolute;
	left:6px;
	top:1050px;
	width:678px;
	height:40px;
	z-index:4;
	text-align: right;
}
#form1 p #Edit {
	text-align: right;
}
p {
	text-align: left;
}
#apDiv5 {
	position:absolute;
	left:10px;
	top:1048px;
	width:46px;
	height:26px;
	z-index:5;
}
</style>
<script type="text/javascript">
function MM_jumpMenuGo(objId,targ,restore){ //v9.0
  var selObj = null;  with (document) { 
  if (getElementById) selObj = getElementById(objId);
  if (selObj) eval(targ+".location='"+selObj.options[selObj.selectedIndex].value+"'");
  if (restore) selObj.selectedIndex=0; }
}
function MM_jumpMenu(targ,selObj,restore){ //v3.0
  eval(targ+".location='"+selObj.options[selObj.selectedIndex].value+"'");
  if (restore) selObj.selectedIndex=0;
}
</script>
</head>

<body>
<div id="apDiv2">
  <form id="form5" name="form5" method="post" action="">
    <select name="jumpMenu" id="jumpMenu">
      <option>Menu Utama</option>
      <option>Menu Keuangan</option>
      <option>Menu Hunian</option>
    </select>
    <input type="button" name="go_button" id= "go_button" value="Go" onclick="MM_jumpMenuGo('jumpMenu','parent',0)" />
  </form>
</div>
<div id="apDiv3">
  <form id="form4" name="form4" method="post" action="">
    <p>Notifikasi Pengguna

      <label for="list"></label>
    </p>
    <table width="244" height="140" border="1">
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
    </table>
    <p>
      <label for="text"></label>
    </p>
  </form>
</div>
<div id="apDiv4">
  <form id="form2" name="form2" method="post" action="">
    <input type="submit" name="First" id="First" value="&lt;&lt;" />
    <input type="submit" name="page1" id="page1" value="2" />
    <input type="submit" name="page2" id="page2" value="3" />
    <input type="submit" name="page3" id="page3" value="4" />
    <input type="submit" name="page4" id="page4" value="5" />
<input type="submit" name="Last" id="Last" value="&gt;&gt;" />
  </form>
</div>
<div id="apDiv5">
  <form id="form3" name="form3" method="post" action="">
    <input type="submit" name="go" id="go" value="GO" />
  </form>
</div>
<img src="http://i1010.photobucket.com/albums/af230/ntonk59/Untitled-1.png" width="691" height="220" /><p></p>
 <form id="form1" name="form1" method="post" action="">
   <p>SiOR Keuangan Iuran</p>
   <p>Pilih jenis iuran yang diinginkan,</p>
   <p>
     <select name="jumpMenu2" size="1" multiple="multiple" id="jumpMenu2">
       <option>Iuran Kas</option>
       <option selected="selected">Iuran Kebersihan</option>
       <option>Iuran Keamanan</option>
       <option>Iuran Arisan</option>
     </select>
     <input type="button" name="go_button2" id= "go_button2" value="Go" onclick="MM_jumpMenuGo('jumpMenu2','parent',0)" />
   </p>
   <p>&nbsp;</p>
</form>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<div id="apDiv1">
    <table width="236" height="184" border="1">
      <tr>
        <td width="114" height="56">01-Dec-2011 5:02 PM</td>
        <td width="106" rowspan="3" align="center"> Foto User </td>
      </tr>
      <tr>
        <td height="68"><p>Selamat Datang <a href="#">User</a> !</p></td>
      </tr>
      <tr>
        <td height="50"><input type="submit" name="So" id="So" value="Keluar" /></td>
      </tr>
    </table>
</div>
</body>
</html>
